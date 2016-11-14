package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import java.beans.PropertyChangeEvent;

import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;

public class HyGroupEditorEditPart extends HyGroupEditPart {
	public static String GROUP_MODEL_CHANGED = "GROUP_MODEL_CHANGED";
	public class HyGroupAdapter implements Adapter {

		@Override 
		public void notifyChanged(Notification notification) {
			HyGroupWrapped groupWrapped = (HyGroupWrapped)getModel();
			for(HyFeatureWrapped featureWrapped : groupWrapped.getFeatures()){
				// notify all children about the change
				featureWrapped.getListeners().firePropertyChange(new PropertyChangeEvent(groupWrapped.getWrappedModelElement(), GROUP_MODEL_CHANGED, notification.getOldValue(), notification.getNewValue()));
			}
			
			refreshVisuals();
		}

		@Override 
		public Notifier getTarget() {
			return (HyGroup)((HyGroupWrapped)getModel()).getWrappedModelElement();
		}

		@Override 
		public void setTarget(Notifier newTarget) {
		}

		@Override 
		public boolean isAdapterForType(Object type) {
			return type.equals(HyGroup.class);
		}
	} 
	
	HyGroupAdapter adapter = new HyGroupAdapter();
	
	public HyGroupEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		refreshVisuals();
	}

	
	@Override 
	public void activate() {
		if(!isActive()) {
			HyGroupWrapped model = ((HyGroupWrapped)getModel());
			model.getParentFeature().addPropertyChangeListener(this);
			for(HyFeatureWrapped child : model.getFeatures()){
				child.addPropertyChangeListener(this);
			}
			
			model.addPropertyChangeListener(this);
			model.getWrappedModelElement().eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			HyGroupWrapped model = ((HyGroupWrapped)getModel());
			model.getParentFeature().removePropertyChangeListener(this);
			for(HyFeatureWrapped child : model.getFeatures()){
				child.removePropertyChangeListener(this);
			}
			
			model.removePropertyChangeListener(this);
			model.getWrappedModelElement().eAdapters().remove(adapter);
		}
		super.deactivate();
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, null);
		installEditPolicy(EditPolicy.NODE_ROLE, null);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new	NonResizableEditPolicy());
	}
	

}
