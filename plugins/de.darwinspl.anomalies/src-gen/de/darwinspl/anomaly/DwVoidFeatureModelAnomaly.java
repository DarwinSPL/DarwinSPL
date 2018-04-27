/**
 */
package de.darwinspl.anomaly;

import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Void Feature Model Anomaly</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getContextValueModel <em>Context Value Model</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.anomaly.DwAnomalyPackage#getDwVoidFeatureModelAnomaly()
 * @model
 * @generated
 */
public interface DwVoidFeatureModelAnomaly extends DwAnomaly {
	/**
	 * Returns the value of the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Model</em>' reference.
	 * @see #setFeatureModel(HyFeatureModel)
	 * @see de.darwinspl.anomaly.DwAnomalyPackage#getDwVoidFeatureModelAnomaly_FeatureModel()
	 * @model required="true"
	 * @generated
	 */
	HyFeatureModel getFeatureModel();

	/**
	 * Sets the value of the '{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getFeatureModel <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Model</em>' reference.
	 * @see #getFeatureModel()
	 * @generated
	 */
	void setFeatureModel(HyFeatureModel value);

	/**
	 * Returns the value of the '<em><b>Context Value Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Value Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Value Model</em>' containment reference.
	 * @see #setContextValueModel(HyContextValueModel)
	 * @see de.darwinspl.anomaly.DwAnomalyPackage#getDwVoidFeatureModelAnomaly_ContextValueModel()
	 * @model containment="true"
	 * @generated
	 */
	HyContextValueModel getContextValueModel();

	/**
	 * Sets the value of the '{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getContextValueModel <em>Context Value Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Value Model</em>' containment reference.
	 * @see #getContextValueModel()
	 * @generated
	 */
	void setContextValueModel(HyContextValueModel value);

} // DwVoidFeatureModelAnomaly
