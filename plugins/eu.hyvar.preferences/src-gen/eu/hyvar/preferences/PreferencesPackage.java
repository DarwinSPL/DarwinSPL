/**
 */
package eu.hyvar.preferences;

import eu.hyvar.evolution.HyEvolutionPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.hyvar.preferences.PreferencesFactory
 * @model kind="package"
 * @generated
 */
public interface PreferencesPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "preferences";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hyvar-project.eu/feature/preferences/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "preferences";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PreferencesPackage eINSTANCE = eu.hyvar.preferences.impl.PreferencesPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.hyvar.preferences.impl.HyProfileImpl <em>Hy Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.hyvar.preferences.impl.HyProfileImpl
	 * @see eu.hyvar.preferences.impl.PreferencesPackageImpl#getHyProfile()
	 * @generated
	 */
	int HY_PROFILE = 0;

	/**
	 * The feature id for the '<em><b>Preferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PROFILE__PREFERENCES = 0;

	/**
	 * The feature id for the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PROFILE__FEATURE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Context Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PROFILE__CONTEXT_MODEL = 2;

	/**
	 * The number of structural features of the '<em>Hy Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PROFILE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Hy Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PROFILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.hyvar.preferences.impl.HyPreferenceImpl <em>Hy Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.hyvar.preferences.impl.HyPreferenceImpl
	 * @see eu.hyvar.preferences.impl.PreferencesPackageImpl#getHyPreference()
	 * @generated
	 */
	int HY_PREFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Valid Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE__VALID_SINCE = HyEvolutionPackage.HY_TEMPORAL_ELEMENT__VALID_SINCE;

	/**
	 * The feature id for the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE__VALID_UNTIL = HyEvolutionPackage.HY_TEMPORAL_ELEMENT__VALID_UNTIL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE__ID = HyEvolutionPackage.HY_TEMPORAL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Root Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE__ROOT_EXPRESSION = HyEvolutionPackage.HY_TEMPORAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hy Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE_FEATURE_COUNT = HyEvolutionPackage.HY_TEMPORAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE___CREATE_ID = HyEvolutionPackage.HY_TEMPORAL_ELEMENT___CREATE_ID;

	/**
	 * The number of operations of the '<em>Hy Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HY_PREFERENCE_OPERATION_COUNT = HyEvolutionPackage.HY_TEMPORAL_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link eu.hyvar.preferences.HyProfile <em>Hy Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hy Profile</em>'.
	 * @see eu.hyvar.preferences.HyProfile
	 * @generated
	 */
	EClass getHyProfile();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.hyvar.preferences.HyProfile#getPreferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preferences</em>'.
	 * @see eu.hyvar.preferences.HyProfile#getPreferences()
	 * @see #getHyProfile()
	 * @generated
	 */
	EReference getHyProfile_Preferences();

	/**
	 * Returns the meta object for the reference '{@link eu.hyvar.preferences.HyProfile#getFeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Model</em>'.
	 * @see eu.hyvar.preferences.HyProfile#getFeatureModel()
	 * @see #getHyProfile()
	 * @generated
	 */
	EReference getHyProfile_FeatureModel();

	/**
	 * Returns the meta object for the reference '{@link eu.hyvar.preferences.HyProfile#getContextModel <em>Context Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Model</em>'.
	 * @see eu.hyvar.preferences.HyProfile#getContextModel()
	 * @see #getHyProfile()
	 * @generated
	 */
	EReference getHyProfile_ContextModel();

	/**
	 * Returns the meta object for class '{@link eu.hyvar.preferences.HyPreference <em>Hy Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hy Preference</em>'.
	 * @see eu.hyvar.preferences.HyPreference
	 * @generated
	 */
	EClass getHyPreference();

	/**
	 * Returns the meta object for the containment reference '{@link eu.hyvar.preferences.HyPreference#getRootExpression <em>Root Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Expression</em>'.
	 * @see eu.hyvar.preferences.HyPreference#getRootExpression()
	 * @see #getHyPreference()
	 * @generated
	 */
	EReference getHyPreference_RootExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PreferencesFactory getPreferencesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link eu.hyvar.preferences.impl.HyProfileImpl <em>Hy Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.hyvar.preferences.impl.HyProfileImpl
		 * @see eu.hyvar.preferences.impl.PreferencesPackageImpl#getHyProfile()
		 * @generated
		 */
		EClass HY_PROFILE = eINSTANCE.getHyProfile();

		/**
		 * The meta object literal for the '<em><b>Preferences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HY_PROFILE__PREFERENCES = eINSTANCE.getHyProfile_Preferences();

		/**
		 * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HY_PROFILE__FEATURE_MODEL = eINSTANCE.getHyProfile_FeatureModel();

		/**
		 * The meta object literal for the '<em><b>Context Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HY_PROFILE__CONTEXT_MODEL = eINSTANCE.getHyProfile_ContextModel();

		/**
		 * The meta object literal for the '{@link eu.hyvar.preferences.impl.HyPreferenceImpl <em>Hy Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.hyvar.preferences.impl.HyPreferenceImpl
		 * @see eu.hyvar.preferences.impl.PreferencesPackageImpl#getHyPreference()
		 * @generated
		 */
		EClass HY_PREFERENCE = eINSTANCE.getHyPreference();

		/**
		 * The meta object literal for the '<em><b>Root Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HY_PREFERENCE__ROOT_EXPRESSION = eINSTANCE.getHyPreference_RootExpression();

	}

} //PreferencesPackage
