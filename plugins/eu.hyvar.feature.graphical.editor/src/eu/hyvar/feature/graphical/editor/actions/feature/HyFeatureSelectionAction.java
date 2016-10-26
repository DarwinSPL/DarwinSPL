package eu.hyvar.feature.graphical.editor.actions.feature;

import org.eclipse.gef.Request;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.actions.HyCommandAction;

public abstract class HyFeatureSelectionAction extends HyCommandAction {

	public HyFeatureSelectionAction(IWorkbenchPart part, GraphicalFeatureModelEditor editor) {
		super(part, editor);
	}
	
	protected Request request;

	protected HyFeatureWrapped getSelectedFeature(){
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		
		if(selection.getFirstElement() instanceof HyFeatureEditPart){
			HyFeatureEditPart part = (HyFeatureEditPart)selection.getFirstElement();
			return (HyFeatureWrapped)part.getModel();		
		}
		
		if(selection.getFirstElement() instanceof HyRootFeatureEditPart){
			HyRootFeatureEditPart part = (HyRootFeatureEditPart)selection.getFirstElement();
			return (HyFeatureWrapped)part.getModel();
		}
	
		return null;
	}	
	
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof HyFeatureEditPart || selectedObject instanceof HyRootFeatureEditPart)){
				return false;
			}
		}
		
		return true;
	}
}
