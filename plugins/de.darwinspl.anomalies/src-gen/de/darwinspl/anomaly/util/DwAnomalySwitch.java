/**
 */
package de.darwinspl.anomaly.util;

import de.darwinspl.anomaly.*;

import eu.hyvar.evolution.HyTemporalElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.darwinspl.anomaly.DwAnomalyPackage
 * @generated
 */
public class DwAnomalySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DwAnomalyPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwAnomalySwitch() {
		if (modelPackage == null) {
			modelPackage = DwAnomalyPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DwAnomalyPackage.DW_ANOMALY: {
				DwAnomaly dwAnomaly = (DwAnomaly)theEObject;
				T result = caseDwAnomaly(dwAnomaly);
				if (result == null) result = caseHyTemporalElement(dwAnomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY: {
				DwVoidFeatureModelAnomaly dwVoidFeatureModelAnomaly = (DwVoidFeatureModelAnomaly)theEObject;
				T result = caseDwVoidFeatureModelAnomaly(dwVoidFeatureModelAnomaly);
				if (result == null) result = caseDwAnomaly(dwVoidFeatureModelAnomaly);
				if (result == null) result = caseHyTemporalElement(dwVoidFeatureModelAnomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DwAnomalyPackage.DW_FEATURE_ANOMALY: {
				DwFeatureAnomaly dwFeatureAnomaly = (DwFeatureAnomaly)theEObject;
				T result = caseDwFeatureAnomaly(dwFeatureAnomaly);
				if (result == null) result = caseDwAnomaly(dwFeatureAnomaly);
				if (result == null) result = caseHyTemporalElement(dwFeatureAnomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DwAnomalyPackage.DW_FALSE_OPTIONAL_FEATURE_ANOMALY: {
				DwFalseOptionalFeatureAnomaly dwFalseOptionalFeatureAnomaly = (DwFalseOptionalFeatureAnomaly)theEObject;
				T result = caseDwFalseOptionalFeatureAnomaly(dwFalseOptionalFeatureAnomaly);
				if (result == null) result = caseDwFeatureAnomaly(dwFalseOptionalFeatureAnomaly);
				if (result == null) result = caseDwAnomaly(dwFalseOptionalFeatureAnomaly);
				if (result == null) result = caseHyTemporalElement(dwFalseOptionalFeatureAnomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY: {
				DwDeadFeatureAnomaly dwDeadFeatureAnomaly = (DwDeadFeatureAnomaly)theEObject;
				T result = caseDwDeadFeatureAnomaly(dwDeadFeatureAnomaly);
				if (result == null) result = caseDwFeatureAnomaly(dwDeadFeatureAnomaly);
				if (result == null) result = caseDwAnomaly(dwDeadFeatureAnomaly);
				if (result == null) result = caseHyTemporalElement(dwDeadFeatureAnomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwAnomaly(DwAnomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Void Feature Model Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Void Feature Model Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwVoidFeatureModelAnomaly(DwVoidFeatureModelAnomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Feature Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Feature Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwFeatureAnomaly(DwFeatureAnomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw False Optional Feature Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw False Optional Feature Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwFalseOptionalFeatureAnomaly(DwFalseOptionalFeatureAnomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Dead Feature Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Dead Feature Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwDeadFeatureAnomaly(DwDeadFeatureAnomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hy Temporal Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hy Temporal Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHyTemporalElement(HyTemporalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DwAnomalySwitch
