/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.feature.HyFeatureType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation Feature Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureTypeImpl#getOldType <em>Old Type</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureTypeImpl#getNewType <em>New Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DwEvolutionOperationFeatureTypeImpl extends DwEvolutionOperationFeatureImpl implements DwEvolutionOperationFeatureType {
	/**
	 * The cached value of the '{@link #getOldType() <em>Old Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldType()
	 * @generated
	 * @ordered
	 */
	protected HyFeatureType oldType;

	/**
	 * The cached value of the '{@link #getNewType() <em>New Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewType()
	 * @generated
	 * @ordered
	 */
	protected HyFeatureType newType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationFeatureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION_FEATURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureType getOldType() {
		if (oldType != null && oldType.eIsProxy()) {
			InternalEObject oldOldType = (InternalEObject)oldType;
			oldType = (HyFeatureType)eResolveProxy(oldOldType);
			if (oldType != oldOldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE, oldOldType, oldType));
			}
		}
		return oldType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureType basicGetOldType() {
		return oldType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldType(HyFeatureType newOldType) {
		HyFeatureType oldOldType = oldType;
		oldType = newOldType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE, oldOldType, oldType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureType getNewType() {
		if (newType != null && newType.eIsProxy()) {
			InternalEObject oldNewType = (InternalEObject)newType;
			newType = (HyFeatureType)eResolveProxy(oldNewType);
			if (newType != oldNewType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE, oldNewType, newType));
			}
		}
		return newType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureType basicGetNewType() {
		return newType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewType(HyFeatureType newNewType) {
		HyFeatureType oldNewType = newType;
		newType = newNewType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE, oldNewType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE:
				if (resolve) return getOldType();
				return basicGetOldType();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE:
				if (resolve) return getNewType();
				return basicGetNewType();
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE:
				setOldType((HyFeatureType)newValue);
				return;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE:
				setNewType((HyFeatureType)newValue);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE:
				setOldType((HyFeatureType)null);
				return;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE:
				setNewType((HyFeatureType)null);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE:
				return oldType != null;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE:
				return newType != null;
		}
		return super.eIsSet(featureID);
	}

} //DwEvolutionOperationFeatureTypeImpl
