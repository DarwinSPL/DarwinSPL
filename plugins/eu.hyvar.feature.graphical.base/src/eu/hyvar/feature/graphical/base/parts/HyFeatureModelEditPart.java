package eu.hyvar.feature.graphical.base.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyFeatureModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, ControlListener{
	protected GraphicalFeatureModelEditor editor;
	
	
	public HyFeatureModelEditPart(GraphicalFeatureModelEditor editor) {
		this.editor = editor;
	}
	 
	@Override
	protected IFigure createFigure() {
	    FreeformLayer layer = new FreeformLayer();
	    layer.setLayoutManager(new FreeformLayout());
	    layer.setBorder(new LineBorder(1));
	    return layer;
	}
	
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
	}


	@Override 
	protected List<Object> getModelChildren() {
		HyFeatureModelWrapped model = (HyFeatureModelWrapped) getModel();
		
		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.editor;

		List<Object> objects = new ArrayList<Object>();
		objects.addAll(model.getFeatures(editor.getCurrentSelectedDate()));
		objects.addAll(model.getGroups());
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
	}

	@Override
	public void controlResized(ControlEvent e) {		
	}
	 
	@Override
	public void refresh() {
		//HyFeatureModelEvolutionWrapped model = (HyFeatureModelEvolutionWrapped) getModel();
		
		super.refresh();
		
		for(Object children : this.getChildren()){
			((EditPart)children).refresh();
		}
		
	}
}
