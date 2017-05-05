/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;

/**
 * Merge a feature into another. The mapping evolution isn't implemented.
 */
public class MergeFeatures extends ComplexOperation {

	HyFeature deleteFeature, targetFeature;
	
	public MergeFeatures(HyFeature deleteFeature, HyFeature targetFeature, Date timestamp) {
		
		this.deleteFeature = deleteFeature;
		this.targetFeature = targetFeature;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		 
		DeleteButKeepCode deleteButKeepCode = new DeleteButKeepCode(deleteFeature, timestamp);
		addToComposition(deleteButKeepCode);
		
		//move code to the targetFeature

		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (deleteFeature.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	//Getter
	public HyFeature getDeleteFeature() {
		return deleteFeature;
	}
	public HyFeature getTargetFeature() {
		return targetFeature;
	}

}
