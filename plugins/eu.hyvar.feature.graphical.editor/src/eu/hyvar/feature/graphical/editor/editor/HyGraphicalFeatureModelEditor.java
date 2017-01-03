package eu.hyvar.feature.graphical.editor.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicFactoryImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.FileEditorInput;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.actions.HyLinearTemporalElementChangeValidityAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateBooleanAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateEnumAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateNumberAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateStringAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeRenameAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyNumberAttributeSetNumberRangeAction;
import eu.hyvar.feature.graphical.editor.actions.enumeration.HyFeatureAttributeEnumCreateEnumAction;
import eu.hyvar.feature.graphical.editor.actions.enumeration.HyFeatureAttributeEnumCreateLiteralAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureChangeTypeAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateSiblingAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditNamesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEvolutionCreateChildAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToAlternativeTypeAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToAndTypeAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToOrTypeAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateSuccessorAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateVersionAction;
import eu.hyvar.feature.graphical.editor.factory.HyFeatureModelEditorEditPartFactory;

@SuppressWarnings("restriction")
public class HyGraphicalFeatureModelEditor extends HyGraphicalFeatureModelViewer{
	@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}
	
	public void executeCommand(Command command) {
		System.out.println(command);
		CommandStack commandStack = getCommandStack();
		commandStack.execute(command);
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		if(resource == null) return;

		try{
			saveLayout();
			
			resource.save(null);
	        file.touch(null);
			getCommandStack().markSaveLocation();

			
		}catch(IOException e){
			e.printStackTrace();
			resource = null;
		}catch(CoreException e){
			e.printStackTrace();
		}		
	}



	

	protected KeyHandler getCommonKeyHandler() {
		sharedKeyHandler = super.getCommonKeyHandler();
		
		if (sharedKeyHandler == null) {
			sharedKeyHandler = new KeyHandler();
			sharedKeyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0), 
					getActionRegistry().getAction(
							ActionFactory.DELETE.getId()));
		}
		
		return sharedKeyHandler;
	}


	/**
	 * Hook the evolution factory into the editor logic and override the standard edit part factory
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new HyFeatureModelEditorEditPartFactory(viewer, this));
		viewer.setContextMenu(new HyGraphicalFeatureModelEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry()));
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer).setParent(getCommonKeyHandler()));
	}
	
	@Override
	protected void loadModelFromFile(IFile file){
		super.loadModelFromFile(file);
		
		openEditorForFileExtension("hyconstraints");
		openEditorForFileExtension("hycontextinformation");
		openEditorForFileExtension("hyvalidityformula");
	}
	
	private void saveLayout(){

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension("hylayout");

		String fileContent = "";
		for(HyFeatureWrapped feature : this.getModelWrapped().getFeatures(null)){
			fileContent += feature.getWrappedModelElement().getId()+","+feature.getPosition(null).x()+","+feature.getPosition(null).y()+"\n";
		}

		IFile file = workspaceRoot.getFile(path);

		InputStream source = new ByteArrayInputStream(fileContent.getBytes());
		try {
			if(!file.exists()){
				file.create(source, IResource.NONE, null);
			}else{
				file.setContents(source, IResource.FORCE, null);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("unchecked")
	protected void createGroupActions(){
		HyGroupChangeGroupTypeToAlternativeTypeAction groupChangeTypeToAlternativeAction = new HyGroupChangeGroupTypeToAlternativeTypeAction(this);
		getActionRegistry().registerAction(groupChangeTypeToAlternativeAction);
		getSelectionActions().add(groupChangeTypeToAlternativeAction.getId());
		
		HyGroupChangeGroupTypeToAndTypeAction groupChangeTypeToAndAction = new HyGroupChangeGroupTypeToAndTypeAction(this);
		getActionRegistry().registerAction(groupChangeTypeToAndAction);
		getSelectionActions().add(groupChangeTypeToAndAction.getId());
		
		HyGroupChangeGroupTypeToOrTypeAction groupChangeTypeToOrAction = new HyGroupChangeGroupTypeToOrTypeAction(this);
		getActionRegistry().registerAction(groupChangeTypeToOrAction);
		getSelectionActions().add(groupChangeTypeToOrAction.getId());
	}
	
	@SuppressWarnings("unchecked")
	protected void createEnumActions(){
		HyFeatureAttributeEnumCreateEnumAction createEnumAction = new HyFeatureAttributeEnumCreateEnumAction(this);
		getActionRegistry().registerAction(createEnumAction);
		getSelectionActions().add(createEnumAction.getId());
		
		HyFeatureAttributeEnumCreateLiteralAction createLiteralAction = new HyFeatureAttributeEnumCreateLiteralAction(this);
		getActionRegistry().registerAction(createLiteralAction);
		getSelectionActions().add(createLiteralAction.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createActions(){
		HyAttributeCreateNumberAction attributeCreateNumberAction = new HyAttributeCreateNumberAction(this);
		getActionRegistry().registerAction(attributeCreateNumberAction);
		getSelectionActions().add(attributeCreateNumberAction.getId());

		HyAttributeCreateStringAction attributeCreateStringAction = new HyAttributeCreateStringAction(this);
		getActionRegistry().registerAction(attributeCreateStringAction);
		getSelectionActions().add(attributeCreateStringAction.getId());

		HyAttributeCreateBooleanAction attributeCreateBooleanAction = new HyAttributeCreateBooleanAction(this);
		getActionRegistry().registerAction(attributeCreateBooleanAction);
		getSelectionActions().add(attributeCreateBooleanAction.getId());
		
		HyAttributeCreateEnumAction attributeCreateEnumAction = new HyAttributeCreateEnumAction(this);
		getActionRegistry().registerAction(attributeCreateEnumAction);
		getSelectionActions().add(attributeCreateEnumAction.getId());		
		
		HyFeatureEvolutionCreateChildAction childAction = new HyFeatureEvolutionCreateChildAction(this);
		getActionRegistry().registerAction(childAction);
		getSelectionActions().add(childAction.getId());
		
		HyFeatureCreateSiblingAction siblingAction = new HyFeatureCreateSiblingAction(this);
		getActionRegistry().registerAction(siblingAction);
		getSelectionActions().add(siblingAction.getId());		
		
		HyFeatureChangeTypeAction changeAction = new HyFeatureChangeTypeAction(this);
		getActionRegistry().registerAction(changeAction);
		getSelectionActions().add(changeAction.getId());	
		
		HyVersionCreateVersionAction featureCreateVersionAction = new HyVersionCreateVersionAction(this);
		getActionRegistry().registerAction(featureCreateVersionAction);
		getSelectionActions().add(featureCreateVersionAction.getId());

		HyVersionCreateSuccessorAction versionCreateSuccessorAction = new HyVersionCreateSuccessorAction(this);
		getActionRegistry().registerAction(versionCreateSuccessorAction);
		getSelectionActions().add(versionCreateSuccessorAction.getId());
		
		HyLinearTemporalElementChangeValidityAction visibilityAction = new HyLinearTemporalElementChangeValidityAction(this);
		getActionRegistry().registerAction(visibilityAction);
		getSelectionActions().add(visibilityAction.getId());
		
		HyFeatureEditNamesAction featureNameAction = new HyFeatureEditNamesAction(this);
		getActionRegistry().registerAction(featureNameAction);
		getSelectionActions().add(featureNameAction.getId());	
		
		HyAttributeRenameAction renameAttributeAction = new HyAttributeRenameAction(this);
		getActionRegistry().registerAction(renameAttributeAction);
		getSelectionActions().add(renameAttributeAction.getId());
		
		HyNumberAttributeSetNumberRangeAction rangeAttributeAction = new HyNumberAttributeSetNumberRangeAction(this);
		getActionRegistry().registerAction(rangeAttributeAction);
		getSelectionActions().add(rangeAttributeAction.getId());
		
		createGroupActions();
		createEnumActions();
		
		super.createActions();
	}


	

	

	
	
	private MPartStack secondEditor;	
	
	public void insertEditor(float ratio, int where, MPart containerEditor, MPart editorToInsert) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		EModelService service = window.getService(EModelService.class);

		if(secondEditor == null){
			secondEditor = getPartStack(editorToInsert);

			MArea area = getArea(containerEditor);

			MPartSashContainerElement relToElement = area.getChildren().get(0);
			service.insert(secondEditor, relToElement, where, ratio);
		}else{
			secondEditor.getChildren().add(editorToInsert);
		}
	}
	
	private MPartStack getPartStack(MPart childPart) {
		MStackElement stackElement = childPart;
		MPartStack newStack = BasicFactoryImpl.eINSTANCE.createPartStack();
		newStack.getChildren().add(stackElement);
		newStack.setSelectedElement(stackElement);
		return newStack;				
	}

	private MArea getArea(MPart containerPart) {
		MUIElement targetParent = containerPart.getParent();
		while (!(targetParent instanceof MArea))
			targetParent = targetParent.getParent();
		MArea area = (MArea) targetParent;
		return area;
	}	
	
	protected void openEditorForFileExtension(String fileExtension){
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension(fileExtension);

		IFile file = workspaceRoot.getFile(path);
		if(!file.exists()){
			InputStream source = new ByteArrayInputStream("".getBytes());
			try {
				file.create(source, IResource.NONE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		// only open editor if a file exist with the same name as the feature model in same directory
		if(workspaceRoot.exists(path)){
			IFile constraintFile = workspaceRoot.getFile(path);

			IEditorDescriptor desc = PlatformUI.getWorkbench().
					getEditorRegistry().getDefaultEditor(constraintFile.getName());

			if(desc == null){
				System.err.println("No editor for file extension "+fileExtension+" exist");
				return;
			}

			try {
				IEditorPart editor = workbenchPage.openEditor(new FileEditorInput(constraintFile), desc.getId());

				MPart constraintEditorPart = editor.getSite().getService(MPart.class);
				MPart editorPart = this.getSite().getService(MPart.class);

				if (editorPart == null) {
					return;
				}

				insertEditor(0.3f, EModelService.RIGHT_OF, editorPart, constraintEditorPart);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}
}


