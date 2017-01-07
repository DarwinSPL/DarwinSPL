/**
 */
package EvolutionOperation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see EvolutionOperation.EvolutionOperationFactory
 * @model kind="package"
 * @generated
 */
public interface EvolutionOperationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EvolutionOperation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://tu-bs.de/isf/evoOpFramework";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EvolutionOperation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EvolutionOperationPackage eINSTANCE = EvolutionOperation.impl.EvolutionOperationPackageImpl.init();

	/**
	 * The meta object id for the '{@link EvolutionOperation.impl.AddNameImpl <em>Add Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EvolutionOperation.impl.AddNameImpl
	 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddName()
	 * @generated
	 */
	int ADD_NAME = 0;

	/**
	 * The number of structural features of the '<em>Add Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME___EXECUTE__STRING_DATE = 0;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME___UNDO = 1;

	/**
	 * The number of operations of the '<em>Add Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link EvolutionOperation.impl.EvoOpImpl <em>Evo Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EvolutionOperation.impl.EvoOpImpl
	 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getEvoOp()
	 * @generated
	 */
	int EVO_OP = 1;

	/**
	 * The number of structural features of the '<em>Evo Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVO_OP_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVO_OP___EXECUTE = 0;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVO_OP___UNDO = 1;

	/**
	 * The number of operations of the '<em>Evo Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVO_OP_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link EvolutionOperation.impl.ComplexOpImpl <em>Complex Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EvolutionOperation.impl.ComplexOpImpl
	 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getComplexOp()
	 * @generated
	 */
	int COMPLEX_OP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP__NAME = 0;

	/**
	 * The number of structural features of the '<em>Complex Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP___EXECUTE = 0;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP___UNDO = 1;

	/**
	 * The operation id for the '<em>Add</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP___ADD__EVOOP = 2;

	/**
	 * The operation id for the '<em>Remove</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP___REMOVE__EVOOP = 3;

	/**
	 * The number of operations of the '<em>Complex Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_OP_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link EvolutionOperation.impl.AddFeatureTypImpl <em>Add Feature Typ</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EvolutionOperation.impl.AddFeatureTypImpl
	 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddFeatureTyp()
	 * @generated
	 */
	int ADD_FEATURE_TYP = 3;

	/**
	 * The number of structural features of the '<em>Add Feature Typ</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_TYP_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_TYP___EXECUTE__DATE = 0;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_TYP___UNDO = 1;

	/**
	 * The number of operations of the '<em>Add Feature Typ</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_TYP_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link EvolutionOperation.impl.AddAttributeImpl <em>Add Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EvolutionOperation.impl.AddAttributeImpl
	 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddAttribute()
	 * @generated
	 */
	int ADD_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Add Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE___EXECUTE__DATE = 0;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE___UNDO = 1;

	/**
	 * The number of operations of the '<em>Add Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link EvolutionOperation.impl.AddFeatureImpl <em>Add Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EvolutionOperation.impl.AddFeatureImpl
	 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddFeature()
	 * @generated
	 */
	int ADD_FEATURE = 5;

	/**
	 * The number of structural features of the '<em>Add Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE___EXECUTE__STRING_DATE = 0;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE___UNDO = 1;

	/**
	 * The number of operations of the '<em>Add Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_OPERATION_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link EvolutionOperation.AddName <em>Add Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Name</em>'.
	 * @see EvolutionOperation.AddName
	 * @generated
	 */
	EClass getAddName();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddName#execute(java.lang.String, java.util.Date) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see EvolutionOperation.AddName#execute(java.lang.String, java.util.Date)
	 * @generated
	 */
	EOperation getAddName__Execute__String_Date();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddName#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see EvolutionOperation.AddName#undo()
	 * @generated
	 */
	EOperation getAddName__Undo();

	/**
	 * Returns the meta object for class '{@link EvolutionOperation.EvoOp <em>Evo Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evo Op</em>'.
	 * @see EvolutionOperation.EvoOp
	 * @generated
	 */
	EClass getEvoOp();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.EvoOp#execute() <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see EvolutionOperation.EvoOp#execute()
	 * @generated
	 */
	EOperation getEvoOp__Execute();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.EvoOp#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see EvolutionOperation.EvoOp#undo()
	 * @generated
	 */
	EOperation getEvoOp__Undo();

	/**
	 * Returns the meta object for class '{@link EvolutionOperation.ComplexOp <em>Complex Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Op</em>'.
	 * @see EvolutionOperation.ComplexOp
	 * @generated
	 */
	EClass getComplexOp();

	/**
	 * Returns the meta object for the attribute '{@link EvolutionOperation.ComplexOp#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EvolutionOperation.ComplexOp#getName()
	 * @see #getComplexOp()
	 * @generated
	 */
	EAttribute getComplexOp_Name();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.ComplexOp#execute() <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see EvolutionOperation.ComplexOp#execute()
	 * @generated
	 */
	EOperation getComplexOp__Execute();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.ComplexOp#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see EvolutionOperation.ComplexOp#undo()
	 * @generated
	 */
	EOperation getComplexOp__Undo();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.ComplexOp#add(EvolutionOperation.EvoOp) <em>Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add</em>' operation.
	 * @see EvolutionOperation.ComplexOp#add(EvolutionOperation.EvoOp)
	 * @generated
	 */
	EOperation getComplexOp__Add__EvoOp();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.ComplexOp#remove(EvolutionOperation.EvoOp) <em>Remove</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove</em>' operation.
	 * @see EvolutionOperation.ComplexOp#remove(EvolutionOperation.EvoOp)
	 * @generated
	 */
	EOperation getComplexOp__Remove__EvoOp();

	/**
	 * Returns the meta object for class '{@link EvolutionOperation.AddFeatureTyp <em>Add Feature Typ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Feature Typ</em>'.
	 * @see EvolutionOperation.AddFeatureTyp
	 * @generated
	 */
	EClass getAddFeatureTyp();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddFeatureTyp#execute(java.util.Date) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see EvolutionOperation.AddFeatureTyp#execute(java.util.Date)
	 * @generated
	 */
	EOperation getAddFeatureTyp__Execute__Date();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddFeatureTyp#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see EvolutionOperation.AddFeatureTyp#undo()
	 * @generated
	 */
	EOperation getAddFeatureTyp__Undo();

	/**
	 * Returns the meta object for class '{@link EvolutionOperation.AddAttribute <em>Add Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Attribute</em>'.
	 * @see EvolutionOperation.AddAttribute
	 * @generated
	 */
	EClass getAddAttribute();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddAttribute#execute(java.util.Date) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see EvolutionOperation.AddAttribute#execute(java.util.Date)
	 * @generated
	 */
	EOperation getAddAttribute__Execute__Date();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddAttribute#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see EvolutionOperation.AddAttribute#undo()
	 * @generated
	 */
	EOperation getAddAttribute__Undo();

	/**
	 * Returns the meta object for class '{@link EvolutionOperation.AddFeature <em>Add Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Feature</em>'.
	 * @see EvolutionOperation.AddFeature
	 * @generated
	 */
	EClass getAddFeature();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddFeature#execute(java.lang.String, java.util.Date) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see EvolutionOperation.AddFeature#execute(java.lang.String, java.util.Date)
	 * @generated
	 */
	EOperation getAddFeature__Execute__String_Date();

	/**
	 * Returns the meta object for the '{@link EvolutionOperation.AddFeature#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see EvolutionOperation.AddFeature#undo()
	 * @generated
	 */
	EOperation getAddFeature__Undo();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EvolutionOperationFactory getEvolutionOperationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link EvolutionOperation.impl.AddNameImpl <em>Add Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EvolutionOperation.impl.AddNameImpl
		 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddName()
		 * @generated
		 */
		EClass ADD_NAME = eINSTANCE.getAddName();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_NAME___EXECUTE__STRING_DATE = eINSTANCE.getAddName__Execute__String_Date();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_NAME___UNDO = eINSTANCE.getAddName__Undo();

		/**
		 * The meta object literal for the '{@link EvolutionOperation.impl.EvoOpImpl <em>Evo Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EvolutionOperation.impl.EvoOpImpl
		 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getEvoOp()
		 * @generated
		 */
		EClass EVO_OP = eINSTANCE.getEvoOp();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVO_OP___EXECUTE = eINSTANCE.getEvoOp__Execute();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVO_OP___UNDO = eINSTANCE.getEvoOp__Undo();

		/**
		 * The meta object literal for the '{@link EvolutionOperation.impl.ComplexOpImpl <em>Complex Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EvolutionOperation.impl.ComplexOpImpl
		 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getComplexOp()
		 * @generated
		 */
		EClass COMPLEX_OP = eINSTANCE.getComplexOp();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX_OP__NAME = eINSTANCE.getComplexOp_Name();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_OP___EXECUTE = eINSTANCE.getComplexOp__Execute();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_OP___UNDO = eINSTANCE.getComplexOp__Undo();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_OP___ADD__EVOOP = eINSTANCE.getComplexOp__Add__EvoOp();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_OP___REMOVE__EVOOP = eINSTANCE.getComplexOp__Remove__EvoOp();

		/**
		 * The meta object literal for the '{@link EvolutionOperation.impl.AddFeatureTypImpl <em>Add Feature Typ</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EvolutionOperation.impl.AddFeatureTypImpl
		 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddFeatureTyp()
		 * @generated
		 */
		EClass ADD_FEATURE_TYP = eINSTANCE.getAddFeatureTyp();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_FEATURE_TYP___EXECUTE__DATE = eINSTANCE.getAddFeatureTyp__Execute__Date();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_FEATURE_TYP___UNDO = eINSTANCE.getAddFeatureTyp__Undo();

		/**
		 * The meta object literal for the '{@link EvolutionOperation.impl.AddAttributeImpl <em>Add Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EvolutionOperation.impl.AddAttributeImpl
		 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddAttribute()
		 * @generated
		 */
		EClass ADD_ATTRIBUTE = eINSTANCE.getAddAttribute();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_ATTRIBUTE___EXECUTE__DATE = eINSTANCE.getAddAttribute__Execute__Date();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_ATTRIBUTE___UNDO = eINSTANCE.getAddAttribute__Undo();

		/**
		 * The meta object literal for the '{@link EvolutionOperation.impl.AddFeatureImpl <em>Add Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EvolutionOperation.impl.AddFeatureImpl
		 * @see EvolutionOperation.impl.EvolutionOperationPackageImpl#getAddFeature()
		 * @generated
		 */
		EClass ADD_FEATURE = eINSTANCE.getAddFeature();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_FEATURE___EXECUTE__STRING_DATE = eINSTANCE.getAddFeature__Execute__String_Date();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_FEATURE___UNDO = eINSTANCE.getAddFeature__Undo();

	}

} //EvolutionOperationPackage
