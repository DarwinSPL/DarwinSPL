/**
 */
package de.darwinspl.anomaly;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.darwinspl.anomaly.DwAnomalyPackage
 * @generated
 */
public interface DwAnomalyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DwAnomalyFactory eINSTANCE = de.darwinspl.anomaly.impl.DwAnomalyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dw Void Feature Model Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dw Void Feature Model Anomaly</em>'.
	 * @generated
	 */
	DwVoidFeatureModelAnomaly createDwVoidFeatureModelAnomaly();

	/**
	 * Returns a new object of class '<em>Dw False Optional Feature Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dw False Optional Feature Anomaly</em>'.
	 * @generated
	 */
	DwFalseOptionalFeatureAnomaly createDwFalseOptionalFeatureAnomaly();

	/**
	 * Returns a new object of class '<em>Dw Dead Feature Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dw Dead Feature Anomaly</em>'.
	 * @generated
	 */
	DwDeadFeatureAnomaly createDwDeadFeatureAnomaly();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DwAnomalyPackage getDwAnomalyPackage();

} //DwAnomalyFactory
