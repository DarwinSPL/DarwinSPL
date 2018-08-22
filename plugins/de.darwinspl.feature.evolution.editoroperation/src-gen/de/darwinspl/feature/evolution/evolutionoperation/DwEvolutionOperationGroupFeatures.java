/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.feature.HyFeature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Group Features</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures#getAffectedFeatures <em>Affected Features</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationGroupFeatures()
 * @model
 * @generated
 */
public interface DwEvolutionOperationGroupFeatures extends DwEvolutionOperationGroup {
	/**
	 * Returns the value of the '<em><b>Affected Features</b></em>' reference list.
	 * The list contents are of type {@link eu.hyvar.feature.HyFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Features</em>' reference list.
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationGroupFeatures_AffectedFeatures()
	 * @model
	 * @generated
	 */
	EList<HyFeature> getAffectedFeatures();

} // DwEvolutionOperationGroupFeatures
