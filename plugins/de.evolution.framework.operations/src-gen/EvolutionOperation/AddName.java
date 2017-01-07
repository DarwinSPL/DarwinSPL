/**
 */
package EvolutionOperation;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Name</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see EvolutionOperation.EvolutionOperationPackage#getAddName()
 * @model
 * @generated
 */
public interface AddName extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute(String name, Date timestamp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void undo();

} // AddName
