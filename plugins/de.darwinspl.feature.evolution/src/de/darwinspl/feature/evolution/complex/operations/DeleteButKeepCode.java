/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.Delete;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;

/**
 * Until no Mapping evolution operations are implemented, this evolution operation do the same like the normal delete evo op
 */
public class DeleteButKeepCode extends ComplexOperation {

	private HyFeature feature;
	
	public DeleteButKeepCode(HyFeature feature, Date timestamp) {
		
		this.feature = feature;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		Delete delete = new Delete(feature, timestamp);
		addToComposition(delete);
		
		//Insert mapping evolution
		
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
		if (feature.getValidUntil().compareTo(timestamp) != 0) {
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
	public HyFeature getFeature() {
		return feature;
	}

}
