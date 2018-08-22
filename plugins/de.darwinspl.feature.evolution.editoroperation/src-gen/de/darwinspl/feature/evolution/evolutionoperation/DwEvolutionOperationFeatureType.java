/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.feature.HyFeatureType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Feature Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getOldType <em>Old Type</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getNewType <em>New Type</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureType()
 * @model
 * @generated
 */
public interface DwEvolutionOperationFeatureType extends DwEvolutionOperationFeature {
	/**
	 * Returns the value of the '<em><b>Old Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Type</em>' reference.
	 * @see #setOldType(HyFeatureType)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureType_OldType()
	 * @model
	 * @generated
	 */
	HyFeatureType getOldType();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getOldType <em>Old Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Type</em>' reference.
	 * @see #getOldType()
	 * @generated
	 */
	void setOldType(HyFeatureType value);

	/**
	 * Returns the value of the '<em><b>New Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Type</em>' reference.
	 * @see #setNewType(HyFeatureType)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureType_NewType()
	 * @model required="true"
	 * @generated
	 */
	HyFeatureType getNewType();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType#getNewType <em>New Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Type</em>' reference.
	 * @see #getNewType()
	 * @generated
	 */
	void setNewType(HyFeatureType value);

} // DwEvolutionOperationFeatureType
