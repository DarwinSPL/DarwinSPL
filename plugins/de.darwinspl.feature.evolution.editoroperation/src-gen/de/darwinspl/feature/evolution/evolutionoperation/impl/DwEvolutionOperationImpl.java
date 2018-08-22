/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationImpl#getEvoStep <em>Evo Step</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DwEvolutionOperationImpl extends MinimalEObjectImpl.Container implements DwEvolutionOperation {
	/**
	 * The default value of the '{@link #getEvoStep() <em>Evo Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvoStep()
	 * @generated
	 * @ordered
	 */
	protected static final Date EVO_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvoStep() <em>Evo Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvoStep()
	 * @generated
	 * @ordered
	 */
	protected Date evoStep = EVO_STEP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEvoStep() {
		return evoStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvoStep(Date newEvoStep) {
		Date oldEvoStep = evoStep;
		evoStep = newEvoStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION__EVO_STEP, oldEvoStep, evoStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION__EVO_STEP:
				return getEvoStep();
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION__EVO_STEP:
				setEvoStep((Date)newValue);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION__EVO_STEP:
				setEvoStep(EVO_STEP_EDEFAULT);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION__EVO_STEP:
				return EVO_STEP_EDEFAULT == null ? evoStep != null : !EVO_STEP_EDEFAULT.equals(evoStep);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (evoStep: ");
		result.append(evoStep);
		result.append(')');
		return result.toString();
	}

} //DwEvolutionOperationImpl
