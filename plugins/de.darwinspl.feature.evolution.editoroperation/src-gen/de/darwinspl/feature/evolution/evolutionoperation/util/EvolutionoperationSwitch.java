/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.util;

import de.darwinspl.feature.evolution.evolutionoperation.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage
 * @generated
 */
public class EvolutionoperationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EvolutionoperationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionoperationSwitch() {
		if (modelPackage == null) {
			modelPackage = EvolutionoperationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION: {
				DwEvolutionOperation dwEvolutionOperation = (DwEvolutionOperation)theEObject;
				T result = caseDwEvolutionOperation(dwEvolutionOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE: {
				DwEvolutionOperationFeature dwEvolutionOperationFeature = (DwEvolutionOperationFeature)theEObject;
				T result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeature);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_CREATE: {
				DwEvolutionOperationFeatureCreate dwEvolutionOperationFeatureCreate = (DwEvolutionOperationFeatureCreate)theEObject;
				T result = caseDwEvolutionOperationFeatureCreate(dwEvolutionOperationFeatureCreate);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_DELETE: {
				DwEvolutionOperationFeatureDelete dwEvolutionOperationFeatureDelete = (DwEvolutionOperationFeatureDelete)theEObject;
				T result = caseDwEvolutionOperationFeatureDelete(dwEvolutionOperationFeatureDelete);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_RENAME: {
				DwEvolutionOperationFeatureRename dwEvolutionOperationFeatureRename = (DwEvolutionOperationFeatureRename)theEObject;
				T result = caseDwEvolutionOperationFeatureRename(dwEvolutionOperationFeatureRename);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureRename);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureRename);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_TYPE: {
				DwEvolutionOperationFeatureType dwEvolutionOperationFeatureType = (DwEvolutionOperationFeatureType)theEObject;
				T result = caseDwEvolutionOperationFeatureType(dwEvolutionOperationFeatureType);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureType);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_GROUP: {
				DwEvolutionOperationFeatureGroup dwEvolutionOperationFeatureGroup = (DwEvolutionOperationFeatureGroup)theEObject;
				T result = caseDwEvolutionOperationFeatureGroup(dwEvolutionOperationFeatureGroup);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureGroup);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_VERSION: {
				DwEvolutionOperationFeatureVersion dwEvolutionOperationFeatureVersion = (DwEvolutionOperationFeatureVersion)theEObject;
				T result = caseDwEvolutionOperationFeatureVersion(dwEvolutionOperationFeatureVersion);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureVersion);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureVersion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE: {
				DwEvolutionOperationFeatureVersionCreate dwEvolutionOperationFeatureVersionCreate = (DwEvolutionOperationFeatureVersionCreate)theEObject;
				T result = caseDwEvolutionOperationFeatureVersionCreate(dwEvolutionOperationFeatureVersionCreate);
				if (result == null) result = caseDwEvolutionOperationFeatureVersion(dwEvolutionOperationFeatureVersionCreate);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureVersionCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureVersionCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE: {
				DwEvolutionOperationFeatureVersionDelete dwEvolutionOperationFeatureVersionDelete = (DwEvolutionOperationFeatureVersionDelete)theEObject;
				T result = caseDwEvolutionOperationFeatureVersionDelete(dwEvolutionOperationFeatureVersionDelete);
				if (result == null) result = caseDwEvolutionOperationFeatureVersion(dwEvolutionOperationFeatureVersionDelete);
				if (result == null) result = caseDwEvolutionOperationFeature(dwEvolutionOperationFeatureVersionDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationFeatureVersionDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP: {
				DwEvolutionOperationGroup dwEvolutionOperationGroup = (DwEvolutionOperationGroup)theEObject;
				T result = caseDwEvolutionOperationGroup(dwEvolutionOperationGroup);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_TYPE: {
				DwEvolutionOperationGroupType dwEvolutionOperationGroupType = (DwEvolutionOperationGroupType)theEObject;
				T result = caseDwEvolutionOperationGroupType(dwEvolutionOperationGroupType);
				if (result == null) result = caseDwEvolutionOperationGroup(dwEvolutionOperationGroupType);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationGroupType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES: {
				DwEvolutionOperationGroupFeatures dwEvolutionOperationGroupFeatures = (DwEvolutionOperationGroupFeatures)theEObject;
				T result = caseDwEvolutionOperationGroupFeatures(dwEvolutionOperationGroupFeatures);
				if (result == null) result = caseDwEvolutionOperationGroup(dwEvolutionOperationGroupFeatures);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationGroupFeatures);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED: {
				DwEvolutionOperationGroupFeaturesAdded dwEvolutionOperationGroupFeaturesAdded = (DwEvolutionOperationGroupFeaturesAdded)theEObject;
				T result = caseDwEvolutionOperationGroupFeaturesAdded(dwEvolutionOperationGroupFeaturesAdded);
				if (result == null) result = caseDwEvolutionOperationGroupFeatures(dwEvolutionOperationGroupFeaturesAdded);
				if (result == null) result = caseDwEvolutionOperationGroup(dwEvolutionOperationGroupFeaturesAdded);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationGroupFeaturesAdded);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED: {
				DwEvolutionOperationGroupFeaturesRemoved dwEvolutionOperationGroupFeaturesRemoved = (DwEvolutionOperationGroupFeaturesRemoved)theEObject;
				T result = caseDwEvolutionOperationGroupFeaturesRemoved(dwEvolutionOperationGroupFeaturesRemoved);
				if (result == null) result = caseDwEvolutionOperationGroupFeatures(dwEvolutionOperationGroupFeaturesRemoved);
				if (result == null) result = caseDwEvolutionOperationGroup(dwEvolutionOperationGroupFeaturesRemoved);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationGroupFeaturesRemoved);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE: {
				DwEvolutionOperationAttribute dwEvolutionOperationAttribute = (DwEvolutionOperationAttribute)theEObject;
				T result = caseDwEvolutionOperationAttribute(dwEvolutionOperationAttribute);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE: {
				DwEvolutionOperationAttributeCreate dwEvolutionOperationAttributeCreate = (DwEvolutionOperationAttributeCreate)theEObject;
				T result = caseDwEvolutionOperationAttributeCreate(dwEvolutionOperationAttributeCreate);
				if (result == null) result = caseDwEvolutionOperationAttribute(dwEvolutionOperationAttributeCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationAttributeCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE: {
				DwEvolutionOperationAttributeDelete dwEvolutionOperationAttributeDelete = (DwEvolutionOperationAttributeDelete)theEObject;
				T result = caseDwEvolutionOperationAttributeDelete(dwEvolutionOperationAttributeDelete);
				if (result == null) result = caseDwEvolutionOperationAttribute(dwEvolutionOperationAttributeDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationAttributeDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME: {
				DwEvolutionOperationAttributeRename dwEvolutionOperationAttributeRename = (DwEvolutionOperationAttributeRename)theEObject;
				T result = caseDwEvolutionOperationAttributeRename(dwEvolutionOperationAttributeRename);
				if (result == null) result = caseDwEvolutionOperationAttribute(dwEvolutionOperationAttributeRename);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationAttributeRename);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM: {
				DwEvolutionOperationEnum dwEvolutionOperationEnum = (DwEvolutionOperationEnum)theEObject;
				T result = caseDwEvolutionOperationEnum(dwEvolutionOperationEnum);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_CREATE: {
				DwEvolutionOperationEnumCreate dwEvolutionOperationEnumCreate = (DwEvolutionOperationEnumCreate)theEObject;
				T result = caseDwEvolutionOperationEnumCreate(dwEvolutionOperationEnumCreate);
				if (result == null) result = caseDwEvolutionOperationEnum(dwEvolutionOperationEnumCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationEnumCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_DELETE: {
				DwEvolutionOperationEnumDelete dwEvolutionOperationEnumDelete = (DwEvolutionOperationEnumDelete)theEObject;
				T result = caseDwEvolutionOperationEnumDelete(dwEvolutionOperationEnumDelete);
				if (result == null) result = caseDwEvolutionOperationEnum(dwEvolutionOperationEnumDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationEnumDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_LITERAL: {
				DwEvolutionOperationEnumLiteral dwEvolutionOperationEnumLiteral = (DwEvolutionOperationEnumLiteral)theEObject;
				T result = caseDwEvolutionOperationEnumLiteral(dwEvolutionOperationEnumLiteral);
				if (result == null) result = caseDwEvolutionOperationEnum(dwEvolutionOperationEnumLiteral);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE: {
				DwEvolutionOperationEnumLiteralCreate dwEvolutionOperationEnumLiteralCreate = (DwEvolutionOperationEnumLiteralCreate)theEObject;
				T result = caseDwEvolutionOperationEnumLiteralCreate(dwEvolutionOperationEnumLiteralCreate);
				if (result == null) result = caseDwEvolutionOperationEnumLiteral(dwEvolutionOperationEnumLiteralCreate);
				if (result == null) result = caseDwEvolutionOperationEnum(dwEvolutionOperationEnumLiteralCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationEnumLiteralCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE: {
				DwEvolutionOperationEnumLiteralDelete dwEvolutionOperationEnumLiteralDelete = (DwEvolutionOperationEnumLiteralDelete)theEObject;
				T result = caseDwEvolutionOperationEnumLiteralDelete(dwEvolutionOperationEnumLiteralDelete);
				if (result == null) result = caseDwEvolutionOperationEnumLiteral(dwEvolutionOperationEnumLiteralDelete);
				if (result == null) result = caseDwEvolutionOperationEnum(dwEvolutionOperationEnumLiteralDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationEnumLiteralDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONSTRAINT: {
				DwEvolutionOperationConstraint dwEvolutionOperationConstraint = (DwEvolutionOperationConstraint)theEObject;
				T result = caseDwEvolutionOperationConstraint(dwEvolutionOperationConstraint);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE: {
				DwEvolutionOperationConstraintCreate dwEvolutionOperationConstraintCreate = (DwEvolutionOperationConstraintCreate)theEObject;
				T result = caseDwEvolutionOperationConstraintCreate(dwEvolutionOperationConstraintCreate);
				if (result == null) result = caseDwEvolutionOperationConstraint(dwEvolutionOperationConstraintCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationConstraintCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE: {
				DwEvolutionOperationConstraintDelete dwEvolutionOperationConstraintDelete = (DwEvolutionOperationConstraintDelete)theEObject;
				T result = caseDwEvolutionOperationConstraintDelete(dwEvolutionOperationConstraintDelete);
				if (result == null) result = caseDwEvolutionOperationConstraint(dwEvolutionOperationConstraintDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationConstraintDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONTEXT: {
				DwEvolutionOperationContext dwEvolutionOperationContext = (DwEvolutionOperationContext)theEObject;
				T result = caseDwEvolutionOperationContext(dwEvolutionOperationContext);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONTEXT_CREATE: {
				DwEvolutionOperationContextCreate dwEvolutionOperationContextCreate = (DwEvolutionOperationContextCreate)theEObject;
				T result = caseDwEvolutionOperationContextCreate(dwEvolutionOperationContextCreate);
				if (result == null) result = caseDwEvolutionOperationContext(dwEvolutionOperationContextCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationContextCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_CONTEXT_DELETE: {
				DwEvolutionOperationContextDelete dwEvolutionOperationContextDelete = (DwEvolutionOperationContextDelete)theEObject;
				T result = caseDwEvolutionOperationContextDelete(dwEvolutionOperationContextDelete);
				if (result == null) result = caseDwEvolutionOperationContext(dwEvolutionOperationContextDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationContextDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA: {
				DwEvolutionOperationValidityFormula dwEvolutionOperationValidityFormula = (DwEvolutionOperationValidityFormula)theEObject;
				T result = caseDwEvolutionOperationValidityFormula(dwEvolutionOperationValidityFormula);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationValidityFormula);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE: {
				DwEvolutionOperationValidityFormulaCreate dwEvolutionOperationValidityFormulaCreate = (DwEvolutionOperationValidityFormulaCreate)theEObject;
				T result = caseDwEvolutionOperationValidityFormulaCreate(dwEvolutionOperationValidityFormulaCreate);
				if (result == null) result = caseDwEvolutionOperationValidityFormula(dwEvolutionOperationValidityFormulaCreate);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationValidityFormulaCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE: {
				DwEvolutionOperationValidityFormulaDelete dwEvolutionOperationValidityFormulaDelete = (DwEvolutionOperationValidityFormulaDelete)theEObject;
				T result = caseDwEvolutionOperationValidityFormulaDelete(dwEvolutionOperationValidityFormulaDelete);
				if (result == null) result = caseDwEvolutionOperationValidityFormula(dwEvolutionOperationValidityFormulaDelete);
				if (result == null) result = caseDwEvolutionOperation(dwEvolutionOperationValidityFormulaDelete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperation(DwEvolutionOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeature(DwEvolutionOperationFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureCreate(DwEvolutionOperationFeatureCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureDelete(DwEvolutionOperationFeatureDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Rename</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Rename</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureRename(DwEvolutionOperationFeatureRename object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureType(DwEvolutionOperationFeatureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureGroup(DwEvolutionOperationFeatureGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureVersion(DwEvolutionOperationFeatureVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Version Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Version Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureVersionCreate(DwEvolutionOperationFeatureVersionCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Version Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Feature Version Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationFeatureVersionDelete(DwEvolutionOperationFeatureVersionDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationGroup(DwEvolutionOperationGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationGroupType(DwEvolutionOperationGroupType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Features</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Features</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationGroupFeatures(DwEvolutionOperationGroupFeatures object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Features Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Features Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationGroupFeaturesAdded(DwEvolutionOperationGroupFeaturesAdded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Features Removed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Group Features Removed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationGroupFeaturesRemoved(DwEvolutionOperationGroupFeaturesRemoved object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationAttribute(DwEvolutionOperationAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationAttributeCreate(DwEvolutionOperationAttributeCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationAttributeDelete(DwEvolutionOperationAttributeDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute Rename</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Attribute Rename</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationAttributeRename(DwEvolutionOperationAttributeRename object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationEnum(DwEvolutionOperationEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationEnumCreate(DwEvolutionOperationEnumCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationEnumDelete(DwEvolutionOperationEnumDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationEnumLiteral(DwEvolutionOperationEnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Literal Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Literal Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationEnumLiteralCreate(DwEvolutionOperationEnumLiteralCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Literal Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Enum Literal Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationEnumLiteralDelete(DwEvolutionOperationEnumLiteralDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationConstraint(DwEvolutionOperationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Constraint Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Constraint Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationConstraintCreate(DwEvolutionOperationConstraintCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Constraint Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Constraint Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationConstraintDelete(DwEvolutionOperationConstraintDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationContext(DwEvolutionOperationContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Context Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Context Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationContextCreate(DwEvolutionOperationContextCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Context Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Context Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationContextDelete(DwEvolutionOperationContextDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Validity Formula</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Validity Formula</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationValidityFormula(DwEvolutionOperationValidityFormula object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Validity Formula Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Validity Formula Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationValidityFormulaCreate(DwEvolutionOperationValidityFormulaCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dw Evolution Operation Validity Formula Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dw Evolution Operation Validity Formula Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDwEvolutionOperationValidityFormulaDelete(DwEvolutionOperationValidityFormulaDelete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EvolutionoperationSwitch
