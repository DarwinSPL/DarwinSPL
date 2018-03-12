/**
 */
package eu.hyvar.preferences.impl;

import eu.hyvar.context.HyContextModel;

import eu.hyvar.feature.HyFeatureModel;

import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.preferences.PreferencesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hy Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.hyvar.preferences.impl.HyProfileImpl#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link eu.hyvar.preferences.impl.HyProfileImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link eu.hyvar.preferences.impl.HyProfileImpl#getContextModel <em>Context Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HyProfileImpl extends MinimalEObjectImpl.Container implements HyProfile
{
	/**
	 * The cached value of the '{@link #getPreferences() <em>Preferences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<HyPreference> preferences;

	/**
	 * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected HyFeatureModel featureModel;

	/**
	 * The cached value of the '{@link #getContextModel() <em>Context Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextModel()
	 * @generated
	 * @ordered
	 */
	protected HyContextModel contextModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HyProfileImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PreferencesPackage.Literals.HY_PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HyPreference> getPreferences()
	{
		if (preferences == null)
		{
			preferences = new EObjectContainmentEList<HyPreference>(HyPreference.class, this, PreferencesPackage.HY_PROFILE__PREFERENCES);
		}
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureModel getFeatureModel()
	{
		if (featureModel != null && featureModel.eIsProxy())
		{
			InternalEObject oldFeatureModel = (InternalEObject)featureModel;
			featureModel = (HyFeatureModel)eResolveProxy(oldFeatureModel);
			if (featureModel != oldFeatureModel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PreferencesPackage.HY_PROFILE__FEATURE_MODEL, oldFeatureModel, featureModel));
			}
		}
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureModel basicGetFeatureModel()
	{
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureModel(HyFeatureModel newFeatureModel)
	{
		HyFeatureModel oldFeatureModel = featureModel;
		featureModel = newFeatureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PROFILE__FEATURE_MODEL, oldFeatureModel, featureModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyContextModel getContextModel()
	{
		if (contextModel != null && contextModel.eIsProxy())
		{
			InternalEObject oldContextModel = (InternalEObject)contextModel;
			contextModel = (HyContextModel)eResolveProxy(oldContextModel);
			if (contextModel != oldContextModel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PreferencesPackage.HY_PROFILE__CONTEXT_MODEL, oldContextModel, contextModel));
			}
		}
		return contextModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyContextModel basicGetContextModel()
	{
		return contextModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextModel(HyContextModel newContextModel)
	{
		HyContextModel oldContextModel = contextModel;
		contextModel = newContextModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PROFILE__CONTEXT_MODEL, oldContextModel, contextModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PreferencesPackage.HY_PROFILE__PREFERENCES:
				return ((InternalEList<?>)getPreferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PreferencesPackage.HY_PROFILE__PREFERENCES:
				return getPreferences();
			case PreferencesPackage.HY_PROFILE__FEATURE_MODEL:
				if (resolve) return getFeatureModel();
				return basicGetFeatureModel();
			case PreferencesPackage.HY_PROFILE__CONTEXT_MODEL:
				if (resolve) return getContextModel();
				return basicGetContextModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PreferencesPackage.HY_PROFILE__PREFERENCES:
				getPreferences().clear();
				getPreferences().addAll((Collection<? extends HyPreference>)newValue);
				return;
			case PreferencesPackage.HY_PROFILE__FEATURE_MODEL:
				setFeatureModel((HyFeatureModel)newValue);
				return;
			case PreferencesPackage.HY_PROFILE__CONTEXT_MODEL:
				setContextModel((HyContextModel)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PreferencesPackage.HY_PROFILE__PREFERENCES:
				getPreferences().clear();
				return;
			case PreferencesPackage.HY_PROFILE__FEATURE_MODEL:
				setFeatureModel((HyFeatureModel)null);
				return;
			case PreferencesPackage.HY_PROFILE__CONTEXT_MODEL:
				setContextModel((HyContextModel)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PreferencesPackage.HY_PROFILE__PREFERENCES:
				return preferences != null && !preferences.isEmpty();
			case PreferencesPackage.HY_PROFILE__FEATURE_MODEL:
				return featureModel != null;
			case PreferencesPackage.HY_PROFILE__CONTEXT_MODEL:
				return contextModel != null;
		}
		return super.eIsSet(featureID);
	}

} //HyProfileImpl
