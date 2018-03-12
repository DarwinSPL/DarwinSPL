/**
 */
package de.darwinspl.anomaly;

import eu.hyvar.evolution.HyEvolutionPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.darwinspl.anomaly.DwAnomalyFactory
 * @model kind="package"
 * @generated
 */
public interface DwAnomalyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "anomaly";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://darwinspl.de/anomaly/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "anomaly";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DwAnomalyPackage eINSTANCE = de.darwinspl.anomaly.impl.DwAnomalyPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.darwinspl.anomaly.DwAnomaly <em>Dw Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.anomaly.DwAnomaly
	 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwAnomaly()
	 * @generated
	 */
	int DW_ANOMALY = 0;

	/**
	 * The feature id for the '<em><b>Valid Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_ANOMALY__VALID_SINCE = HyEvolutionPackage.HY_TEMPORAL_ELEMENT__VALID_SINCE;

	/**
	 * The feature id for the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_ANOMALY__VALID_UNTIL = HyEvolutionPackage.HY_TEMPORAL_ELEMENT__VALID_UNTIL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_ANOMALY__ID = HyEvolutionPackage.HY_TEMPORAL_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Dw Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_ANOMALY_FEATURE_COUNT = HyEvolutionPackage.HY_TEMPORAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_ANOMALY___CREATE_ID = HyEvolutionPackage.HY_TEMPORAL_ELEMENT___CREATE_ID;

	/**
	 * The number of operations of the '<em>Dw Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_ANOMALY_OPERATION_COUNT = HyEvolutionPackage.HY_TEMPORAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl <em>Dw Void Feature Model Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl
	 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwVoidFeatureModelAnomaly()
	 * @generated
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY = 1;

	/**
	 * The feature id for the '<em><b>Valid Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY__VALID_SINCE = DW_ANOMALY__VALID_SINCE;

	/**
	 * The feature id for the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY__VALID_UNTIL = DW_ANOMALY__VALID_UNTIL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY__ID = DW_ANOMALY__ID;

	/**
	 * The feature id for the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL = DW_ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context Value Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL = DW_ANOMALY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dw Void Feature Model Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY_FEATURE_COUNT = DW_ANOMALY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY___CREATE_ID = DW_ANOMALY___CREATE_ID;

	/**
	 * The number of operations of the '<em>Dw Void Feature Model Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_VOID_FEATURE_MODEL_ANOMALY_OPERATION_COUNT = DW_ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.anomaly.DwFeatureAnomaly <em>Dw Feature Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.anomaly.DwFeatureAnomaly
	 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwFeatureAnomaly()
	 * @generated
	 */
	int DW_FEATURE_ANOMALY = 2;

	/**
	 * The feature id for the '<em><b>Valid Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY__VALID_SINCE = DW_ANOMALY__VALID_SINCE;

	/**
	 * The feature id for the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY__VALID_UNTIL = DW_ANOMALY__VALID_UNTIL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY__ID = DW_ANOMALY__ID;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY__FEATURE = DW_ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Feature Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY_FEATURE_COUNT = DW_ANOMALY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY___CREATE_ID = DW_ANOMALY___CREATE_ID;

	/**
	 * The number of operations of the '<em>Dw Feature Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FEATURE_ANOMALY_OPERATION_COUNT = DW_ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.anomaly.impl.DwFalseOptionalFeatureAnomalyImpl <em>Dw False Optional Feature Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.anomaly.impl.DwFalseOptionalFeatureAnomalyImpl
	 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwFalseOptionalFeatureAnomaly()
	 * @generated
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY = 3;

	/**
	 * The feature id for the '<em><b>Valid Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY__VALID_SINCE = DW_FEATURE_ANOMALY__VALID_SINCE;

	/**
	 * The feature id for the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY__VALID_UNTIL = DW_FEATURE_ANOMALY__VALID_UNTIL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY__ID = DW_FEATURE_ANOMALY__ID;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY__FEATURE = DW_FEATURE_ANOMALY__FEATURE;

	/**
	 * The number of structural features of the '<em>Dw False Optional Feature Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY_FEATURE_COUNT = DW_FEATURE_ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY___CREATE_ID = DW_FEATURE_ANOMALY___CREATE_ID;

	/**
	 * The number of operations of the '<em>Dw False Optional Feature Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_FALSE_OPTIONAL_FEATURE_ANOMALY_OPERATION_COUNT = DW_FEATURE_ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl <em>Dw Dead Feature Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl
	 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwDeadFeatureAnomaly()
	 * @generated
	 */
	int DW_DEAD_FEATURE_ANOMALY = 4;

	/**
	 * The feature id for the '<em><b>Valid Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY__VALID_SINCE = DW_FEATURE_ANOMALY__VALID_SINCE;

	/**
	 * The feature id for the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY__VALID_UNTIL = DW_FEATURE_ANOMALY__VALID_UNTIL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY__ID = DW_FEATURE_ANOMALY__ID;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY__FEATURE = DW_FEATURE_ANOMALY__FEATURE;

	/**
	 * The number of structural features of the '<em>Dw Dead Feature Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY_FEATURE_COUNT = DW_FEATURE_ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY___CREATE_ID = DW_FEATURE_ANOMALY___CREATE_ID;

	/**
	 * The number of operations of the '<em>Dw Dead Feature Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_DEAD_FEATURE_ANOMALY_OPERATION_COUNT = DW_FEATURE_ANOMALY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.darwinspl.anomaly.DwAnomaly <em>Dw Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Anomaly</em>'.
	 * @see de.darwinspl.anomaly.DwAnomaly
	 * @generated
	 */
	EClass getDwAnomaly();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly <em>Dw Void Feature Model Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Void Feature Model Anomaly</em>'.
	 * @see de.darwinspl.anomaly.DwVoidFeatureModelAnomaly
	 * @generated
	 */
	EClass getDwVoidFeatureModelAnomaly();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getFeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Model</em>'.
	 * @see de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getFeatureModel()
	 * @see #getDwVoidFeatureModelAnomaly()
	 * @generated
	 */
	EReference getDwVoidFeatureModelAnomaly_FeatureModel();

	/**
	 * Returns the meta object for the containment reference '{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getContextValueModel <em>Context Value Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Value Model</em>'.
	 * @see de.darwinspl.anomaly.DwVoidFeatureModelAnomaly#getContextValueModel()
	 * @see #getDwVoidFeatureModelAnomaly()
	 * @generated
	 */
	EReference getDwVoidFeatureModelAnomaly_ContextValueModel();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.anomaly.DwFeatureAnomaly <em>Dw Feature Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Feature Anomaly</em>'.
	 * @see de.darwinspl.anomaly.DwFeatureAnomaly
	 * @generated
	 */
	EClass getDwFeatureAnomaly();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.anomaly.DwFeatureAnomaly#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see de.darwinspl.anomaly.DwFeatureAnomaly#getFeature()
	 * @see #getDwFeatureAnomaly()
	 * @generated
	 */
	EReference getDwFeatureAnomaly_Feature();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly <em>Dw False Optional Feature Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw False Optional Feature Anomaly</em>'.
	 * @see de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly
	 * @generated
	 */
	EClass getDwFalseOptionalFeatureAnomaly();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.anomaly.DwDeadFeatureAnomaly <em>Dw Dead Feature Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Dead Feature Anomaly</em>'.
	 * @see de.darwinspl.anomaly.DwDeadFeatureAnomaly
	 * @generated
	 */
	EClass getDwDeadFeatureAnomaly();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DwAnomalyFactory getDwAnomalyFactory();

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
		 * The meta object literal for the '{@link de.darwinspl.anomaly.DwAnomaly <em>Dw Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.anomaly.DwAnomaly
		 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwAnomaly()
		 * @generated
		 */
		EClass DW_ANOMALY = eINSTANCE.getDwAnomaly();

		/**
		 * The meta object literal for the '{@link de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl <em>Dw Void Feature Model Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.anomaly.impl.DwVoidFeatureModelAnomalyImpl
		 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwVoidFeatureModelAnomaly()
		 * @generated
		 */
		EClass DW_VOID_FEATURE_MODEL_ANOMALY = eINSTANCE.getDwVoidFeatureModelAnomaly();

		/**
		 * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL = eINSTANCE.getDwVoidFeatureModelAnomaly_FeatureModel();

		/**
		 * The meta object literal for the '<em><b>Context Value Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_VOID_FEATURE_MODEL_ANOMALY__CONTEXT_VALUE_MODEL = eINSTANCE.getDwVoidFeatureModelAnomaly_ContextValueModel();

		/**
		 * The meta object literal for the '{@link de.darwinspl.anomaly.DwFeatureAnomaly <em>Dw Feature Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.anomaly.DwFeatureAnomaly
		 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwFeatureAnomaly()
		 * @generated
		 */
		EClass DW_FEATURE_ANOMALY = eINSTANCE.getDwFeatureAnomaly();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_FEATURE_ANOMALY__FEATURE = eINSTANCE.getDwFeatureAnomaly_Feature();

		/**
		 * The meta object literal for the '{@link de.darwinspl.anomaly.impl.DwFalseOptionalFeatureAnomalyImpl <em>Dw False Optional Feature Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.anomaly.impl.DwFalseOptionalFeatureAnomalyImpl
		 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwFalseOptionalFeatureAnomaly()
		 * @generated
		 */
		EClass DW_FALSE_OPTIONAL_FEATURE_ANOMALY = eINSTANCE.getDwFalseOptionalFeatureAnomaly();

		/**
		 * The meta object literal for the '{@link de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl <em>Dw Dead Feature Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl
		 * @see de.darwinspl.anomaly.impl.DwAnomalyPackageImpl#getDwDeadFeatureAnomaly()
		 * @generated
		 */
		EClass DW_DEAD_FEATURE_ANOMALY = eINSTANCE.getDwDeadFeatureAnomaly();

	}

} //DwAnomalyPackage
