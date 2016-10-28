package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.policies.HyAttributeDirectEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyAttributeComponentPolicy;

public class HyAttributeEditorEditPart extends HyAttributeEditPart {
	private HyAttributeAdapter adapter;
	
	public HyAttributeEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
		
		adapter = new HyAttributeAdapter();
	}
	
	public class HyAttributeAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			if(!(notification.getEventType() == Notification.SET && notification.getPosition() == -1)){
				refreshVisuals();
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
		super.createEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyAttributeComponentPolicy(featureModel, (GraphicalEvolutionFeatureModelEditor)editor));
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
	 * This method is used to enable direct name editing in the attribute
	 */
	@Override public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEditing();
		}
	}
	private void performDirectEditing() {
		//Label label = ((HyAttributeFigure)getFigure()).getLabel();
		
		// TODO
		//HyAttributeDirectEditManager manager = new HyAttributeDirectEditManager(this, TextCellEditor.class, new HyAttributeCellEditorLocator(label), label);
		//manager.show();
	}   

}
