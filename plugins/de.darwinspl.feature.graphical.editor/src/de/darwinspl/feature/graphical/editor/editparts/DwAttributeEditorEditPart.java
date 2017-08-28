package de.darwinspl.feature.graphical.editor.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.figures.DwAttributeFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.editor.locators.DwAttributeCellEditorLocator;
import de.darwinspl.feature.graphical.editor.managers.DwAttributeDirectEditManager;
import de.darwinspl.feature.graphical.editor.policies.attribute.DwAttributeComponentPolicy;
import de.darwinspl.feature.graphical.editor.policies.attribute.DwAttributeDirectEditPolicy;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeEditorEditPart extends DwAttributeEditPart {
	private HyAttributeAdapter adapter;

	public DwAttributeEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
		adapter = new HyAttributeAdapter();
	}

	public class HyAttributeAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			if((notification.getEventType() == Notification.ADD || notification.getEventType() == Notification.REMOVE) && 
			   (notification.getNewValue() instanceof HyName || notification.getOldValue() instanceof HyName)){
				refreshVisuals();
				//((DwFeatureEditPart)getParent()).propertyChange(new PropertyChangeEvent(this, "AttributeSizeChanged", figure.getBounds(), new Rectangle(0, 0, 0, 0)));
				
			
				//refreshVisuals();
				
				//featureModel.rearrangeFeatures();
				
			}
		}

		@Override 
		public Notifier getTarget() {
			return (HyFeatureAttribute) getModel();
		}

		@Override 
		public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override 
		public boolean isAdapterForType(Object type) {
			return type.equals(HyFeature.class);
		}
	} 

	@Override
	protected void createEditPolicies() {		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DwAttributeComponentPolicy(featureModel, editor));
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DwAttributeDirectEditPolicy());
	}


	@Override public void activate() {
		if(!isActive()) {
			HyFeatureAttribute model = ((HyFeatureAttribute)getModel());
			model.eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			HyFeatureAttribute model = ((HyFeatureAttribute)getModel());
			model.eAdapters().remove(adapter);
		}
		super.deactivate();
	}

	/**
	 * This method is used to enable direct name editing in the feature
	 */
	@Override public void performRequest(Request req) {
		super.performRequest(req);
		if(req.getType() == RequestConstants.REQ_OPEN){
			performDirectEditing();
		}
	}
	private void performDirectEditing() {
		Label label = ((DwAttributeFigure)getFigure()).getLabel();

		DwAttributeDirectEditManager manager = new DwAttributeDirectEditManager(this, TextCellEditor.class, new DwAttributeCellEditorLocator(label), label);
		manager.show();
	}   
}
