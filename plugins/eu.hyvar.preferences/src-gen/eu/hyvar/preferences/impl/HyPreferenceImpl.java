/**
 */
package eu.hyvar.preferences.impl;

import eu.hyvar.feature.expression.HyExpression;

import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.PreferencesPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hy Preference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.hyvar.preferences.impl.HyPreferenceImpl#getValidSince <em>Valid Since</em>}</li>
 *   <li>{@link eu.hyvar.preferences.impl.HyPreferenceImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link eu.hyvar.preferences.impl.HyPreferenceImpl#getId <em>Id</em>}</li>
 *   <li>{@link eu.hyvar.preferences.impl.HyPreferenceImpl#getRootExpression <em>Root Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HyPreferenceImpl extends MinimalEObjectImpl.Container implements HyPreference
{
	/**
	 * The default value of the '{@link #getValidSince() <em>Valid Since</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidSince()
	 * @generated
	 * @ordered
	 */
	protected static final Date VALID_SINCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidSince() <em>Valid Since</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidSince()
	 * @generated
	 * @ordered
	 */
	protected Date validSince = VALID_SINCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidUntil() <em>Valid Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidUntil()
	 * @generated
	 * @ordered
	 */
	protected static final Date VALID_UNTIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidUntil() <em>Valid Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidUntil()
	 * @generated
	 * @ordered
	 */
	protected Date validUntil = VALID_UNTIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRootExpression() <em>Root Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootExpression()
	 * @generated
	 * @ordered
	 */
	protected HyExpression rootExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HyPreferenceImpl()
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
		return PreferencesPackage.Literals.HY_PREFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValidSince()
	{
		return validSince;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidSince(Date newValidSince)
	{
		Date oldValidSince = validSince;
		validSince = newValidSince;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PREFERENCE__VALID_SINCE, oldValidSince, validSince));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValidUntil()
	{
		return validUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidUntil(Date newValidUntil)
	{
		Date oldValidUntil = validUntil;
		validUntil = newValidUntil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PREFERENCE__VALID_UNTIL, oldValidUntil, validUntil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PREFERENCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyExpression getRootExpression()
	{
		return rootExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootExpression(HyExpression newRootExpression, NotificationChain msgs)
	{
		HyExpression oldRootExpression = rootExpression;
		rootExpression = newRootExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION, oldRootExpression, newRootExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootExpression(HyExpression newRootExpression)
	{
		if (newRootExpression != rootExpression)
		{
			NotificationChain msgs = null;
			if (rootExpression != null)
				msgs = ((InternalEObject)rootExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION, null, msgs);
			if (newRootExpression != null)
				msgs = ((InternalEObject)newRootExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION, null, msgs);
			msgs = basicSetRootExpression(newRootExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION, newRootExpression, newRootExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createId()
	{
		if(this.id == null || this.id.equals("")) {
		   String newIdentifier = "_"+java.util.UUID.randomUUID().toString();
		   setId(newIdentifier);
		}
		return getId();
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
			case PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION:
				return basicSetRootExpression(null, msgs);
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
			case PreferencesPackage.HY_PREFERENCE__VALID_SINCE:
				return getValidSince();
			case PreferencesPackage.HY_PREFERENCE__VALID_UNTIL:
				return getValidUntil();
			case PreferencesPackage.HY_PREFERENCE__ID:
				return getId();
			case PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION:
				return getRootExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PreferencesPackage.HY_PREFERENCE__VALID_SINCE:
				setValidSince((Date)newValue);
				return;
			case PreferencesPackage.HY_PREFERENCE__VALID_UNTIL:
				setValidUntil((Date)newValue);
				return;
			case PreferencesPackage.HY_PREFERENCE__ID:
				setId((String)newValue);
				return;
			case PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION:
				setRootExpression((HyExpression)newValue);
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
			case PreferencesPackage.HY_PREFERENCE__VALID_SINCE:
				setValidSince(VALID_SINCE_EDEFAULT);
				return;
			case PreferencesPackage.HY_PREFERENCE__VALID_UNTIL:
				setValidUntil(VALID_UNTIL_EDEFAULT);
				return;
			case PreferencesPackage.HY_PREFERENCE__ID:
				setId(ID_EDEFAULT);
				return;
			case PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION:
				setRootExpression((HyExpression)null);
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
			case PreferencesPackage.HY_PREFERENCE__VALID_SINCE:
				return VALID_SINCE_EDEFAULT == null ? validSince != null : !VALID_SINCE_EDEFAULT.equals(validSince);
			case PreferencesPackage.HY_PREFERENCE__VALID_UNTIL:
				return VALID_UNTIL_EDEFAULT == null ? validUntil != null : !VALID_UNTIL_EDEFAULT.equals(validUntil);
			case PreferencesPackage.HY_PREFERENCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case PreferencesPackage.HY_PREFERENCE__ROOT_EXPRESSION:
				return rootExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PreferencesPackage.HY_PREFERENCE___CREATE_ID:
				return createId();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (validSince: ");
		result.append(validSince);
		result.append(", validUntil: ");
		result.append(validUntil);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //HyPreferenceImpl
