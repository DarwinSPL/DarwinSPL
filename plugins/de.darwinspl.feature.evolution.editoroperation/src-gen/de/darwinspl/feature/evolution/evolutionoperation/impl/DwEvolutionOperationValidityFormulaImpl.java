/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.context.contextValidity.HyValidityFormula;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation Validity Formula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaImpl#getValidityFormula <em>Validity Formula</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DwEvolutionOperationValidityFormulaImpl extends DwEvolutionOperationImpl implements DwEvolutionOperationValidityFormula {
	/**
	 * The cached value of the '{@link #getValidityFormula() <em>Validity Formula</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidityFormula()
	 * @generated
	 * @ordered
	 */
	protected HyValidityFormula validityFormula;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationValidityFormulaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyValidityFormula getValidityFormula() {
		if (validityFormula != null && validityFormula.eIsProxy()) {
			InternalEObject oldValidityFormula = (InternalEObject)validityFormula;
			validityFormula = (HyValidityFormula)eResolveProxy(oldValidityFormula);
			if (validityFormula != oldValidityFormula) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA, oldValidityFormula, validityFormula));
			}
		}
		return validityFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyValidityFormula basicGetValidityFormula() {
		return validityFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidityFormula(HyValidityFormula newValidityFormula) {
		HyValidityFormula oldValidityFormula = validityFormula;
		validityFormula = newValidityFormula;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA, oldValidityFormula, validityFormula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA:
				if (resolve) return getValidityFormula();
				return basicGetValidityFormula();
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA:
				setValidityFormula((HyValidityFormula)newValue);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA:
				setValidityFormula((HyValidityFormula)null);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA:
				return validityFormula != null;
		}
		return super.eIsSet(featureID);
	}

} //DwEvolutionOperationValidityFormulaImpl
