/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupType;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 * Basic evolution operation which change the type of a group
 */
public class ChangeGroupType extends ComplexOperation {
	private HyGroup group;
	private HyGroupTypeEnum type;
	
	private HyGroupType oldGroupType, newGroupType;
	
	public ChangeGroupType(HyGroup group, HyGroupTypeEnum type, Date timestamp) {
		
		this.group = group;
		this.type = type;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the valid groupType object
		for (HyGroupType groupType : group.getTypes()) {
			if (groupType.getValidUntil() == null) {
				this.oldGroupType = groupType;
				break;
			}
		}

		DeleteGroupType deleteGroupType = new DeleteGroupType(oldGroupType, timestamp);
		AddGroupType addGroupType = new AddGroupType(type, group, timestamp);
		
		addToComposition(deleteGroupType);
		addToComposition(addGroupType);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		newGroupType = addGroupType.getGroupTyp();
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (newGroupType == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		oldGroupType = null;
		newGroupType = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	//Getter
	public HyGroup getFeature() {
		return group;
	}
	public HyGroupType getOldFeatureType() {
		return oldGroupType;
	}
	public HyGroupType getNewFeatureType() {
		return newGroupType;
	}

}
