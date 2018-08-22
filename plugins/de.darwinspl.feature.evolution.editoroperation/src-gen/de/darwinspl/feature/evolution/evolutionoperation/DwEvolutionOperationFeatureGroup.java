/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.feature.HyGroupComposition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Feature Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getOldGroup <em>Old Group</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getNewGroup <em>New Group</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureGroup()
 * @model
 * @generated
 */
public interface DwEvolutionOperationFeatureGroup extends DwEvolutionOperationFeature {
	/**
	 * Returns the value of the '<em><b>Old Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Group</em>' reference.
	 * @see #setOldGroup(HyGroupComposition)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureGroup_OldGroup()
	 * @model
	 * @generated
	 */
	HyGroupComposition getOldGroup();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getOldGroup <em>Old Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Group</em>' reference.
	 * @see #getOldGroup()
	 * @generated
	 */
	void setOldGroup(HyGroupComposition value);

	/**
	 * Returns the value of the '<em><b>New Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Group</em>' reference.
	 * @see #setNewGroup(HyGroupComposition)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureGroup_NewGroup()
	 * @model required="true"
	 * @generated
	 */
	HyGroupComposition getNewGroup();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup#getNewGroup <em>New Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Group</em>' reference.
	 * @see #getNewGroup()
	 * @generated
	 */
	void setNewGroup(HyGroupComposition value);

} // DwEvolutionOperationFeatureGroup
