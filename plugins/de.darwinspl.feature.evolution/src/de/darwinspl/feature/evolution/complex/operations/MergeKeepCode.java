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

	HyFeature feature;
	
	public MergeKeepCode(HyFeature feature, Date timestamp) {
		
		this.feature = feature;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		 
		DeleteButKeepCode deleteButKeepCode = new DeleteButKeepCode(feature, timestamp);
		addToComposition(deleteButKeepCode);

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

}
