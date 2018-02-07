/**
 */
package eu.hyvar.preferences;

import eu.hyvar.evolution.HyTemporalElement;

import eu.hyvar.feature.expression.HyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hy Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.hyvar.preferences.HyPreference#getRootExpression <em>Root Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.hyvar.preferences.PreferencesPackage#getHyPreference()
 * @model
 * @generated
 */
public interface HyPreference extends HyTemporalElement
{
	/**
	 * Returns the value of the '<em><b>Root Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Expression</em>' containment reference.
	 * @see #setRootExpression(HyExpression)
	 * @see eu.hyvar.preferences.PreferencesPackage#getHyPreference_RootExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	HyExpression getRootExpression();

	/**
	 * Sets the value of the '{@link eu.hyvar.preferences.HyPreference#getRootExpression <em>Root Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Expression</em>' containment reference.
	 * @see #getRootExpression()
	 * @generated
	 */
	void setRootExpression(HyExpression value);

} // HyPreference
