/**
 */
package eu.hyvar.preferences;

import eu.hyvar.context.HyContextModel;

import eu.hyvar.feature.HyFeatureModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hy Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.hyvar.preferences.HyProfile#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link eu.hyvar.preferences.HyProfile#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link eu.hyvar.preferences.HyProfile#getContextModel <em>Context Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.hyvar.preferences.PreferencesPackage#getHyProfile()
 * @model
 * @generated
 */
public interface HyProfile extends EObject
{
	/**
	 * Returns the value of the '<em><b>Preferences</b></em>' containment reference list.
	 * The list contents are of type {@link eu.hyvar.preferences.HyPreference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferences</em>' containment reference list.
	 * @see eu.hyvar.preferences.PreferencesPackage#getHyProfile_Preferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<HyPreference> getPreferences();

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
	 * @see eu.hyvar.preferences.PreferencesPackage#getHyProfile_FeatureModel()
	 * @model required="true"
	 * @generated
	 */
	HyFeatureModel getFeatureModel();

	/**
	 * Sets the value of the '{@link eu.hyvar.preferences.HyProfile#getFeatureModel <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Model</em>' reference.
	 * @see #getFeatureModel()
	 * @generated
	 */
	void setFeatureModel(HyFeatureModel value);

	/**
	 * Returns the value of the '<em><b>Context Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Model</em>' reference.
	 * @see #setContextModel(HyContextModel)
	 * @see eu.hyvar.preferences.PreferencesPackage#getHyProfile_ContextModel()
	 * @model
	 * @generated
	 */
	HyContextModel getContextModel();

	/**
	 * Sets the value of the '{@link eu.hyvar.preferences.HyProfile#getContextModel <em>Context Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Model</em>' reference.
	 * @see #getContextModel()
	 * @generated
	 */
	void setContextModel(HyContextModel value);

} // HyProfile
