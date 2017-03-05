/**
 * 
 */
package de.darwinspl.feature.evolution.invoker;


/**
 * Interface for all types of evolution operation. This interface provide all executable methods for the evolution ops and for the invoker to handle with the evolution ops
 */
public interface EvolutionOperation {

	//Method to execute the evolution operation
	public void execute();
	//Method to undo an executed evolution operation
	public void undo();
	
}
