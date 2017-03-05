/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureType;

/**
 * atomic operation which delete a feature type from a tfm
 */
public class DeleteFeatureType implements EvolutionOperation {

	private HyFeatureType featureType;
	private Date timestamp;
	
	public DeleteFeatureType(HyFeatureType featureType, Date timestamp) {
		
		this.featureType = featureType;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		featureType.setValidUntil(timestamp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (featureType.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		featureType.setValidUntil(null);

	}
	
	//Getter
	public HyFeatureType getFeatureType() {
		return featureType;
	}

}
