/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureChild;

/**
 * atomic operation which delete a feature child from a tfm
 */
public class DeleteFeatureChild extends EvolutionOperation {

	private HyFeatureChild featureChild;
	
	public DeleteFeatureChild(HyFeatureChild featureChild, Date timestamp) {
		
		this.featureChild = featureChild;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		featureChild.setValidUntil(timestamp);
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (featureChild.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		featureChild.setValidUntil(null);
		
	}
	
	//Getter
	public HyFeatureChild getFeatureChild() {
		return featureChild;
	}

}
