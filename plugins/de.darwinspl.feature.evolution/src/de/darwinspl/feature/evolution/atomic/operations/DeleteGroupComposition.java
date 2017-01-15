/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
 */
public class DeleteGroupComposition implements EvolutionOperation {


	private Date timestamp;
	private HyGroupComposition groupComposition;
	
	public DeleteGroupComposition(HyGroupComposition groupComposition, Date timestamp) {
		
		this.groupComposition = groupComposition;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		groupComposition.setValidUntil(timestamp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
