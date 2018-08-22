/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EvolutionoperationFactoryImpl extends EFactoryImpl implements EvolutionoperationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EvolutionoperationFactory init() {
		try {
			EvolutionoperationFactory theEvolutionoperationFactory = (EvolutionoperationFactory)EPackage.Registry.INSTANCE.getEFactory(EvolutionoperationPackage.eNS_URI);
			if (theEvolutionoperationFactory != null) {
				return theEvolutionoperationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EvolutionoperationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionoperationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_CREATE: return createDwEvolutionOperationFeatureCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_DELETE: return createDwEvolutionOperationFeatureDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_RENAME: return createDwEvolutionOperationFeatureRename();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE: return createDwEvolutionOperationFeatureType();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP: return createDwEvolutionOperationFeatureGroup();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE: return createDwEvolutionOperationFeatureVersionCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE: return createDwEvolutionOperationFeatureVersionDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP: return createDwEvolutionOperationGroup();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_TYPE: return createDwEvolutionOperationGroupType();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES: return createDwEvolutionOperationGroupFeatures();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED: return createDwEvolutionOperationGroupFeaturesAdded();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED: return createDwEvolutionOperationGroupFeaturesRemoved();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE: return createDwEvolutionOperationAttributeCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE: return createDwEvolutionOperationAttributeDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME: return createDwEvolutionOperationAttributeRename();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_CREATE: return createDwEvolutionOperationEnumCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_DELETE: return createDwEvolutionOperationEnumDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE: return createDwEvolutionOperationEnumLiteralCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE: return createDwEvolutionOperationEnumLiteralDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE: return createDwEvolutionOperationConstraintCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE: return createDwEvolutionOperationConstraintDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONTEXT_CREATE: return createDwEvolutionOperationContextCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONTEXT_DELETE: return createDwEvolutionOperationContextDelete();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE: return createDwEvolutionOperationValidityFormulaCreate();
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE: return createDwEvolutionOperationValidityFormulaDelete();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureCreate createDwEvolutionOperationFeatureCreate() {
		DwEvolutionOperationFeatureCreateImpl dwEvolutionOperationFeatureCreate = new DwEvolutionOperationFeatureCreateImpl();
		return dwEvolutionOperationFeatureCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureDelete createDwEvolutionOperationFeatureDelete() {
		DwEvolutionOperationFeatureDeleteImpl dwEvolutionOperationFeatureDelete = new DwEvolutionOperationFeatureDeleteImpl();
		return dwEvolutionOperationFeatureDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureRename createDwEvolutionOperationFeatureRename() {
		DwEvolutionOperationFeatureRenameImpl dwEvolutionOperationFeatureRename = new DwEvolutionOperationFeatureRenameImpl();
		return dwEvolutionOperationFeatureRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureType createDwEvolutionOperationFeatureType() {
		DwEvolutionOperationFeatureTypeImpl dwEvolutionOperationFeatureType = new DwEvolutionOperationFeatureTypeImpl();
		return dwEvolutionOperationFeatureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureGroup createDwEvolutionOperationFeatureGroup() {
		DwEvolutionOperationFeatureGroupImpl dwEvolutionOperationFeatureGroup = new DwEvolutionOperationFeatureGroupImpl();
		return dwEvolutionOperationFeatureGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureVersionCreate createDwEvolutionOperationFeatureVersionCreate() {
		DwEvolutionOperationFeatureVersionCreateImpl dwEvolutionOperationFeatureVersionCreate = new DwEvolutionOperationFeatureVersionCreateImpl();
		return dwEvolutionOperationFeatureVersionCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationFeatureVersionDelete createDwEvolutionOperationFeatureVersionDelete() {
		DwEvolutionOperationFeatureVersionDeleteImpl dwEvolutionOperationFeatureVersionDelete = new DwEvolutionOperationFeatureVersionDeleteImpl();
		return dwEvolutionOperationFeatureVersionDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationGroup createDwEvolutionOperationGroup() {
		DwEvolutionOperationGroupImpl dwEvolutionOperationGroup = new DwEvolutionOperationGroupImpl();
		return dwEvolutionOperationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationGroupType createDwEvolutionOperationGroupType() {
		DwEvolutionOperationGroupTypeImpl dwEvolutionOperationGroupType = new DwEvolutionOperationGroupTypeImpl();
		return dwEvolutionOperationGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationGroupFeatures createDwEvolutionOperationGroupFeatures() {
		DwEvolutionOperationGroupFeaturesImpl dwEvolutionOperationGroupFeatures = new DwEvolutionOperationGroupFeaturesImpl();
		return dwEvolutionOperationGroupFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationGroupFeaturesAdded createDwEvolutionOperationGroupFeaturesAdded() {
		DwEvolutionOperationGroupFeaturesAddedImpl dwEvolutionOperationGroupFeaturesAdded = new DwEvolutionOperationGroupFeaturesAddedImpl();
		return dwEvolutionOperationGroupFeaturesAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationGroupFeaturesRemoved createDwEvolutionOperationGroupFeaturesRemoved() {
		DwEvolutionOperationGroupFeaturesRemovedImpl dwEvolutionOperationGroupFeaturesRemoved = new DwEvolutionOperationGroupFeaturesRemovedImpl();
		return dwEvolutionOperationGroupFeaturesRemoved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationAttributeCreate createDwEvolutionOperationAttributeCreate() {
		DwEvolutionOperationAttributeCreateImpl dwEvolutionOperationAttributeCreate = new DwEvolutionOperationAttributeCreateImpl();
		return dwEvolutionOperationAttributeCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationAttributeDelete createDwEvolutionOperationAttributeDelete() {
		DwEvolutionOperationAttributeDeleteImpl dwEvolutionOperationAttributeDelete = new DwEvolutionOperationAttributeDeleteImpl();
		return dwEvolutionOperationAttributeDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationAttributeRename createDwEvolutionOperationAttributeRename() {
		DwEvolutionOperationAttributeRenameImpl dwEvolutionOperationAttributeRename = new DwEvolutionOperationAttributeRenameImpl();
		return dwEvolutionOperationAttributeRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationEnumCreate createDwEvolutionOperationEnumCreate() {
		DwEvolutionOperationEnumCreateImpl dwEvolutionOperationEnumCreate = new DwEvolutionOperationEnumCreateImpl();
		return dwEvolutionOperationEnumCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationEnumDelete createDwEvolutionOperationEnumDelete() {
		DwEvolutionOperationEnumDeleteImpl dwEvolutionOperationEnumDelete = new DwEvolutionOperationEnumDeleteImpl();
		return dwEvolutionOperationEnumDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationEnumLiteralCreate createDwEvolutionOperationEnumLiteralCreate() {
		DwEvolutionOperationEnumLiteralCreateImpl dwEvolutionOperationEnumLiteralCreate = new DwEvolutionOperationEnumLiteralCreateImpl();
		return dwEvolutionOperationEnumLiteralCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationEnumLiteralDelete createDwEvolutionOperationEnumLiteralDelete() {
		DwEvolutionOperationEnumLiteralDeleteImpl dwEvolutionOperationEnumLiteralDelete = new DwEvolutionOperationEnumLiteralDeleteImpl();
		return dwEvolutionOperationEnumLiteralDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationConstraintCreate createDwEvolutionOperationConstraintCreate() {
		DwEvolutionOperationConstraintCreateImpl dwEvolutionOperationConstraintCreate = new DwEvolutionOperationConstraintCreateImpl();
		return dwEvolutionOperationConstraintCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationConstraintDelete createDwEvolutionOperationConstraintDelete() {
		DwEvolutionOperationConstraintDeleteImpl dwEvolutionOperationConstraintDelete = new DwEvolutionOperationConstraintDeleteImpl();
		return dwEvolutionOperationConstraintDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationContextCreate createDwEvolutionOperationContextCreate() {
		DwEvolutionOperationContextCreateImpl dwEvolutionOperationContextCreate = new DwEvolutionOperationContextCreateImpl();
		return dwEvolutionOperationContextCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationContextDelete createDwEvolutionOperationContextDelete() {
		DwEvolutionOperationContextDeleteImpl dwEvolutionOperationContextDelete = new DwEvolutionOperationContextDeleteImpl();
		return dwEvolutionOperationContextDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationValidityFormulaCreate createDwEvolutionOperationValidityFormulaCreate() {
		DwEvolutionOperationValidityFormulaCreateImpl dwEvolutionOperationValidityFormulaCreate = new DwEvolutionOperationValidityFormulaCreateImpl();
		return dwEvolutionOperationValidityFormulaCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwEvolutionOperationValidityFormulaDelete createDwEvolutionOperationValidityFormulaDelete() {
		DwEvolutionOperationValidityFormulaDeleteImpl dwEvolutionOperationValidityFormulaDelete = new DwEvolutionOperationValidityFormulaDeleteImpl();
		return dwEvolutionOperationValidityFormulaDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionoperationPackage getEvolutionoperationPackage() {
		return (EvolutionoperationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EvolutionoperationPackage getPackage() {
		return EvolutionoperationPackage.eINSTANCE;
	}

} //EvolutionoperationFactoryImpl
