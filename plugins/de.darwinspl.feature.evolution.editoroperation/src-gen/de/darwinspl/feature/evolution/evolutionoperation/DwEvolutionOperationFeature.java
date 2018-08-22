/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.feature.HyFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeature()
 * @model abstract="true"
 * @generated
 */
public interface DwEvolutionOperationFeature extends DwEvolutionOperation {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(HyFeature)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeature_Feature()
	 * @model required="true"
	 * @generated
	 */
	HyFeature getFeature();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(HyFeature value);

} // DwEvolutionOperationFeature
