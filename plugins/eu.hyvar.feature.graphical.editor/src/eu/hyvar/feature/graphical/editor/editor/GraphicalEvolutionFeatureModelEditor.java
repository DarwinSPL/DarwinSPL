package eu.hyvar.feature.graphical.editor.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.actions.HyGroupEditCardinalitiesAction;
import eu.hyvar.feature.graphical.editor.actions.HyLinearTemporalElementChangeValidityAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateBooleanAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateNumberAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateStringAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeRenameAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateSiblingAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditCardinalitiesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditNamesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEvolutionCreateChildAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateSuccessorAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateVersionAction;
import eu.hyvar.feature.graphical.editor.factory.HyFeatureModelEditorEditPartFactory;

@SuppressWarnings("restriction")
public class GraphicalEvolutionFeatureModelEditor extends GraphicalFeatureModelEditor{


	KeyHandler sharedKeyHandler;
	protected KeyHandler getCommonKeyHandler() {
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
		viewer.setContextMenu(new HyFeatureModelEvolutionGraphicalEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry()));
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer).setParent(getCommonKeyHandler()));
	}
	
	@Override
	protected void loadModelFromFile(IFile file){
		super.loadModelFromFile(file);
		
		openEditorForFileExtension("hyconstraints");
		openEditorForFileExtension("hycontextinformation");
		openEditorForFileExtension("hyvalidityformula");
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
		
		HyFeatureEvolutionCreateChildAction childAction = new HyFeatureEvolutionCreateChildAction(this, this);
		getActionRegistry().registerAction(childAction);
		getSelectionActions().add(childAction.getId());
		
		HyFeatureCreateSiblingAction siblingAction = new HyFeatureCreateSiblingAction(this, this);
		getActionRegistry().registerAction(siblingAction);
		getSelectionActions().add(siblingAction.getId());		
		
		/*
		HyFeatureEvolutionChangeParentAction parentChangeAction = new HyFeatureEvolutionChangeParentAction(this);
		getActionRegistry().registerAction(parentChangeAction);
		getSelectionActions().add(parentChangeAction.getId());
		*/
		
		HyVersionCreateVersionAction featureCreateVersionAction = new HyVersionCreateVersionAction(this);
		getActionRegistry().registerAction(featureCreateVersionAction);
		getSelectionActions().add(featureCreateVersionAction.getId());

		HyVersionCreateSuccessorAction versionCreateSuccessorAction = new HyVersionCreateSuccessorAction(this);
		getActionRegistry().registerAction(versionCreateSuccessorAction);
		getSelectionActions().add(versionCreateSuccessorAction.getId());
		
		HyLinearTemporalElementChangeValidityAction visibilityAction = new HyLinearTemporalElementChangeValidityAction(this);
		getActionRegistry().registerAction(visibilityAction);
		getSelectionActions().add(visibilityAction.getId());
		
		HyFeatureEditCardinalitiesAction featureTypeAction = new HyFeatureEditCardinalitiesAction(this);
		getActionRegistry().registerAction(featureTypeAction);
		getSelectionActions().add(featureTypeAction.getId());
		
		HyFeatureEditNamesAction featureNameAction = new HyFeatureEditNamesAction(this);
		getActionRegistry().registerAction(featureNameAction);
		getSelectionActions().add(featureNameAction.getId());	
		
		HyGroupEditCardinalitiesAction groupTypeAction = new HyGroupEditCardinalitiesAction(this);
		getActionRegistry().registerAction(groupTypeAction);
		getSelectionActions().add(groupTypeAction.getId());
		
		HyAttributeRenameAction renameAttributeAction = new HyAttributeRenameAction(this);
		getActionRegistry().registerAction(renameAttributeAction);
		getSelectionActions().add(renameAttributeAction.getId());
		
		super.createActions();
	}


	
	private void saveLayout(){
		//IWorkbench workbench = PlatformUI.getWorkbench();
		//IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		//IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension("hylayout");
		
		String fileContent = "";
		for(HyFeatureWrapped feature : this.getModelWrapped().getFeatures(null)){
			fileContent += feature.getWrappedModelElement().getId()+","+feature.getPosition(null).x()+","+feature.getPosition(null).y()+"\n";
		}
		
		IFile file = workspaceRoot.getFile(path);
		if(!file.exists()){
		    InputStream source = new ByteArrayInputStream(fileContent.getBytes());
			try {
				file.create(source, IResource.NONE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	
	@SuppressWarnings("rawtypes")
	@Override
	protected void updateActions(List actionIds) {
		ActionRegistry registry = getActionRegistry();
		Iterator iter = actionIds.iterator();
		while (iter.hasNext()) {
			IAction action = registry.getAction(iter.next());
			if (action instanceof UpdateAction)
				((UpdateAction) action).update();
			if (action instanceof SaveAction){				
				((SaveAction) action).run();
				saveLayout();
			}
		}
	}	
	
	*/
	
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


