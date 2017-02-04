/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyGroupType;

/**
 *
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
		// TODO Auto-generated method stub

	}
	public HyGroupType getGroupType() {
		return groupType;
	}

}
