/**
 */
package EvolutionOperation;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see EvolutionOperation.EvolutionOperationPackage#getAddAttribute()
 * @model
 * @generated
 */
public interface AddAttribute extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute(Date timestamp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void undo();

} // AddAttribute
