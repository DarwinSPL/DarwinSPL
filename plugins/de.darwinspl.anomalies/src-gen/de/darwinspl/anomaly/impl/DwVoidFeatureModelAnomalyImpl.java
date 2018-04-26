/**
 */
package de.darwinspl.anomaly.impl;

import de.darwinspl.anomaly.DwAnomalyPackage;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;

import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeatureModel;

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
 * An implementation of the model object '<em><b>Dw Void Feature Model Anomaly</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl#getValidSince <em>Valid Since</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl#getContextValueModel <em>Context Value Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DwVoidFeatureModelAnomalyImpl extends MinimalEObjectImpl.Container implements DwVoidFeatureModelAnomaly {
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
	 * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected HyFeatureModel featureModel;

	/**
	 * The cached value of the '{@link #getContextValueModel() <em>Context Value Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextValueModel()
	 * @generated
	 * @ordered
	 */
	protected HyContextValueModel contextValueModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwVoidFeatureModelAnomalyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DwAnomalyPackage.Literals.DW_VOID_FEATURE_MODEL_ANOMALY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_SINCE, oldValidSince, validSince));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_UNTIL, oldValidUntil, validUntil));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureModel getFeatureModel() {
		if (featureModel != null && featureModel.eIsProxy()) {
			InternalEObject oldFeatureModel = (InternalEObject)featureModel;
			featureModel = (HyFeatureModel)eResolveProxy(oldFeatureModel);
			if (featureModel != oldFeatureModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL, oldFeatureModel, featureModel));
			}
		}
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureModel basicGetFeatureModel() {
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureModel(HyFeatureModel newFeatureModel) {
		HyFeatureModel oldFeatureModel = featureModel;
		featureModel = newFeatureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL, oldFeatureModel, featureModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyContextValueModel getContextValueModel() {
		return contextValueModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextValueModel(HyContextValueModel newContextValueModel, NotificationChain msgs) {
		HyContextValueModel oldContextValueModel = contextValueModel;
		contextValueModel = newContextValueModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL, oldContextValueModel, newContextValueModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextValueModel(HyContextValueModel newContextValueModel) {
		if (newContextValueModel != contextValueModel) {
			NotificationChain msgs = null;
			if (contextValueModel != null)
				msgs = ((InternalEObject)contextValueModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL, null, msgs);
			if (newContextValueModel != null)
				msgs = ((InternalEObject)newContextValueModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL, null, msgs);
			msgs = basicSetContextValueModel(newContextValueModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL, newContextValueModel, newContextValueModel));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL:
				return basicSetContextValueModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_SINCE:
				return getValidSince();
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_UNTIL:
				return getValidUntil();
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__ID:
				return getId();
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL:
				if (resolve) return getFeatureModel();
				return basicGetFeatureModel();
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL:
				return getContextValueModel();
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
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_SINCE:
				setValidSince((Date)newValue);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_UNTIL:
				setValidUntil((Date)newValue);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__ID:
				setId((String)newValue);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL:
				setFeatureModel((HyFeatureModel)newValue);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL:
				setContextValueModel((HyContextValueModel)newValue);
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
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_SINCE:
				setValidSince(VALID_SINCE_EDEFAULT);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_UNTIL:
				setValidUntil(VALID_UNTIL_EDEFAULT);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__ID:
				setId(ID_EDEFAULT);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL:
				setFeatureModel((HyFeatureModel)null);
				return;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL:
				setContextValueModel((HyContextValueModel)null);
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
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_SINCE:
				return VALID_SINCE_EDEFAULT == null ? validSince != null : !VALID_SINCE_EDEFAULT.equals(validSince);
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__VALID_UNTIL:
				return VALID_UNTIL_EDEFAULT == null ? validUntil != null : !VALID_UNTIL_EDEFAULT.equals(validUntil);
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL:
				return featureModel != null;
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL:
				return contextValueModel != null;
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
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY___CREATE_ID:
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

} //DwVoidFeatureModelAnomalyImpl
