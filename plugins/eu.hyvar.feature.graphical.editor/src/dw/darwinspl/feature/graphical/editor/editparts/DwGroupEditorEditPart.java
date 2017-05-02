package dw.darwinspl.feature.graphical.editor.editparts;

import java.beans.PropertyChangeEvent;
import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPolicy;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;

public class DwGroupEditorEditPart extends DwGroupEditPart {
	public static String GROUP_MODEL_CHANGED = "GROUP_MODEL_CHANGED";
	public class HyGroupAdapter implements Adapter {

		@Override 
		public void notifyChanged(Notification notification) {
			if(notification.getEventType() != Notification.REMOVING_ADAPTER){
				DwGroupWrapped groupWrapped = (DwGroupWrapped)getModel();
				
				switch(notification.getEventType()){
				case Notification.REMOVE:
					// check if the group has no compositions left
					if(groupWrapped.getWrappedModelElement().getParentOf().isEmpty()){
						featureModel.removeGroup((DwGroupWrapped)getModel());
					}else{

					}

					// remove feature from the child list of the group
					if(notification.getNotifier() instanceof HyFeature){
						DwFeatureWrapped removedFeatureWrapped = featureModel.getWrappedFeature((HyFeature)notification.getNotifier());
						groupWrapped.getFeatures().remove(removedFeatureWrapped);
					}	
					
					Date date = featureModel.getSelectedDate();
					
					for(DwFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
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
			return (HyGroup)((DwGroupWrapped)getModel()).getWrappedModelElement();
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
	
	public DwGroupEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Date date = editor.getCurrentSelectedDate();
		
		if(evt.getPropertyName() == DwGroupWrapped.PROPERTY_CHILD_FEATURES){
			DwGroupWrapped model = (DwGroupWrapped)getModel();
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
			DwGroupWrapped model = ((DwGroupWrapped)getModel());
			
			DwFeatureWrapped parentFeature = featureModel.getParentFeatureForGroup((DwGroupWrapped)getModel(), featureModel.getSelectedDate());
			
			if(parentFeature != null)
				parentFeature.addPropertyChangeListener(this);
			
			for(DwFeatureWrapped child : model.getFeatures()){
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
			DwGroupWrapped model = ((DwGroupWrapped)getModel());
			//HyFeatureWrapped parentFeature = featureModel.getParentFeatureForGroup((HyGroupWrapped)getModel(), featureModel.getSelectedDate());
			
			//parentFeature.removePropertyChangeListener(this);
			for(DwFeatureWrapped child : model.getFeatures()){
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
