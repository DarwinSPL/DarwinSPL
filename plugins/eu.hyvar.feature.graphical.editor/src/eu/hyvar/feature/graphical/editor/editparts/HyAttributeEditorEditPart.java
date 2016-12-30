package eu.hyvar.feature.graphical.editor.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Rectangle;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.figures.HyAttributeFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.locators.HyAttributeCellEditorLocator;
import eu.hyvar.feature.graphical.editor.managers.HyAttributeDirectEditManager;
import eu.hyvar.feature.graphical.editor.policies.attribute.HyAttributeComponentPolicy;
import eu.hyvar.feature.graphical.editor.policies.attribute.HyAttributeDirectEditPolicy;

public class HyAttributeEditorEditPart extends HyAttributeEditPart {
	private HyAttributeAdapter adapter;

	public HyAttributeEditorEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
		adapter = new HyAttributeAdapter();
	}

	public class HyAttributeAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			
			if(!(notification.getEventType() == Notification.SET && notification.getPosition() == -1)){
				((HyFeatureEditPart)getParent()).propertyChange(new PropertyChangeEvent(this, "AttributeSizeChanged", figure.getBounds(), new Rectangle(0, 0, 0, 0)));
				
			
				refreshVisuals();
				
				featureModel.rearrangeFeatures();
				
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
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyAttributeComponentPolicy(featureModel, editor));
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new HyAttributeDirectEditPolicy());
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
		Label label = ((HyAttributeFigure)getFigure()).getLabel();

		// TODO
		HyAttributeDirectEditManager manager = new HyAttributeDirectEditManager(this, TextCellEditor.class, new HyAttributeCellEditorLocator(label), label);
		manager.show();
	}   
}
