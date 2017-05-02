package dw.darwinspl.feature.graphical.editor.editparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwFeatureModelEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.editor.policies.DwFeatureModelXYLayoutPolicy;
import eu.hyvar.feature.HyFeatureModel;

public class DwFeatureModelEditorEditPart extends DwFeatureModelEditPart{
	public class HyFeatureModelAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			refreshChildren();
			refreshVisuals();
		}

		@Override 
		public Notifier getTarget() {
			DwFeatureModelWrapped model = ((DwFeatureModelWrapped)getModel());
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
	
	public DwFeatureModelEditorEditPart(DwGraphicalFeatureModelViewer editor) {
		super(editor);
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DwFeatureModelXYLayoutPolicy());
	}
	
	@Override 
	public void activate() {
		if(!isActive()) {
			DwFeatureModelWrapped model = ((DwFeatureModelWrapped)getModel());
			model.addPropertyChangeListener(this);
			model.getModel().eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			DwFeatureModelWrapped model = ((DwFeatureModelWrapped)getModel());
			model.removePropertyChangeListener(this);
			model.getModel().eAdapters().remove(adapter);
		}
		super.deactivate();
	}
}
