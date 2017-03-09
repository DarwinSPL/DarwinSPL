/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.ArrayList;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureModel;

/**
 * represent the complex evolution operation
 */
public abstract class ComplexOperation extends EvolutionOperation {
	
	protected ArrayList<EvolutionOperation> evoOps = new ArrayList<EvolutionOperation>();

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
	
	@Override
	public void setCopyOfFeatureModelBeforeEvolution(HyFeatureModel copyOfFeatureModelBeforeEvolution) {
		super.setCopyOfFeatureModelBeforeEvolution(copyOfFeatureModelBeforeEvolution);
		for(EvolutionOperation evoOp: evoOps) {
			evoOp.setCopyOfFeatureModelBeforeEvolution(copyOfFeatureModelBeforeEvolution);
		}
	}
}
