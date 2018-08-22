/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import eu.hyvar.feature.HyVersion;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation Feature Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureVersion()
 * @model abstract="true"
 * @generated
 */
public interface DwEvolutionOperationFeatureVersion extends DwEvolutionOperationFeature {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' reference.
	 * @see #setVersion(HyVersion)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperationFeatureVersion_Version()
	 * @model required="true"
	 * @generated
	 */
	HyVersion getVersion();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion#getVersion <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(HyVersion value);

} // DwEvolutionOperationFeatureVersion
