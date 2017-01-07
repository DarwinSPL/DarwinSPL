/**
 */
package EvolutionOperation.impl;

import EvolutionOperation.AddFeature;
import EvolutionOperation.EvolutionOperationPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AddFeatureImpl extends MinimalEObjectImpl.Container implements AddFeature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionOperationPackage.Literals.ADD_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void execute(String name, Date timestamp) {
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
			case EvolutionOperationPackage.ADD_FEATURE___EXECUTE__STRING_DATE:
				execute((String)arguments.get(0), (Date)arguments.get(1));
				return null;
			case EvolutionOperationPackage.ADD_FEATURE___UNDO:
				undo();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //AddFeatureImpl
