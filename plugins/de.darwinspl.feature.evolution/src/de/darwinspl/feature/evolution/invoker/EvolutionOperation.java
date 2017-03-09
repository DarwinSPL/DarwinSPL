/**
 * 
 */
package de.darwinspl.feature.evolution.invoker;

import java.util.Date;

import eu.hyvar.feature.HyFeatureModel;

/**
 * Interface for all types of evolution operation. This interface provide all executable methods for the evolution ops and for the invoker to handle with the evolution ops
 */
public abstract class EvolutionOperation {

	protected Date timestamp;
	protected HyFeatureModel copyOfFeatureModelBeforeEvolution;
	
	// TODO integrate error message handling
	// TODO should return boolean success
	//Method to execute the evolution operation
	public abstract void execute();
	//Method to undo an executed evolution operation
	public abstract void undo();
	public Date getTimestamp() {
		return timestamp;
	}
	public HyFeatureModel getCopyOfFeatureModelBeforeEvolution() {
		return copyOfFeatureModelBeforeEvolution;
	}
	public void setCopyOfFeatureModelBeforeEvolution(HyFeatureModel copyOfFeatureModelBeforeEvolution) {
		this.copyOfFeatureModelBeforeEvolution = copyOfFeatureModelBeforeEvolution;
	}

	
	
	
	
	
}
