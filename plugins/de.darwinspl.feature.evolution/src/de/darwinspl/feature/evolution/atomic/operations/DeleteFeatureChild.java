/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureChild;

/**
 *
 */
public class DeleteFeatureChild implements EvolutionOperation {

	private HyFeatureChild featureChild;
	private Date timestamp;
	
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
		// TODO Auto-generated method stub

	}
	
	//Getter
	public HyFeatureChild getFeatureChild() {
		return featureChild;
	}

}
