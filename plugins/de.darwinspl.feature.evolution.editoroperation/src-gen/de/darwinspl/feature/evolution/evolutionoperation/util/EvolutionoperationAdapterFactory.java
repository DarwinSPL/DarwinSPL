/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.util;

import de.darwinspl.feature.evolution.evolutionoperation.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage
 * @generated
 */
public class EvolutionoperationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EvolutionoperationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionoperationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EvolutionoperationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvolutionoperationSwitch<Adapter> modelSwitch =
		new EvolutionoperationSwitch<Adapter>() {
			@Override
			public Adapter caseDwEvolutionOperation(DwEvolutionOperation object) {
				return createDwEvolutionOperationAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeature(DwEvolutionOperationFeature object) {
				return createDwEvolutionOperationFeatureAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureCreate(DwEvolutionOperationFeatureCreate object) {
				return createDwEvolutionOperationFeatureCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureDelete(DwEvolutionOperationFeatureDelete object) {
				return createDwEvolutionOperationFeatureDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureRename(DwEvolutionOperationFeatureRename object) {
				return createDwEvolutionOperationFeatureRenameAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureType(DwEvolutionOperationFeatureType object) {
				return createDwEvolutionOperationFeatureTypeAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureGroup(DwEvolutionOperationFeatureGroup object) {
				return createDwEvolutionOperationFeatureGroupAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureVersion(DwEvolutionOperationFeatureVersion object) {
				return createDwEvolutionOperationFeatureVersionAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureVersionCreate(DwEvolutionOperationFeatureVersionCreate object) {
				return createDwEvolutionOperationFeatureVersionCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationFeatureVersionDelete(DwEvolutionOperationFeatureVersionDelete object) {
				return createDwEvolutionOperationFeatureVersionDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationGroup(DwEvolutionOperationGroup object) {
				return createDwEvolutionOperationGroupAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationGroupType(DwEvolutionOperationGroupType object) {
				return createDwEvolutionOperationGroupTypeAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationGroupFeatures(DwEvolutionOperationGroupFeatures object) {
				return createDwEvolutionOperationGroupFeaturesAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationGroupFeaturesAdded(DwEvolutionOperationGroupFeaturesAdded object) {
				return createDwEvolutionOperationGroupFeaturesAddedAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationGroupFeaturesRemoved(DwEvolutionOperationGroupFeaturesRemoved object) {
				return createDwEvolutionOperationGroupFeaturesRemovedAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationAttribute(DwEvolutionOperationAttribute object) {
				return createDwEvolutionOperationAttributeAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationAttributeCreate(DwEvolutionOperationAttributeCreate object) {
				return createDwEvolutionOperationAttributeCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationAttributeDelete(DwEvolutionOperationAttributeDelete object) {
				return createDwEvolutionOperationAttributeDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationAttributeRename(DwEvolutionOperationAttributeRename object) {
				return createDwEvolutionOperationAttributeRenameAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationEnum(DwEvolutionOperationEnum object) {
				return createDwEvolutionOperationEnumAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationEnumCreate(DwEvolutionOperationEnumCreate object) {
				return createDwEvolutionOperationEnumCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationEnumDelete(DwEvolutionOperationEnumDelete object) {
				return createDwEvolutionOperationEnumDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationEnumLiteral(DwEvolutionOperationEnumLiteral object) {
				return createDwEvolutionOperationEnumLiteralAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationEnumLiteralCreate(DwEvolutionOperationEnumLiteralCreate object) {
				return createDwEvolutionOperationEnumLiteralCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationEnumLiteralDelete(DwEvolutionOperationEnumLiteralDelete object) {
				return createDwEvolutionOperationEnumLiteralDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationConstraint(DwEvolutionOperationConstraint object) {
				return createDwEvolutionOperationConstraintAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationConstraintCreate(DwEvolutionOperationConstraintCreate object) {
				return createDwEvolutionOperationConstraintCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationConstraintDelete(DwEvolutionOperationConstraintDelete object) {
				return createDwEvolutionOperationConstraintDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationContext(DwEvolutionOperationContext object) {
				return createDwEvolutionOperationContextAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationContextCreate(DwEvolutionOperationContextCreate object) {
				return createDwEvolutionOperationContextCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationContextDelete(DwEvolutionOperationContextDelete object) {
				return createDwEvolutionOperationContextDeleteAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationValidityFormula(DwEvolutionOperationValidityFormula object) {
				return createDwEvolutionOperationValidityFormulaAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationValidityFormulaCreate(DwEvolutionOperationValidityFormulaCreate object) {
				return createDwEvolutionOperationValidityFormulaCreateAdapter();
			}
			@Override
			public Adapter caseDwEvolutionOperationValidityFormulaDelete(DwEvolutionOperationValidityFormulaDelete object) {
				return createDwEvolutionOperationValidityFormulaDeleteAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation <em>Dw Evolution Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation
	 * @generated
	 */
	public Adapter createDwEvolutionOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature <em>Dw Evolution Operation Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate <em>Dw Evolution Operation Feature Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureDelete <em>Dw Evolution Operation Feature Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename <em>Dw Evolution Operation Feature Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureRenameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType <em>Dw Evolution Operation Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup <em>Dw Evolution Operation Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion <em>Dw Evolution Operation Feature Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionCreate <em>Dw Evolution Operation Feature Version Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureVersionCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionDelete <em>Dw Evolution Operation Feature Version Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationFeatureVersionDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup <em>Dw Evolution Operation Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup
	 * @generated
	 */
	public Adapter createDwEvolutionOperationGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType <em>Dw Evolution Operation Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType
	 * @generated
	 */
	public Adapter createDwEvolutionOperationGroupTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures <em>Dw Evolution Operation Group Features</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures
	 * @generated
	 */
	public Adapter createDwEvolutionOperationGroupFeaturesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesAdded <em>Dw Evolution Operation Group Features Added</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesAdded
	 * @generated
	 */
	public Adapter createDwEvolutionOperationGroupFeaturesAddedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesRemoved <em>Dw Evolution Operation Group Features Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesRemoved
	 * @generated
	 */
	public Adapter createDwEvolutionOperationGroupFeaturesRemovedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute <em>Dw Evolution Operation Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute
	 * @generated
	 */
	public Adapter createDwEvolutionOperationAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeCreate <em>Dw Evolution Operation Attribute Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationAttributeCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeDelete <em>Dw Evolution Operation Attribute Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationAttributeDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename <em>Dw Evolution Operation Attribute Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename
	 * @generated
	 */
	public Adapter createDwEvolutionOperationAttributeRenameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum <em>Dw Evolution Operation Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum
	 * @generated
	 */
	public Adapter createDwEvolutionOperationEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumCreate <em>Dw Evolution Operation Enum Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationEnumCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumDelete <em>Dw Evolution Operation Enum Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationEnumDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral <em>Dw Evolution Operation Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral
	 * @generated
	 */
	public Adapter createDwEvolutionOperationEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate <em>Dw Evolution Operation Enum Literal Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationEnumLiteralCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralDelete <em>Dw Evolution Operation Enum Literal Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationEnumLiteralDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint <em>Dw Evolution Operation Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint
	 * @generated
	 */
	public Adapter createDwEvolutionOperationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate <em>Dw Evolution Operation Constraint Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationConstraintCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintDelete <em>Dw Evolution Operation Constraint Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationConstraintDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext <em>Dw Evolution Operation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext
	 * @generated
	 */
	public Adapter createDwEvolutionOperationContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextCreate <em>Dw Evolution Operation Context Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationContextCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextDelete <em>Dw Evolution Operation Context Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationContextDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula <em>Dw Evolution Operation Validity Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula
	 * @generated
	 */
	public Adapter createDwEvolutionOperationValidityFormulaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate <em>Dw Evolution Operation Validity Formula Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate
	 * @generated
	 */
	public Adapter createDwEvolutionOperationValidityFormulaCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaDelete <em>Dw Evolution Operation Validity Formula Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaDelete
	 * @generated
	 */
	public Adapter createDwEvolutionOperationValidityFormulaDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EvolutionoperationAdapterFactory
