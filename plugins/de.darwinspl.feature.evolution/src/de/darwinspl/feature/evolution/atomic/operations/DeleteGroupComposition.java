/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyGroupComposition;

/**
 * atomic operation which delete a group composition from a tfm
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
		//check if the execute method was executed, otherwise leave this method
		if (groupComposition.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		groupComposition.setValidUntil(null);

	}
	
	//Getter
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}

}
