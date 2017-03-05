/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.ArrayList;
import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;

/**
 * represent the complex evolution operation
 */
public abstract class ComplexOperation implements EvolutionOperation {
	
	protected Date timestamp;
	protected ArrayList<EvolutionOperation> evoOps = new ArrayList<EvolutionOperation>();

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 * Execute the complex evolution operation
	 */
	@Override
	public abstract void execute();

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 * Undo the complex evolution operation, if it was executed
	 */
	@Override
	public abstract void undo();
	
	/**
	 * 
	 * @param operation: atomic, basic or complex operation which should add to the complex operation
	 */
	public void addToComposition(EvolutionOperation operation) {
		evoOps.add(operation);
	}

	/**
	 * 
	 * @param operation: atomic, basic or complex operation which should remove to the complex operation
	 */
	public void removeFromComposition(EvolutionOperation operation) {
		evoOps.remove(operation);
	}
	
}
