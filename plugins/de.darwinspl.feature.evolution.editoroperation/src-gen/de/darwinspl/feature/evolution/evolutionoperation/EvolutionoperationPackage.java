/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationFactory
 * @model kind="package"
 * @generated
 */
public interface EvolutionoperationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "evolutionoperation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hyvar-project.eu/evolution/evolutionoperation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "evolutionoperation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EvolutionoperationPackage eINSTANCE = de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationImpl <em>Dw Evolution Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperation()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION__EVO_STEP = 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureImpl <em>Dw Evolution Operation Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeature()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE__FEATURE = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureCreateImpl <em>Dw Evolution Operation Feature Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_CREATE = 2;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_CREATE__FEATURE = DW_EVOLUTION_OPERATION_FEATURE__FEATURE;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureDeleteImpl <em>Dw Evolution Operation Feature Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_DELETE = 3;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_DELETE__FEATURE = DW_EVOLUTION_OPERATION_FEATURE__FEATURE;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureRenameImpl <em>Dw Evolution Operation Feature Rename</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureRenameImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureRename()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME = 4;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME__FEATURE = DW_EVOLUTION_OPERATION_FEATURE__FEATURE;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME__OLD_NAME = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME__NEW_NAME = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Rename</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Rename</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_RENAME_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureTypeImpl <em>Dw Evolution Operation Feature Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureTypeImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureType()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE__FEATURE = DW_EVOLUTION_OPERATION_FEATURE__FEATURE;

	/**
	 * The feature id for the '<em><b>Old Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_TYPE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureGroupImpl <em>Dw Evolution Operation Feature Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureGroupImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureGroup()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP = 6;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP__FEATURE = DW_EVOLUTION_OPERATION_FEATURE__FEATURE;

	/**
	 * The feature id for the '<em><b>Old Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_GROUP_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionImpl <em>Dw Evolution Operation Feature Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureVersion()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION = 7;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION__FEATURE = DW_EVOLUTION_OPERATION_FEATURE__FEATURE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION__VERSION = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionCreateImpl <em>Dw Evolution Operation Feature Version Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureVersionCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE = 8;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE_VERSION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE__FEATURE = DW_EVOLUTION_OPERATION_FEATURE_VERSION__FEATURE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE__VERSION = DW_EVOLUTION_OPERATION_FEATURE_VERSION__VERSION;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Version Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_VERSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Version Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_VERSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionDeleteImpl <em>Dw Evolution Operation Feature Version Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureVersionDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE = 9;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_FEATURE_VERSION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE__FEATURE = DW_EVOLUTION_OPERATION_FEATURE_VERSION__FEATURE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE__VERSION = DW_EVOLUTION_OPERATION_FEATURE_VERSION__VERSION;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Feature Version Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_VERSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Feature Version Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_FEATURE_VERSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupImpl <em>Dw Evolution Operation Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroup()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_GROUP = 10;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP__GROUP = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupTypeImpl <em>Dw Evolution Operation Group Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupTypeImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupType()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE__EVO_STEP = DW_EVOLUTION_OPERATION_GROUP__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE__GROUP = DW_EVOLUTION_OPERATION_GROUP__GROUP;

	/**
	 * The feature id for the '<em><b>Old Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE__OLD_TYPE = DW_EVOLUTION_OPERATION_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE__NEW_TYPE = DW_EVOLUTION_OPERATION_GROUP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_GROUP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Group Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_TYPE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesImpl <em>Dw Evolution Operation Group Features</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupFeatures()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES = 12;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES__EVO_STEP = DW_EVOLUTION_OPERATION_GROUP__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES__GROUP = DW_EVOLUTION_OPERATION_GROUP__GROUP;

	/**
	 * The feature id for the '<em><b>Affected Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES = DW_EVOLUTION_OPERATION_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Group Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_FEATURE_COUNT = DW_EVOLUTION_OPERATION_GROUP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Group Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_OPERATION_COUNT = DW_EVOLUTION_OPERATION_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesAddedImpl <em>Dw Evolution Operation Group Features Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesAddedImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupFeaturesAdded()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED = 13;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED__EVO_STEP = DW_EVOLUTION_OPERATION_GROUP_FEATURES__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED__GROUP = DW_EVOLUTION_OPERATION_GROUP_FEATURES__GROUP;

	/**
	 * The feature id for the '<em><b>Affected Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED__AFFECTED_FEATURES = DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Group Features Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED_FEATURE_COUNT = DW_EVOLUTION_OPERATION_GROUP_FEATURES_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Group Features Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED_OPERATION_COUNT = DW_EVOLUTION_OPERATION_GROUP_FEATURES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesRemovedImpl <em>Dw Evolution Operation Group Features Removed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesRemovedImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupFeaturesRemoved()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED = 14;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED__EVO_STEP = DW_EVOLUTION_OPERATION_GROUP_FEATURES__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED__GROUP = DW_EVOLUTION_OPERATION_GROUP_FEATURES__GROUP;

	/**
	 * The feature id for the '<em><b>Affected Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED__AFFECTED_FEATURES = DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Group Features Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED_FEATURE_COUNT = DW_EVOLUTION_OPERATION_GROUP_FEATURES_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Group Features Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED_OPERATION_COUNT = DW_EVOLUTION_OPERATION_GROUP_FEATURES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeImpl <em>Dw Evolution Operation Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttribute()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE = 15;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE__ATTRIBUTE = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeCreateImpl <em>Dw Evolution Operation Attribute Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttributeCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE = 16;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_ATTRIBUTE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE__ATTRIBUTE = DW_EVOLUTION_OPERATION_ATTRIBUTE__ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Attribute Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Attribute Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeDeleteImpl <em>Dw Evolution Operation Attribute Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttributeDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE = 17;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_ATTRIBUTE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE__ATTRIBUTE = DW_EVOLUTION_OPERATION_ATTRIBUTE__ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Attribute Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Attribute Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeRenameImpl <em>Dw Evolution Operation Attribute Rename</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeRenameImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttributeRename()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME = 18;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__EVO_STEP = DW_EVOLUTION_OPERATION_ATTRIBUTE__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__ATTRIBUTE = DW_EVOLUTION_OPERATION_ATTRIBUTE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME = DW_EVOLUTION_OPERATION_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME = DW_EVOLUTION_OPERATION_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Attribute Rename</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Attribute Rename</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumImpl <em>Dw Evolution Operation Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnum()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ENUM = 19;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM__ENUM = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumCreateImpl <em>Dw Evolution Operation Enum Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ENUM_CREATE = 20;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_ENUM__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_CREATE__ENUM = DW_EVOLUTION_OPERATION_ENUM__ENUM;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Enum Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ENUM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Enum Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ENUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumDeleteImpl <em>Dw Evolution Operation Enum Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ENUM_DELETE = 21;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_ENUM__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_DELETE__ENUM = DW_EVOLUTION_OPERATION_ENUM__ENUM;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Enum Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ENUM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Enum Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ENUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralImpl <em>Dw Evolution Operation Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumLiteral()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL = 22;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL__EVO_STEP = DW_EVOLUTION_OPERATION_ENUM__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL__ENUM = DW_EVOLUTION_OPERATION_ENUM__ENUM;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL__LITERAL = DW_EVOLUTION_OPERATION_ENUM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ENUM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ENUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralCreateImpl <em>Dw Evolution Operation Enum Literal Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumLiteralCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE = 23;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_ENUM_LITERAL__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE__ENUM = DW_EVOLUTION_OPERATION_ENUM_LITERAL__ENUM;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE__LITERAL = DW_EVOLUTION_OPERATION_ENUM_LITERAL__LITERAL;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Enum Literal Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ENUM_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Enum Literal Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ENUM_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralDeleteImpl <em>Dw Evolution Operation Enum Literal Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumLiteralDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE = 24;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_ENUM_LITERAL__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE__ENUM = DW_EVOLUTION_OPERATION_ENUM_LITERAL__ENUM;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE__LITERAL = DW_EVOLUTION_OPERATION_ENUM_LITERAL__LITERAL;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Enum Literal Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_ENUM_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Enum Literal Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_ENUM_LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintImpl <em>Dw Evolution Operation Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationConstraint()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT = 25;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT__CONSTRAINT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintCreateImpl <em>Dw Evolution Operation Constraint Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationConstraintCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE = 26;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_CONSTRAINT__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE__CONSTRAINT = DW_EVOLUTION_OPERATION_CONSTRAINT__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Constraint Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Constraint Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintDeleteImpl <em>Dw Evolution Operation Constraint Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationConstraintDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE = 27;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_CONSTRAINT__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE__CONSTRAINT = DW_EVOLUTION_OPERATION_CONSTRAINT__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Constraint Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Constraint Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextImpl <em>Dw Evolution Operation Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationContext()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT = 28;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT__CONTEXT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextCreateImpl <em>Dw Evolution Operation Context Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationContextCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_CREATE = 29;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_CONTEXT__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_CREATE__CONTEXT = DW_EVOLUTION_OPERATION_CONTEXT__CONTEXT;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Context Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Context Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextDeleteImpl <em>Dw Evolution Operation Context Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationContextDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_DELETE = 30;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_CONTEXT__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_DELETE__CONTEXT = DW_EVOLUTION_OPERATION_CONTEXT__CONTEXT;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Context Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Context Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_CONTEXT_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaImpl <em>Dw Evolution Operation Validity Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationValidityFormula()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA = 31;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__EVO_STEP = DW_EVOLUTION_OPERATION__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Validity Formula</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Validity Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_FEATURE_COUNT = DW_EVOLUTION_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Validity Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_OPERATION_COUNT = DW_EVOLUTION_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaCreateImpl <em>Dw Evolution Operation Validity Formula Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaCreateImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationValidityFormulaCreate()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE = 32;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE__EVO_STEP = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Validity Formula</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE__VALIDITY_FORMULA = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Validity Formula Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Validity Formula Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaDeleteImpl <em>Dw Evolution Operation Validity Formula Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaDeleteImpl
	 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationValidityFormulaDelete()
	 * @generated
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE = 33;

	/**
	 * The feature id for the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE__EVO_STEP = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__EVO_STEP;

	/**
	 * The feature id for the '<em><b>Validity Formula</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE__VALIDITY_FORMULA = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA;

	/**
	 * The number of structural features of the '<em>Dw Evolution Operation Validity Formula Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE_FEATURE_COUNT = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dw Evolution Operation Validity Formula Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE_OPERATION_COUNT = DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation <em>Dw Evolution Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation
	 * @generated
	 */
	EClass getDwEvolutionOperation();

	/**
	 * Returns the meta object for the attribute '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation#getEvoStep <em>Evo Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evo Step</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation#getEvoStep()
	 * @see #getDwEvolutionOperation()
	 * @generated
	 */
	EAttribute getDwEvolutionOperation_EvoStep();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature <em>Dw Evolution Operation Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature
	 * @generated
	 */
	EClass getDwEvolutionOperationFeature();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature#getFeature()
	 * @see #getDwEvolutionOperationFeature()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeature_Feature();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate <em>Dw Evolution Operation Feature Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureDelete <em>Dw Evolution Operation Feature Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename <em>Dw Evolution Operation Feature Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Rename</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureRename();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getOldName <em>Old Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Name</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getOldName()
	 * @see #getDwEvolutionOperationFeatureRename()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureRename_OldName();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getNewName <em>New Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Name</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getNewName()
	 * @see #getDwEvolutionOperationFeatureRename()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureRename_NewName();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType <em>Dw Evolution Operation Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Type</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureType();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getOldType <em>Old Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Type</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getOldType()
	 * @see #getDwEvolutionOperationFeatureType()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureType_OldType();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getNewType <em>New Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Type</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getNewType()
	 * @see #getDwEvolutionOperationFeatureType()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureType_NewType();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup <em>Dw Evolution Operation Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Group</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureGroup();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getOldGroup <em>Old Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Group</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getOldGroup()
	 * @see #getDwEvolutionOperationFeatureGroup()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureGroup_OldGroup();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getNewGroup <em>New Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Group</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getNewGroup()
	 * @see #getDwEvolutionOperationFeatureGroup()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureGroup_NewGroup();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion <em>Dw Evolution Operation Feature Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Version</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureVersion();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Version</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion#getVersion()
	 * @see #getDwEvolutionOperationFeatureVersion()
	 * @generated
	 */
	EReference getDwEvolutionOperationFeatureVersion_Version();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionCreate <em>Dw Evolution Operation Feature Version Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Version Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureVersionCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionDelete <em>Dw Evolution Operation Feature Version Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Feature Version Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationFeatureVersionDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup <em>Dw Evolution Operation Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Group</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup
	 * @generated
	 */
	EClass getDwEvolutionOperationGroup();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Group</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup#getGroup()
	 * @see #getDwEvolutionOperationGroup()
	 * @generated
	 */
	EReference getDwEvolutionOperationGroup_Group();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType <em>Dw Evolution Operation Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Group Type</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType
	 * @generated
	 */
	EClass getDwEvolutionOperationGroupType();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getOldType <em>Old Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Type</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getOldType()
	 * @see #getDwEvolutionOperationGroupType()
	 * @generated
	 */
	EReference getDwEvolutionOperationGroupType_OldType();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getNewType <em>New Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Type</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getNewType()
	 * @see #getDwEvolutionOperationGroupType()
	 * @generated
	 */
	EReference getDwEvolutionOperationGroupType_NewType();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures <em>Dw Evolution Operation Group Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Group Features</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures
	 * @generated
	 */
	EClass getDwEvolutionOperationGroupFeatures();

	/**
	 * Returns the meta object for the reference list '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures#getAffectedFeatures <em>Affected Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affected Features</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures#getAffectedFeatures()
	 * @see #getDwEvolutionOperationGroupFeatures()
	 * @generated
	 */
	EReference getDwEvolutionOperationGroupFeatures_AffectedFeatures();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesAdded <em>Dw Evolution Operation Group Features Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Group Features Added</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesAdded
	 * @generated
	 */
	EClass getDwEvolutionOperationGroupFeaturesAdded();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesRemoved <em>Dw Evolution Operation Group Features Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Group Features Removed</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesRemoved
	 * @generated
	 */
	EClass getDwEvolutionOperationGroupFeaturesRemoved();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute <em>Dw Evolution Operation Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Attribute</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute
	 * @generated
	 */
	EClass getDwEvolutionOperationAttribute();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute#getAttribute()
	 * @see #getDwEvolutionOperationAttribute()
	 * @generated
	 */
	EReference getDwEvolutionOperationAttribute_Attribute();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeCreate <em>Dw Evolution Operation Attribute Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Attribute Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationAttributeCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeDelete <em>Dw Evolution Operation Attribute Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Attribute Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationAttributeDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename <em>Dw Evolution Operation Attribute Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Attribute Rename</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename
	 * @generated
	 */
	EClass getDwEvolutionOperationAttributeRename();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename#getOldName <em>Old Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Name</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename#getOldName()
	 * @see #getDwEvolutionOperationAttributeRename()
	 * @generated
	 */
	EReference getDwEvolutionOperationAttributeRename_OldName();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename#getNewName <em>New Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Name</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename#getNewName()
	 * @see #getDwEvolutionOperationAttributeRename()
	 * @generated
	 */
	EReference getDwEvolutionOperationAttributeRename_NewName();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum <em>Dw Evolution Operation Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Enum</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum
	 * @generated
	 */
	EClass getDwEvolutionOperationEnum();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum#getEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum#getEnum()
	 * @see #getDwEvolutionOperationEnum()
	 * @generated
	 */
	EReference getDwEvolutionOperationEnum_Enum();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumCreate <em>Dw Evolution Operation Enum Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Enum Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationEnumCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumDelete <em>Dw Evolution Operation Enum Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Enum Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationEnumDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral <em>Dw Evolution Operation Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Enum Literal</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral
	 * @generated
	 */
	EClass getDwEvolutionOperationEnumLiteral();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral#getLiteral()
	 * @see #getDwEvolutionOperationEnumLiteral()
	 * @generated
	 */
	EReference getDwEvolutionOperationEnumLiteral_Literal();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate <em>Dw Evolution Operation Enum Literal Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Enum Literal Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationEnumLiteralCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralDelete <em>Dw Evolution Operation Enum Literal Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Enum Literal Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationEnumLiteralDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint <em>Dw Evolution Operation Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Constraint</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint
	 * @generated
	 */
	EClass getDwEvolutionOperationConstraint();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint#getConstraint()
	 * @see #getDwEvolutionOperationConstraint()
	 * @generated
	 */
	EReference getDwEvolutionOperationConstraint_Constraint();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate <em>Dw Evolution Operation Constraint Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Constraint Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationConstraintCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintDelete <em>Dw Evolution Operation Constraint Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Constraint Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationConstraintDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext <em>Dw Evolution Operation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Context</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext
	 * @generated
	 */
	EClass getDwEvolutionOperationContext();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext#getContext()
	 * @see #getDwEvolutionOperationContext()
	 * @generated
	 */
	EReference getDwEvolutionOperationContext_Context();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextCreate <em>Dw Evolution Operation Context Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Context Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationContextCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextDelete <em>Dw Evolution Operation Context Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Context Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationContextDelete();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula <em>Dw Evolution Operation Validity Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Validity Formula</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula
	 * @generated
	 */
	EClass getDwEvolutionOperationValidityFormula();

	/**
	 * Returns the meta object for the reference '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula#getValidityFormula <em>Validity Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Validity Formula</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula#getValidityFormula()
	 * @see #getDwEvolutionOperationValidityFormula()
	 * @generated
	 */
	EReference getDwEvolutionOperationValidityFormula_ValidityFormula();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate <em>Dw Evolution Operation Validity Formula Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Validity Formula Create</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate
	 * @generated
	 */
	EClass getDwEvolutionOperationValidityFormulaCreate();

	/**
	 * Returns the meta object for class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaDelete <em>Dw Evolution Operation Validity Formula Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dw Evolution Operation Validity Formula Delete</em>'.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaDelete
	 * @generated
	 */
	EClass getDwEvolutionOperationValidityFormulaDelete();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EvolutionoperationFactory getEvolutionoperationFactory();

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
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationImpl <em>Dw Evolution Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperation()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION = eINSTANCE.getDwEvolutionOperation();

		/**
		 * The meta object literal for the '<em><b>Evo Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DW_EVOLUTION_OPERATION__EVO_STEP = eINSTANCE.getDwEvolutionOperation_EvoStep();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureImpl <em>Dw Evolution Operation Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeature()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE = eINSTANCE.getDwEvolutionOperationFeature();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE__FEATURE = eINSTANCE.getDwEvolutionOperationFeature_Feature();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureCreateImpl <em>Dw Evolution Operation Feature Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_CREATE = eINSTANCE.getDwEvolutionOperationFeatureCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureDeleteImpl <em>Dw Evolution Operation Feature Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_DELETE = eINSTANCE.getDwEvolutionOperationFeatureDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureRenameImpl <em>Dw Evolution Operation Feature Rename</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureRenameImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureRename()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_RENAME = eINSTANCE.getDwEvolutionOperationFeatureRename();

		/**
		 * The meta object literal for the '<em><b>Old Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_RENAME__OLD_NAME = eINSTANCE.getDwEvolutionOperationFeatureRename_OldName();

		/**
		 * The meta object literal for the '<em><b>New Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_RENAME__NEW_NAME = eINSTANCE.getDwEvolutionOperationFeatureRename_NewName();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureTypeImpl <em>Dw Evolution Operation Feature Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureTypeImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureType()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_TYPE = eINSTANCE.getDwEvolutionOperationFeatureType();

		/**
		 * The meta object literal for the '<em><b>Old Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE = eINSTANCE.getDwEvolutionOperationFeatureType_OldType();

		/**
		 * The meta object literal for the '<em><b>New Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE = eINSTANCE.getDwEvolutionOperationFeatureType_NewType();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureGroupImpl <em>Dw Evolution Operation Feature Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureGroupImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureGroup()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_GROUP = eINSTANCE.getDwEvolutionOperationFeatureGroup();

		/**
		 * The meta object literal for the '<em><b>Old Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP = eINSTANCE.getDwEvolutionOperationFeatureGroup_OldGroup();

		/**
		 * The meta object literal for the '<em><b>New Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP = eINSTANCE.getDwEvolutionOperationFeatureGroup_NewGroup();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionImpl <em>Dw Evolution Operation Feature Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureVersion()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_VERSION = eINSTANCE.getDwEvolutionOperationFeatureVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_FEATURE_VERSION__VERSION = eINSTANCE.getDwEvolutionOperationFeatureVersion_Version();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionCreateImpl <em>Dw Evolution Operation Feature Version Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureVersionCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE = eINSTANCE.getDwEvolutionOperationFeatureVersionCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionDeleteImpl <em>Dw Evolution Operation Feature Version Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationFeatureVersionDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationFeatureVersionDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE = eINSTANCE.getDwEvolutionOperationFeatureVersionDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupImpl <em>Dw Evolution Operation Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroup()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_GROUP = eINSTANCE.getDwEvolutionOperationGroup();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_GROUP__GROUP = eINSTANCE.getDwEvolutionOperationGroup_Group();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupTypeImpl <em>Dw Evolution Operation Group Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupTypeImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupType()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_GROUP_TYPE = eINSTANCE.getDwEvolutionOperationGroupType();

		/**
		 * The meta object literal for the '<em><b>Old Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_GROUP_TYPE__OLD_TYPE = eINSTANCE.getDwEvolutionOperationGroupType_OldType();

		/**
		 * The meta object literal for the '<em><b>New Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_GROUP_TYPE__NEW_TYPE = eINSTANCE.getDwEvolutionOperationGroupType_NewType();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesImpl <em>Dw Evolution Operation Group Features</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupFeatures()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_GROUP_FEATURES = eINSTANCE.getDwEvolutionOperationGroupFeatures();

		/**
		 * The meta object literal for the '<em><b>Affected Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES = eINSTANCE.getDwEvolutionOperationGroupFeatures_AffectedFeatures();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesAddedImpl <em>Dw Evolution Operation Group Features Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesAddedImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupFeaturesAdded()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED = eINSTANCE.getDwEvolutionOperationGroupFeaturesAdded();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesRemovedImpl <em>Dw Evolution Operation Group Features Removed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesRemovedImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationGroupFeaturesRemoved()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED = eINSTANCE.getDwEvolutionOperationGroupFeaturesRemoved();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeImpl <em>Dw Evolution Operation Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttribute()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ATTRIBUTE = eINSTANCE.getDwEvolutionOperationAttribute();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getDwEvolutionOperationAttribute_Attribute();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeCreateImpl <em>Dw Evolution Operation Attribute Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttributeCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE = eINSTANCE.getDwEvolutionOperationAttributeCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeDeleteImpl <em>Dw Evolution Operation Attribute Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttributeDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE = eINSTANCE.getDwEvolutionOperationAttributeDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeRenameImpl <em>Dw Evolution Operation Attribute Rename</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationAttributeRenameImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationAttributeRename()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME = eINSTANCE.getDwEvolutionOperationAttributeRename();

		/**
		 * The meta object literal for the '<em><b>Old Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME = eINSTANCE.getDwEvolutionOperationAttributeRename_OldName();

		/**
		 * The meta object literal for the '<em><b>New Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME = eINSTANCE.getDwEvolutionOperationAttributeRename_NewName();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumImpl <em>Dw Evolution Operation Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnum()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ENUM = eINSTANCE.getDwEvolutionOperationEnum();

		/**
		 * The meta object literal for the '<em><b>Enum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_ENUM__ENUM = eINSTANCE.getDwEvolutionOperationEnum_Enum();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumCreateImpl <em>Dw Evolution Operation Enum Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ENUM_CREATE = eINSTANCE.getDwEvolutionOperationEnumCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumDeleteImpl <em>Dw Evolution Operation Enum Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ENUM_DELETE = eINSTANCE.getDwEvolutionOperationEnumDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralImpl <em>Dw Evolution Operation Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumLiteral()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ENUM_LITERAL = eINSTANCE.getDwEvolutionOperationEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_ENUM_LITERAL__LITERAL = eINSTANCE.getDwEvolutionOperationEnumLiteral_Literal();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralCreateImpl <em>Dw Evolution Operation Enum Literal Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumLiteralCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE = eINSTANCE.getDwEvolutionOperationEnumLiteralCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralDeleteImpl <em>Dw Evolution Operation Enum Literal Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationEnumLiteralDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationEnumLiteralDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE = eINSTANCE.getDwEvolutionOperationEnumLiteralDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintImpl <em>Dw Evolution Operation Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationConstraint()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_CONSTRAINT = eINSTANCE.getDwEvolutionOperationConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_CONSTRAINT__CONSTRAINT = eINSTANCE.getDwEvolutionOperationConstraint_Constraint();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintCreateImpl <em>Dw Evolution Operation Constraint Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationConstraintCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE = eINSTANCE.getDwEvolutionOperationConstraintCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintDeleteImpl <em>Dw Evolution Operation Constraint Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationConstraintDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationConstraintDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE = eINSTANCE.getDwEvolutionOperationConstraintDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextImpl <em>Dw Evolution Operation Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationContext()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_CONTEXT = eINSTANCE.getDwEvolutionOperationContext();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_CONTEXT__CONTEXT = eINSTANCE.getDwEvolutionOperationContext_Context();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextCreateImpl <em>Dw Evolution Operation Context Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationContextCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_CONTEXT_CREATE = eINSTANCE.getDwEvolutionOperationContextCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextDeleteImpl <em>Dw Evolution Operation Context Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationContextDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationContextDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_CONTEXT_DELETE = eINSTANCE.getDwEvolutionOperationContextDelete();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaImpl <em>Dw Evolution Operation Validity Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationValidityFormula()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_VALIDITY_FORMULA = eINSTANCE.getDwEvolutionOperationValidityFormula();

		/**
		 * The meta object literal for the '<em><b>Validity Formula</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA = eINSTANCE.getDwEvolutionOperationValidityFormula_ValidityFormula();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaCreateImpl <em>Dw Evolution Operation Validity Formula Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaCreateImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationValidityFormulaCreate()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE = eINSTANCE.getDwEvolutionOperationValidityFormulaCreate();

		/**
		 * The meta object literal for the '{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaDeleteImpl <em>Dw Evolution Operation Validity Formula Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationValidityFormulaDeleteImpl
		 * @see de.darwinspl.feature.evolution.evolutionoperation.impl.EvolutionoperationPackageImpl#getDwEvolutionOperationValidityFormulaDelete()
		 * @generated
		 */
		EClass DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE = eINSTANCE.getDwEvolutionOperationValidityFormulaDelete();

	}

} //EvolutionoperationPackage
