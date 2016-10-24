package eu.hyvar.feature.graphical.editor.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.SaveAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.ui.actions.ActionFactory;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.actions.HyGroupEditCardinalitiesAction;
import eu.hyvar.feature.graphical.editor.actions.HyLinearTemporalElementChangeValidityAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeRenameAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateBooleanAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateNumberAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateStringAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateSiblingAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditCardinalitiesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditNamesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEvolutionChangeParentAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEvolutionCreateChildAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateSuccessorAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateVersionAction;
import eu.hyvar.feature.graphical.editor.factory.HyFeatureModelEditorEditPartFactory;

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
		
		HyFeatureEvolutionCreateChildAction childAction = new HyFeatureEvolutionCreateChildAction(this);
		getActionRegistry().registerAction(childAction);
		getSelectionActions().add(childAction.getId());
		
		HyFeatureCreateSiblingAction siblingAction = new HyFeatureCreateSiblingAction(this);
		getActionRegistry().registerAction(siblingAction);
		getSelectionActions().add(siblingAction.getId());		
		
		HyFeatureEvolutionChangeParentAction parentChangeAction = new HyFeatureEvolutionChangeParentAction(this);
		getActionRegistry().registerAction(parentChangeAction);
		getSelectionActions().add(parentChangeAction.getId());
		
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
		for(HyFeatureWrapped feature : this.getModelWrapped().getFeatures()){
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
}


