/**
 */
package EvolutionOperation.impl;

import EvolutionOperation.AddAttribute;
import EvolutionOperation.EvolutionOperationPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AddAttributeImpl extends MinimalEObjectImpl.Container implements AddAttribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionOperationPackage.Literals.ADD_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void execute(Date timestamp) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void undo() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EvolutionOperationPackage.ADD_ATTRIBUTE___EXECUTE__DATE:
				execute((Date)arguments.get(0));
				return null;
			case EvolutionOperationPackage.ADD_ATTRIBUTE___UNDO:
				undo();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //AddAttributeImpl
