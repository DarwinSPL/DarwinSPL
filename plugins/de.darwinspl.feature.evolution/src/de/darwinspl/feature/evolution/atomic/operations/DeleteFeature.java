/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;

/**
 * atomic operation which delete a feature from a tfm
 */
public class DeleteFeature implements EvolutionOperation {

	private Date timestamp;
	private HyFeature feature;
	
	public DeleteFeature(HyFeature feature, Date timestamp) {
		
		this.feature = feature;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		feature.setValidUntil(timestamp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (feature.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		
		feature.setValidUntil(null);

	}
	
	//Getter
	public HyFeature getFeature() {
		return feature;
	}

}
