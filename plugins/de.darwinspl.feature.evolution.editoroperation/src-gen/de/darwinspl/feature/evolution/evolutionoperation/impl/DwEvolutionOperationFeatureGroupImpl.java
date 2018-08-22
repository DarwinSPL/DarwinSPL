/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.feature.HyGroupComposition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation Feature Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureGroupImpl#getOldGroup <em>Old Group</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureGroupImpl#getNewGroup <em>New Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DwEvolutionOperationFeatureGroupImpl extends DwEvolutionOperationFeatureImpl implements DwEvolutionOperationFeatureGroup {
	/**
	 * The cached value of the '{@link #getOldGroup() <em>Old Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldGroup()
	 * @generated
	 * @ordered
	 */
	protected HyGroupComposition oldGroup;

	/**
	 * The cached value of the '{@link #getNewGroup() <em>New Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewGroup()
	 * @generated
	 * @ordered
	 */
	protected HyGroupComposition newGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationFeatureGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION_FEATURE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyGroupComposition getOldGroup() {
		if (oldGroup != null && oldGroup.eIsProxy()) {
			InternalEObject oldOldGroup = (InternalEObject)oldGroup;
			oldGroup = (HyGroupComposition)eResolveProxy(oldOldGroup);
			if (oldGroup != oldOldGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP, oldOldGroup, oldGroup));
			}
		}
		return oldGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyGroupComposition basicGetOldGroup() {
		return oldGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldGroup(HyGroupComposition newOldGroup) {
		HyGroupComposition oldOldGroup = oldGroup;
		oldGroup = newOldGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP, oldOldGroup, oldGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyGroupComposition getNewGroup() {
		if (newGroup != null && newGroup.eIsProxy()) {
			InternalEObject oldNewGroup = (InternalEObject)newGroup;
			newGroup = (HyGroupComposition)eResolveProxy(oldNewGroup);
			if (newGroup != oldNewGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP, oldNewGroup, newGroup));
			}
		}
		return newGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyGroupComposition basicGetNewGroup() {
		return newGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewGroup(HyGroupComposition newNewGroup) {
		HyGroupComposition oldNewGroup = newGroup;
		newGroup = newNewGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP, oldNewGroup, newGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP:
				if (resolve) return getOldGroup();
				return basicGetOldGroup();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP:
				if (resolve) return getNewGroup();
				return basicGetNewGroup();
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP:
				setOldGroup((HyGroupComposition)newValue);
				return;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP:
				setNewGroup((HyGroupComposition)newValue);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP:
				setOldGroup((HyGroupComposition)null);
				return;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP:
				setNewGroup((HyGroupComposition)null);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP:
				return oldGroup != null;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP:
				return newGroup != null;
		}
		return super.eIsSet(featureID);
	}

} //DwEvolutionOperationFeatureGroupImpl
