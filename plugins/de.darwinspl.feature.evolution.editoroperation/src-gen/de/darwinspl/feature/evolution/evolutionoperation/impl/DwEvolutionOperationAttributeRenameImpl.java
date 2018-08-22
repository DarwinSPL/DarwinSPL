/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.evolution.HyName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation Attribute Rename</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeRenameImpl#getOldName <em>Old Name</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeRenameImpl#getNewName <em>New Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DwEvolutionOperationAttributeRenameImpl extends DwEvolutionOperationAttributeImpl implements DwEvolutionOperationAttributeRename {
	/**
	 * The cached value of the '{@link #getOldName() <em>Old Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldName()
	 * @generated
	 * @ordered
	 */
	protected HyName oldName;

	/**
	 * The cached value of the '{@link #getNewName() <em>New Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewName()
	 * @generated
	 * @ordered
	 */
	protected HyName newName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationAttributeRenameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyName getOldName() {
		if (oldName != null && oldName.eIsProxy()) {
			InternalEObject oldOldName = (InternalEObject)oldName;
			oldName = (HyName)eResolveProxy(oldOldName);
			if (oldName != oldOldName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME, oldOldName, oldName));
			}
		}
		return oldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyName basicGetOldName() {
		return oldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldName(HyName newOldName) {
		HyName oldOldName = oldName;
		oldName = newOldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME, oldOldName, oldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyName getNewName() {
		if (newName != null && newName.eIsProxy()) {
			InternalEObject oldNewName = (InternalEObject)newName;
			newName = (HyName)eResolveProxy(oldNewName);
			if (newName != oldNewName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME, oldNewName, newName));
			}
		}
		return newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyName basicGetNewName() {
		return newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewName(HyName newNewName) {
		HyName oldNewName = newName;
		newName = newNewName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME, oldNewName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME:
				if (resolve) return getOldName();
				return basicGetOldName();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME:
				if (resolve) return getNewName();
				return basicGetNewName();
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME:
				setOldName((HyName)newValue);
				return;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME:
				setNewName((HyName)newValue);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME:
				setOldName((HyName)null);
				return;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME:
				setNewName((HyName)null);
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
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME:
				return oldName != null;
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME:
				return newName != null;
		}
		return super.eIsSet(featureID);
	}

} //DwEvolutionOperationAttributeRenameImpl
