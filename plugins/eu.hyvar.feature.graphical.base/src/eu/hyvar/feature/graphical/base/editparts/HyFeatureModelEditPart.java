package eu.hyvar.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.DwEnumContainerWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyFeatureModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, ControlListener{
	protected DwGraphicalFeatureModelViewer editor;
	
	
	public HyFeatureModelEditPart(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}
	 
	@Override
	protected IFigure createFigure() {
		ScalableFreeformLayeredPane layer = new ScalableFreeformLayeredPane();
	    layer.setLayoutManager(new FreeformLayout());
	    layer.setBorder(new LineBorder(1));
	    layer.addLayoutListener(LayoutAnimator.getDefault());
	    return layer;
	}
	
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
	}


	@Override 
	protected List<Object> getModelChildren() {
		HyFeatureModelWrapped model = (HyFeatureModelWrapped) getModel();
		
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		
		List<Object> objects = new ArrayList<Object>();
		
		objects.addAll(model.getFeatures(editor.getCurrentSelectedDate()));
		objects.addAll(model.getGroups(editor.getCurrentSelectedDate()));
		
		//objects.addAll(model.getModel().getEnums());
		objects.add(new DwEnumContainerWrapped(null));
		return objects;
	}

	@Override public void activate() {
		if(!isActive()) {
			HyFeatureModelWrapped model = ((HyFeatureModelWrapped)getModel());
			model.addPropertyChangeListener(this);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			HyFeatureModelWrapped model = ((HyFeatureModelWrapped)getModel());
			model.removePropertyChangeListener(this);
		}
		super.deactivate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		refreshChildren();
		refreshVisuals();
	}

	@Override
	public void controlMoved(ControlEvent e) {	
		refresh();
	}

	@Override
	public void controlResized(ControlEvent e) {
		refresh();
	}
	 
	
	@Override
	public void refresh() {
			
		for(Object child : this.getChildren()){
			if(child instanceof HyParentChildConnectionEditPart)
				((EditPart)child).refresh();
			if(child instanceof HyFeatureEditPart){
				((EditPart)child).refresh();
			}
			if(child instanceof DwEnumContainerEditPart){
				((EditPart)child).refresh();
			}
		}
	}
	
	@Override
	protected void unregisterVisuals() {
		EditPartViewer v = getViewer();
		IFigure f = getFigure();
		
		if(v == null || f== null){
			System.out.println("");
		}
		v.getVisualPartMap().remove(f);
	}
}
