/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyGroupType;

/**
 * atomic operation which delete a group type from a tfm
 */
public class DeleteGroupType implements EvolutionOperation {

	private HyGroupType groupType;
	private Date timestamp;
	
	public DeleteGroupType(HyGroupType groupType, Date timestamp) {
		
		this.groupType = groupType;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		groupType.setValidUntil(timestamp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (groupType.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		groupType.setValidUntil(null);

	}
	
	//Getter
	public HyGroupType getGroupType() {
		return groupType;
	}

}
