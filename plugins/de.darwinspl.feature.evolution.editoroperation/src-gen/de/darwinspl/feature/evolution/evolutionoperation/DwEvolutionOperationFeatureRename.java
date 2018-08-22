/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.evolution.HyName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Feature Rename</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getOldName <em>Old Name</em>}</li>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getNewName <em>New Name</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureRename()
 * @model
 * @generated
 */
public interface DwEvolutionOperationFeatureRename extends DwEvolutionOperationFeature {
	/**
	 * Returns the value of the '<em><b>Old Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Name</em>' reference.
	 * @see #setOldName(HyName)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureRename_OldName()
	 * @model
	 * @generated
	 */
	HyName getOldName();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getOldName <em>Old Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Name</em>' reference.
	 * @see #getOldName()
	 * @generated
	 */
	void setOldName(HyName value);

	/**
	 * Returns the value of the '<em><b>New Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Name</em>' reference.
	 * @see #setNewName(HyName)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureRename_NewName()
	 * @model required="true"
	 * @generated
	 */
	HyName getNewName();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename#getNewName <em>New Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Name</em>' reference.
	 * @see #getNewName()
	 * @generated
	 */
	void setNewName(HyName value);

} // DwEvolutionOperationFeatureRename
