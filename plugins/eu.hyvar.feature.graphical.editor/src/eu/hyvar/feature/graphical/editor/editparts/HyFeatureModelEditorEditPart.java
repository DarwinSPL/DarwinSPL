package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureModelXYLayoutPolicy;

public class HyFeatureModelEditorEditPart extends HyFeatureModelEditPart{
	public class HyFeatureModelAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			refreshChildren();
			refreshVisuals();
		}

		@Override 
		public Notifier getTarget() {
			HyFeatureModelWrapped model = ((HyFeatureModelWrapped)getModel());
			return model.getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(HyFeatureModel.class);
		}
	} 
	
	private HyFeatureModelAdapter adapter = new HyFeatureModelAdapter();
	
	public HyFeatureModelEditorEditPart(GraphicalFeatureModelEditor editor) {
		super(editor);
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new HyFeatureModelXYLayoutPolicy());
	}
	
	@Override 
	public void activate() {
		if(!isActive()) {
			HyFeatureModelWrapped model = ((HyFeatureModelWrapped)getModel());
			model.addPropertyChangeListener(this);
			model.getModel().eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			HyFeatureModelWrapped model = ((HyFeatureModelWrapped)getModel());
			model.removePropertyChangeListener(this);
			model.getModel().eAdapters().remove(adapter);
		}
		super.deactivate();
	}
}
