/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.feature.HyFeature;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dw Evolution Operation Group Features</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.impl.DwEvolutionOperationGroupFeaturesImpl#getAffectedFeatures <em>Affected Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DwEvolutionOperationGroupFeaturesImpl extends DwEvolutionOperationGroupImpl implements DwEvolutionOperationGroupFeatures {
	/**
	 * The cached value of the '{@link #getAffectedFeatures() <em>Affected Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<HyFeature> affectedFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwEvolutionOperationGroupFeaturesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvolutionoperationPackage.Literals.DW_EVOLUTION_OPERATION_GROUP_FEATURES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HyFeature> getAffectedFeatures() {
		if (affectedFeatures == null) {
			affectedFeatures = new EObjectResolvingEList<HyFeature>(HyFeature.class, this, EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES);
		}
		return affectedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES:
				return getAffectedFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES:
				getAffectedFeatures().clear();
				getAffectedFeatures().addAll((Collection<? extends HyFeature>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES:
				getAffectedFeatures().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EvolutionoperationPackage.DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES:
				return affectedFeatures != null && !affectedFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DwEvolutionOperationGroupFeaturesImpl
