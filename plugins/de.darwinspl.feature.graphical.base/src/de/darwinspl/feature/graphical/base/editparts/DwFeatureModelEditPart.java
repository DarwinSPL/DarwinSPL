package de.darwinspl.feature.graphical.base.editparts;

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
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwEnumContainerWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;

public class DwFeatureModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, ControlListener{
	protected DwGraphicalFeatureModelViewer editor;
	
	
	public DwFeatureModelEditPart(DwGraphicalFeatureModelViewer editor) {
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
		DwFeatureModelWrapped model = (DwFeatureModelWrapped) getModel();
		
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		
		List<Object> objects = new ArrayList<Object>();
		
		objects.addAll(model.getFeatures(editor.getCurrentSelectedDate()));
		objects.addAll(model.getGroups(editor.getCurrentSelectedDate()));
		
		objects.add(new DwEnumContainerWrapped(null));
		return objects;
	}

	@Override public void activate() {
		if(!isActive()) {
			DwFeatureModelWrapped model = ((DwFeatureModelWrapped)getModel());
			model.addPropertyChangeListener(this);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			DwFeatureModelWrapped model = ((DwFeatureModelWrapped)getModel());
			model.removePropertyChangeListener(this);
		}
		super.deactivate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		DwFeatureModelWrapped model = ((DwFeatureModelWrapped)getModel());
		model.rearrangeFeatures();
		
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
			if(child instanceof DwParentChildConnectionEditPart)
				((EditPart)child).refresh();
			if(child instanceof DwFeatureEditPart){
				((EditPart)child).refresh();
			}
			if(child instanceof DwEnumContainerEditPart){
				((EditPart)child).refresh();
			}
		}
	}
}
