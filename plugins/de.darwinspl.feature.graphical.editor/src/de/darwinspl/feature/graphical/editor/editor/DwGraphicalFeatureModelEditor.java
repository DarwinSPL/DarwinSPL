package de.darwinspl.feature.graphical.editor.editor;

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

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import de.darwinspl.feature.graphical.editor.actions.DwLinearTemporalElementChangeValidityAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwAttributeCreateBooleanAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwAttributeCreateEnumAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwAttributeCreateNumberAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwAttributeCreateStringAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwAttributeEditDefaultAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwAttributeRenameAction;
import de.darwinspl.feature.graphical.editor.actions.attribute.DwNumberAttributeSetNumberRangeAction;
import de.darwinspl.feature.graphical.editor.actions.enumeration.DwFeatureAttributeEnumCreateEnumAction;
import de.darwinspl.feature.graphical.editor.actions.enumeration.DwFeatureAttributeEnumCreateLiteralAction;
import de.darwinspl.feature.graphical.editor.actions.feature.DwFeatureChangeTypeAction;
import de.darwinspl.feature.graphical.editor.actions.feature.DwFeatureCreateChildAction;
import de.darwinspl.feature.graphical.editor.actions.feature.DwFeatureCreateSiblingAction;
import de.darwinspl.feature.graphical.editor.actions.feature.DwFeatureEditNamesAction;
import de.darwinspl.feature.graphical.editor.actions.group.DwGroupChangeGroupTypeToAlternativeTypeAction;
import de.darwinspl.feature.graphical.editor.actions.group.DwGroupChangeGroupTypeToAndTypeAction;
import de.darwinspl.feature.graphical.editor.actions.group.DwGroupChangeGroupTypeToOrTypeAction;
import de.darwinspl.feature.graphical.editor.actions.version.DwVersionCreateSuccessorAction;
import de.darwinspl.feature.graphical.editor.actions.version.DwVersionCreateVersionAction;
import de.darwinspl.feature.graphical.editor.factory.DwFeatureModelEditorEditPartFactory;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

@SuppressWarnings("restriction")
public class DwGraphicalFeatureModelEditor extends DwGraphicalFeatureModelViewer{
	List<IPath> relatedEditorFiles = new ArrayList<IPath>();

	@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	public void executeCommand(Command command) {
		CommandStack commandStack = getCommandStack();
		commandStack.execute(command);
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
		viewer.setEditPartFactory(new DwFeatureModelEditorEditPartFactory(viewer, this));
		viewer.setContextMenu(new DwGraphicalFeatureModelEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry()));
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
		DwGroupChangeGroupTypeToAlternativeTypeAction groupChangeTypeToAlternativeAction = new DwGroupChangeGroupTypeToAlternativeTypeAction(this);
		getActionRegistry().registerAction(groupChangeTypeToAlternativeAction);
		getSelectionActions().add(groupChangeTypeToAlternativeAction.getId());

		DwGroupChangeGroupTypeToAndTypeAction groupChangeTypeToAndAction = new DwGroupChangeGroupTypeToAndTypeAction(this);
		getActionRegistry().registerAction(groupChangeTypeToAndAction);
		getSelectionActions().add(groupChangeTypeToAndAction.getId());

		DwGroupChangeGroupTypeToOrTypeAction groupChangeTypeToOrAction = new DwGroupChangeGroupTypeToOrTypeAction(this);
		getActionRegistry().registerAction(groupChangeTypeToOrAction);
		getSelectionActions().add(groupChangeTypeToOrAction.getId());
	}

	@SuppressWarnings("unchecked")
	protected void createEnumActions(){
		DwFeatureAttributeEnumCreateEnumAction createEnumAction = new DwFeatureAttributeEnumCreateEnumAction(this);
		getActionRegistry().registerAction(createEnumAction);
		getSelectionActions().add(createEnumAction.getId());

		DwFeatureAttributeEnumCreateLiteralAction createLiteralAction = new DwFeatureAttributeEnumCreateLiteralAction(this);
		getActionRegistry().registerAction(createLiteralAction);
		getSelectionActions().add(createLiteralAction.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createActions(){
		DwAttributeCreateNumberAction attributeCreateNumberAction = new DwAttributeCreateNumberAction(this);
		getActionRegistry().registerAction(attributeCreateNumberAction);
		getSelectionActions().add(attributeCreateNumberAction.getId());

		DwAttributeCreateStringAction attributeCreateStringAction = new DwAttributeCreateStringAction(this);
		getActionRegistry().registerAction(attributeCreateStringAction);
		getSelectionActions().add(attributeCreateStringAction.getId());

		DwAttributeCreateBooleanAction attributeCreateBooleanAction = new DwAttributeCreateBooleanAction(this);
		getActionRegistry().registerAction(attributeCreateBooleanAction);
		getSelectionActions().add(attributeCreateBooleanAction.getId());

		DwAttributeCreateEnumAction attributeCreateEnumAction = new DwAttributeCreateEnumAction(this);
		getActionRegistry().registerAction(attributeCreateEnumAction);
		getSelectionActions().add(attributeCreateEnumAction.getId());		

		DwFeatureCreateChildAction childAction = new DwFeatureCreateChildAction(this);
		getActionRegistry().registerAction(childAction);
		getSelectionActions().add(childAction.getId());

		DwFeatureCreateSiblingAction siblingAction = new DwFeatureCreateSiblingAction(this);
		getActionRegistry().registerAction(siblingAction);
		getSelectionActions().add(siblingAction.getId());		

		DwFeatureChangeTypeAction changeAction = new DwFeatureChangeTypeAction(this);
		getActionRegistry().registerAction(changeAction);
		getSelectionActions().add(changeAction.getId());	

		DwVersionCreateVersionAction featureCreateVersionAction = new DwVersionCreateVersionAction(this);
		getActionRegistry().registerAction(featureCreateVersionAction);
		getSelectionActions().add(featureCreateVersionAction.getId());

		DwVersionCreateSuccessorAction versionCreateSuccessorAction = new DwVersionCreateSuccessorAction(this);
		getActionRegistry().registerAction(versionCreateSuccessorAction);
		getSelectionActions().add(versionCreateSuccessorAction.getId());

		DwLinearTemporalElementChangeValidityAction visibilityAction = new DwLinearTemporalElementChangeValidityAction(this);
		getActionRegistry().registerAction(visibilityAction);
		getSelectionActions().add(visibilityAction.getId());

		DwFeatureEditNamesAction featureNameAction = new DwFeatureEditNamesAction(this);
		getActionRegistry().registerAction(featureNameAction);
		getSelectionActions().add(featureNameAction.getId());	

		DwAttributeRenameAction renameAttributeAction = new DwAttributeRenameAction(this);
		getActionRegistry().registerAction(renameAttributeAction);
		getSelectionActions().add(renameAttributeAction.getId());

		DwNumberAttributeSetNumberRangeAction rangeAttributeAction = new DwNumberAttributeSetNumberRangeAction(this);
		getActionRegistry().registerAction(rangeAttributeAction);
		getSelectionActions().add(rangeAttributeAction.getId());

		DwAttributeEditDefaultAction editDefaultAction = new DwAttributeEditDefaultAction(this);
		getActionRegistry().registerAction(editDefaultAction);
		getSelectionActions().add(editDefaultAction.getId());
		
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


