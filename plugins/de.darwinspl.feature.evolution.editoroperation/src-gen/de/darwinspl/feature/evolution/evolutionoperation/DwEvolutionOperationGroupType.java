/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.feature.HyGroupType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Group Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getOldType <em>Old Type</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getNewType <em>New Type</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationGroupType()
 * @model
 * @generated
 */
public interface DwEvolutionOperationGroupType extends DwEvolutionOperationGroup {
	/**
	 * Returns the value of the '<em><b>Old Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Type</em>' reference.
	 * @see #setOldType(HyGroupType)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationGroupType_OldType()
	 * @model
	 * @generated
	 */
	HyGroupType getOldType();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getOldType <em>Old Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Type</em>' reference.
	 * @see #getOldType()
	 * @generated
	 */
	void setOldType(HyGroupType value);

	/**
	 * Returns the value of the '<em><b>New Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Type</em>' reference.
	 * @see #setNewType(HyGroupType)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationGroupType_NewType()
	 * @model required="true"
	 * @generated
	 */
	HyGroupType getNewType();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType#getNewType <em>New Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Type</em>' reference.
	 * @see #getNewType()
	 * @generated
	 */
	void setNewType(HyGroupType value);

} // DwEvolutionOperationGroupType
