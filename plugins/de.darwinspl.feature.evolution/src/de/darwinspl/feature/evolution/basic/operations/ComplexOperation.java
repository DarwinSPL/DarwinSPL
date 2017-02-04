/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.ArrayList;
import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureModel;

/**
 *
 */
public abstract class ComplexOperation implements EvolutionOperation {
	
	protected Date timestamp;
	protected HyFeatureModel tfm;
	protected ArrayList<EvolutionOperation> evoOps = new ArrayList<EvolutionOperation>();

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public abstract void execute();

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public abstract void undo();
	
	/**
	 * 
	 * @param operation: Atomic or basis operation which should add to the complexe operation
	 */
	public void addToComposition(EvolutionOperation operation) {
		evoOps.add(operation);
	}

	/**
	 * 
	 * @param operation: Atomic or basis operation which should remove to the complexe operation
	 */
	public void removeFromComposition(EvolutionOperation operation) {
		evoOps.remove(operation);
	}
	
}
