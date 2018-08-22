/**
 */
package de.darwinspl.feature.evolution.evolutionoperation;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dw Evolution Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation#getEvoStep <em>Evo Step</em>}</li>
 * </ul>
 *
 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperation()
 * @model abstract="true"
 * @generated
 */
public interface DwEvolutionOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Evo Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evo Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evo Step</em>' attribute.
	 * @see #setEvoStep(Date)
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#getDwEvolutionOperation_EvoStep()
	 * @model
	 * @generated
	 */
	Date getEvoStep();

	/**
	 * Sets the value of the '{@link de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation#getEvoStep <em>Evo Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evo Step</em>' attribute.
	 * @see #getEvoStep()
	 * @generated
	 */
	void setEvoStep(Date value);

} // DwEvolutionOperation
