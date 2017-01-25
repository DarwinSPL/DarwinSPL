/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureType;

/**
 *
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
		// TODO Auto-generated method stub

	}
	public HyFeatureType getFeatureType() {
		return featureType;
	}

}
