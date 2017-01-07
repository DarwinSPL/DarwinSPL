/**
 */
package EvolutionOperation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see EvolutionOperation.EvolutionOperationPackage
 * @generated
 */
public interface EvolutionOperationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EvolutionOperationFactory eINSTANCE = EvolutionOperation.impl.EvolutionOperationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Add Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Name</em>'.
	 * @generated
	 */
	AddName createAddName();

	/**
	 * Returns a new object of class '<em>Evo Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evo Op</em>'.
	 * @generated
	 */
	EvoOp createEvoOp();

	/**
	 * Returns a new object of class '<em>Complex Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Op</em>'.
	 * @generated
	 */
	ComplexOp createComplexOp();

	/**
	 * Returns a new object of class '<em>Add Feature Typ</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Feature Typ</em>'.
	 * @generated
	 */
	AddFeatureTyp createAddFeatureTyp();

	/**
	 * Returns a new object of class '<em>Add Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Attribute</em>'.
	 * @generated
	 */
	AddAttribute createAddAttribute();

	/**
	 * Returns a new object of class '<em>Add Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Feature</em>'.
	 * @generated
	 */
	AddFeature createAddFeature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EvolutionOperationPackage getEvolutionOperationPackage();

} //EvolutionOperationFactory
