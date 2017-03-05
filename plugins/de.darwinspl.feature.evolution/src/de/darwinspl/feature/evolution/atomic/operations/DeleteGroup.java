/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyGroup;

/**
 * atomic operation which delete a group from a tfm
 */
public class DeleteGroup implements EvolutionOperation {

	private HyGroup group;
	private Date timestamp;
	
	public DeleteGroup(HyGroup group, Date timestamp) {
		
		this.group = group;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		group.setValidUntil(timestamp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (group.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		
		group.setValidUntil(null);

	}
	
	//Getter
	public HyGroup getGroup() {
		return group;
	}

}
