/**
 */
package eu.hyvar.preferences;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.hyvar.preferences.PreferencesPackage
 * @generated
 */
public interface PreferencesFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PreferencesFactory eINSTANCE = eu.hyvar.preferences.impl.PreferencesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Hy Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hy Profile</em>'.
	 * @generated
	 */
	HyProfile createHyProfile();

	/**
	 * Returns a new object of class '<em>Hy Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hy Preference</em>'.
	 * @generated
	 */
	HyPreference createHyPreference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PreferencesPackage getPreferencesPackage();

} //PreferencesFactory
