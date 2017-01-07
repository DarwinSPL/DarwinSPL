/**
 */
package EvolutionOperation.impl;

import EvolutionOperation.AddFeatureTyp;
import EvolutionOperation.EvolutionOperationPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Feature Typ</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AddFeatureTypImpl extends MinimalEObjectImpl.Container implements AddFeatureTyp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddFeatureTypImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionOperationPackage.Literals.ADD_FEATURE_TYP;
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
			case EvolutionOperationPackage.ADD_FEATURE_TYP___EXECUTE__DATE:
				execute((Date)arguments.get(0));
				return null;
			case EvolutionOperationPackage.ADD_FEATURE_TYP___UNDO:
				undo();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //AddFeatureTypImpl
