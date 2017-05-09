package eu.hyvar.feature.graphical.editor.editor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.FileEditorInput;

import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.analyses.DwFeatureModelAnalyses;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
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
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateChildAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateSiblingAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditNamesAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToAlternativeTypeAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToAndTypeAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToOrTypeAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateSuccessorAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateVersionAction;
import eu.hyvar.feature.graphical.editor.factory.HyFeatureModelEditorEditPartFactory;

@SuppressWarnings("restriction")
public class HyGraphicalFeatureModelEditor extends DwGraphicalFeatureModelViewer{
	List<IPath> relatedEditorFiles = new ArrayList<IPath>();

	@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	public void executeCommand(Command command) {
		CommandStack commandStack = getCommandStack();
		commandStack.execute(command);
		
		
		// TODO for Gil: visualize errors
		DwFeatureModelAnalyses.checkFeatureModelValidity(getInternalFeatureModel());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		Resource resource = this.modelWrapped.getModel().eResource();
		if(resource == null) return;

		try{
			DwFeatureModelLayoutFileUtil.saveLayout(modelWrapped);

			resource.save(null);
			getFile().touch(null);
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

		openEditorForFileExtension(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
		openEditorForFileExtension(HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax());
		openEditorForFileExtension(HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax());
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

		HyFeatureCreateChildAction childAction = new HyFeatureCreateChildAction(this);
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

	@Override
	public void dispose(){
		modelWrapped.getModel().eResource().unload();
		closeRelatedEditors();
	}


	private MPartStack secondEditor;	

	public void insertEditor(float ratio, int where, MPart containerEditor, MPart editorToInsert) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		EModelService service = window.getService(EModelService.class);
		
		if(secondEditor != null)
		System.out.println("====> "+secondEditor.getChildren().size());

		if(secondEditor == null){
			secondEditor = getPartStack(editorToInsert);

			MArea area = getArea(containerEditor);

			MPartSashContainerElement relToElement = area.getChildren().get(0);
			service.insert(secondEditor, relToElement, where, ratio);
		}else{
			if(secondEditor.getChildren().isEmpty()){
				//secondEditor.getParent().getChildren().remove(secondEditor);
				secondEditor = null;
				
				insertEditor(ratio, where, containerEditor, editorToInsert);
			}else{
				secondEditor.getChildren().add(editorToInsert);	
			}
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

	public IPath getPathFromEditorRelatedFile(){
		return ((IPath)getFile().getFullPath().clone());
	}
	public IPath getPathToEditorRelatedFileWithFileExtension(String fileExtension){
		return getPathFromEditorRelatedFile().removeFileExtension().addFileExtension(fileExtension);
	}
	

	
	/**
	 * Opens the default editor for the given file extension side by side with the currently
	 * active editor
	 * @param File extension
	 */
	public void openEditorForFileExtension(String fileExtension){
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IPath path = getPathToEditorRelatedFileWithFileExtension(fileExtension);

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
				IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
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
	
	private void closeRelatedEditors(){
		IEditorReference[] refs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();

		List<IResource> openFiles = new ArrayList<IResource>();
		for(IPath path : relatedEditorFiles){
			for(IEditorReference ref : refs){
				IEditorPart part = ref.getEditor(false);

				if(part != null)
					if(part.getEditorInput() instanceof FileEditorInput){
						FileEditorInput editorInput = (FileEditorInput)part.getEditorInput();

						if(editorInput.getPath().equals(ResourcesPlugin.getWorkspace().getRoot().getLocation().append(path))){
							if(part.getSite().getPage().closeEditor(part, true)){


								try {
									InputStream stream = editorInput.getFile().getContents();
									if(stream instanceof FileInputStream){
										FileInputStream fileStream = (FileInputStream)stream;
										int length = 0;
										while(fileStream.read() != -1){
											length++;
										}

										if(length == 0){
											openFiles.add(editorInput.getFile());
										}
									}
								} catch (CoreException e) {
									e.printStackTrace();
								}catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}	
			}
		}
	}
}


