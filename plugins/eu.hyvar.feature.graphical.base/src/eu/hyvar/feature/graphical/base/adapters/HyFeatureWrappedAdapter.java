package eu.hyvar.feature.graphical.base.adapters;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;


/**
 * Listens for changes of the corresponding HyFeature
 * @author Gil Engel
 *
 */
public class HyFeatureWrappedAdapter implements Adapter{
	private HyFeatureWrapped model;

	public void setModel(HyFeatureWrapped model) {
		this.model = model;
	}

	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
	}

	@Override
	public Notifier getTarget() {
		return (HyFeature)model.getWrappedModelElement();
	}

	@Override
	public void setTarget(Notifier newTarget) {

	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type.equals(HyFeatureWrapped.class);
	}
}