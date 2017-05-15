package de.darwinspl.feature.graphical.base.adapters;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import eu.hyvar.feature.HyFeature;


/**
 * Listens for changes of the corresponding HyFeature
 * @author Gil Engel
 *
 */
public class DwFeatureWrappedAdapter implements Adapter{
	private DwFeatureWrapped model;

	public void setModel(DwFeatureWrapped model) {
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
		return type.equals(DwFeatureWrapped.class);
	}
}