/**
 * 
 */
package de.evolution.framework;

import java.util.ArrayList;
import java.util.Date;

import eu.hyvar.feature.HyFeatureModel;

/**
 *
 */
public abstract class ComplexeOperation implements EvolutionOperation {
	
	protected Date timestamp;
	protected HyFeatureModel tfm;
	private ArrayList<EvolutionOperation> evoOps = new ArrayList<EvolutionOperation>();

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
	public void add(EvolutionOperation operation) {
		evoOps.add(operation);
	}

	/**
	 * 
	 * @param operation: Atomic or basis operation which should remove to the complexe operation
	 */
	public void remove(EvolutionOperation operation) {
		evoOps.remove(operation);
	}
	
}
