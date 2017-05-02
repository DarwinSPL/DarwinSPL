package dw.darwinspl.feature.graphical.editor.actions.feature;

import org.eclipse.gef.Request;
import org.eclipse.jface.viewers.StructuredSelection;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.editor.actions.DwCommandAction;

public abstract class DwFeatureSelectionAction extends DwCommandAction {

	public DwFeatureSelectionAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
	}
	
	protected Request request;

	protected DwFeatureWrapped getSelectedFeature(){
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		
		if(selection.getFirstElement() instanceof DwFeatureEditPart){
			DwFeatureEditPart part = (DwFeatureEditPart)selection.getFirstElement();
			return (DwFeatureWrapped)part.getModel();		
		}
		
		if(selection.getFirstElement() instanceof DwRootFeatureEditPart){
			DwRootFeatureEditPart part = (DwRootFeatureEditPart)selection.getFirstElement();
			return (DwFeatureWrapped)part.getModel();
		}
	
		return null;
	}	
	
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwFeatureEditPart || selectedObject instanceof DwRootFeatureEditPart)){
				return false;
			}
		}
		
		return true;
	}
}
