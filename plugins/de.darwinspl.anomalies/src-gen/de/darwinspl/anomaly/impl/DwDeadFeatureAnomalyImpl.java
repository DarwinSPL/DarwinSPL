/**
 */
package de.darwinspl.anomaly.impl;

import de.darwinspl.anomaly.DwAnomalyPackage;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;

import eu.hyvar.feature.HyFeature;

import java.lang.reflect.InvocationTargetException;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Dead Feature Anomaly</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl#getValidSince <em>Valid Since</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DwDeadFeatureAnomalyImpl extends MinimalEObjectImpl.Container implements DwDeadFeatureAnomaly {
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
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected HyFeature feature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwDeadFeatureAnomalyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DwAnomalyPackage.Literals.DW_DEAD_FEATURE_ANOMALY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValidSince() {
		return validSince;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidSince(Date newValidSince) {
		Date oldValidSince = validSince;
		validSince = newValidSince;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_SINCE, oldValidSince, validSince));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValidUntil() {
		return validUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidUntil(Date newValidUntil) {
		Date oldValidUntil = validUntil;
		validUntil = newValidUntil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_UNTIL, oldValidUntil, validUntil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (HyFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(HyFeature newFeature) {
		HyFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createId() {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_SINCE:
				return getValidSince();
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_UNTIL:
				return getValidUntil();
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__ID:
				return getId();
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_SINCE:
				setValidSince((Date)newValue);
				return;
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_UNTIL:
				setValidUntil((Date)newValue);
				return;
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__ID:
				setId((String)newValue);
				return;
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__FEATURE:
				setFeature((HyFeature)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_SINCE:
				setValidSince(VALID_SINCE_EDEFAULT);
				return;
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_UNTIL:
				setValidUntil(VALID_UNTIL_EDEFAULT);
				return;
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__ID:
				setId(ID_EDEFAULT);
				return;
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__FEATURE:
				setFeature((HyFeature)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_SINCE:
				return VALID_SINCE_EDEFAULT == null ? validSince != null : !VALID_SINCE_EDEFAULT.equals(validSince);
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__VALID_UNTIL:
				return VALID_UNTIL_EDEFAULT == null ? validUntil != null : !VALID_UNTIL_EDEFAULT.equals(validUntil);
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY__FEATURE:
				return feature != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY___CREATE_ID:
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
	public String toString() {
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

} //DwDeadFeatureAnomalyImpl
