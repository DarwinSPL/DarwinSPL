package de.darwinspl.feature.graphical.base.model;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class DwRepaintNotification extends ENotificationImpl{

	public DwRepaintNotification(InternalEObject notifier, int eventType, EStructuralFeature feature,
			boolean oldBooleanValue, boolean newBooleanValue) {
		super(notifier, eventType, feature, oldBooleanValue, newBooleanValue);
		// TODO Auto-generated constructor stub
	}

}
