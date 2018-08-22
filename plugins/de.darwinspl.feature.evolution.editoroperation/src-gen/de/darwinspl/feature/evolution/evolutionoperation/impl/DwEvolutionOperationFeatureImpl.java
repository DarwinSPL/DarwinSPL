/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.feature.HyFeature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DwEvolutionOperationFeatureImpl extends DwEvolutionOperationImpl implements DwEvolutionOperationFeature {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected HyFeature feature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (HyFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(HyFeature newFeature) {
		HyFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE__FEATURE:
				setFeature((HyFeature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE__FEATURE:
				setFeature((HyFeature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE__FEATURE:
				return feature != null;
		}
		return super.eIsSet(featureID);
	}

} //DwEvolutionOperationFeatureImpl
