/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.context.contextValidity.HyValidityFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Validity Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula#getValidityFormula <em>Validity Formula</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationValidityFormula()
 * @model abstract="true"
 * @generated
 */
public interface DwEvolutionOperationValidityFormula extends DwEvolutionOperation {
	/**
	 * Returns the value of the '<em><b>Validity Formula</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validity Formula</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validity Formula</em>' reference.
	 * @see #setValidityFormula(HyValidityFormula)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationValidityFormula_ValidityFormula()
	 * @model required="true"
	 * @generated
	 */
	HyValidityFormula getValidityFormula();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula#getValidityFormula <em>Validity Formula</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validity Formula</em>' reference.
	 * @see #getValidityFormula()
	 * @generated
	 */
	void setValidityFormula(HyValidityFormula value);

} // DwEvolutionOperationValidityFormula
