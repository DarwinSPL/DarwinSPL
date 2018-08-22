/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.dataValues.HyEnum;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum#getEnum <em>Enum</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationEnum()
 * @model abstract="true"
 * @generated
 */
public interface DwEvolutionOperationEnum extends DwEvolutionOperation {
	/**
	 * Returns the value of the '<em><b>Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum</em>' reference.
	 * @see #setEnum(HyEnum)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationEnum_Enum()
	 * @model required="true"
	 * @generated
	 */
	HyEnum getEnum();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum#getEnum <em>Enum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum</em>' reference.
	 * @see #getEnum()
	 * @generated
	 */
	void setEnum(HyEnum value);

} // DwEvolutionOperationEnum
