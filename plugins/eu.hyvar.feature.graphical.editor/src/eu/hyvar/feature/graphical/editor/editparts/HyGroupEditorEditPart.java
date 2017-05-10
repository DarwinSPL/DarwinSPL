package eu.hyvar.feature.graphical.editor.editparts;

import java.beans.PropertyChangeEvent;
import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPolicy;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;

public class HyGroupEditorEditPart extends HyGroupEditPart {
	public static String GROUP_MODEL_CHANGED = "GROUP_MODEL_CHANGED";
	public class HyGroupAdapter implements Adapter {

		@Override 
		public void notifyChanged(Notification notification) {
			if(notification.getEventType() != Notification.REMOVING_ADAPTER){
				HyGroupWrapped groupWrapped = (HyGroupWrapped)getModel();
				
				switch(notification.getEventType()){
				case Notification.REMOVE:
					// check if the group has no compositions left
					if(groupWrapped.getWrappedModelElement().getParentOf().isEmpty()){
						featureModel.removeGroup((HyGroupWrapped)getModel());
					}else{

					}

					// remove feature from the child list of the group
					if(notification.getNotifier() instanceof HyFeature){
						HyFeatureWrapped removedFeatureWrapped = featureModel.getWrappedFeature((HyFeature)notification.getNotifier());
						groupWrapped.getFeatures().remove(removedFeatureWrapped);
					}	
					
					Date date = featureModel.getSelectedDate();
					
					for(HyFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
						// notify all children about the change
						
						featureWrapped.getListeners().firePropertyChange(new PropertyChangeEvent(groupWrapped.getWrappedModelElement(), GROUP_MODEL_CHANGED, notification.getOldValue(), notification.getNewValue()));
					}					
					
					refreshVisuals(); 
					
					break;
				case Notification.SET:
					// group was deleted from feature model
					if(notification.getPosition() == -1){
						
					}
					break;
				}
	

				
				
			}
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
	
	public HyGroupEditorEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Date date = editor.getCurrentSelectedDate();
		
		if(evt.getPropertyName() == HyGroupWrapped.PROPERTY_CHILD_FEATURES){
			HyGroupWrapped model = (HyGroupWrapped)getModel();
			EList<HyFeature> features = model.getFeatures(date);
			if(features.size() == 0){
				model.getWrappedModelElement().getParentOf().remove(model.getComposition(date));
			}
		}
		refreshVisuals();
	}

	
	@Override 
	public void activate() {
		if(!isActive()) {
			HyGroupWrapped model = ((HyGroupWrapped)getModel());
			
			HyFeatureWrapped parentFeature = featureModel.getParentFeatureForGroup((HyGroupWrapped)getModel(), featureModel.getSelectedDate());
			
			if(parentFeature != null)
				parentFeature.addPropertyChangeListener(this);
			
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
			//HyFeatureWrapped parentFeature = featureModel.getParentFeatureForGroup((HyGroupWrapped)getModel(), featureModel.getSelectedDate());
			
			//parentFeature.removePropertyChangeListener(this);
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

	}
	

}
