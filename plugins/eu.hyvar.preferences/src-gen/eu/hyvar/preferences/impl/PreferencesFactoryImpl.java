/**
 */
package eu.hyvar.preferences.impl;

import eu.hyvar.preferences.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PreferencesFactoryImpl extends EFactoryImpl implements PreferencesFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PreferencesFactory init()
	{
		try
		{
			PreferencesFactory thePreferencesFactory = (PreferencesFactory)EPackage.Registry.INSTANCE.getEFactory(PreferencesPackage.eNS_URI);
			if (thePreferencesFactory != null)
			{
				return thePreferencesFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PreferencesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferencesFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case PreferencesPackage.HY_PROFILE: return createHyProfile();
			case PreferencesPackage.HY_PREFERENCE: return createHyPreference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyProfile createHyProfile()
	{
		HyProfileImpl hyProfile = new HyProfileImpl();
		return hyProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyPreference createHyPreference()
	{
		HyPreferenceImpl hyPreference = new HyPreferenceImpl();
		return hyPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferencesPackage getPreferencesPackage()
	{
		return (PreferencesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PreferencesPackage getPackage()
	{
		return PreferencesPackage.eINSTANCE;
	}

} //PreferencesFactoryImpl
