/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;

/**
 *
 */
public class MergeKeepCode extends ComplexOperation {

	HyFeature deleteFeature, targetFeature;
	
	public MergeKeepCode(HyFeature deleteFeature, HyFeature targetFeature, Date timestamp) {
		
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
		

	}
	
	//Getter
	public HyFeature getDeleteFeature() {
		return deleteFeature;
	}
	public HyFeature getTargetFeature() {
		return targetFeature;
	}

}
