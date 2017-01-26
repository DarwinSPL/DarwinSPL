/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class ChangeGroupType extends ComplexOperation {
	private HyGroup group;
	private HyGroupTypeEnum type;
	private Date timestamp;
	
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
		// TODO Auto-generated method stub

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
