/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;

/**
 *
 */
public class DeleteGroup extends ComplexOperation {

	private HyGroup group;
	
	private HyFeatureChild featureChild;
	private HyGroupType groupType;
	private HyGroupComposition groupComposition;
	
	public DeleteGroup(HyGroup group, Date timestamp) {
		
		this.group = group;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//not optimal especially for groups with huge quantity of entries
		//get the valid object from grouptype, groupComposition and featureChild of the group
		for (HyGroupType groupType : group.getTypes()) {
			if (groupType.getValidUntil() == null) {
				this.groupType = groupType;
				break;
			}
		}
		for (HyGroupComposition composition : group.getParentOf()) {
			if (composition.getValidUntil() == null) {
				this.groupComposition = composition;
				break;
			}
		}
		for (HyFeatureChild child : group.getChildOf()) {
			if (child.getValidUntil() == null) {
				this.featureChild = child;
				break;
			}
		}
		
		DeleteGroupType deleteGroupType = new DeleteGroupType(groupType, timestamp);
		DeleteGroupComposition deleteGroupComposition = new DeleteGroupComposition(groupComposition, timestamp);
		DeleteFeatureChild deleteFeatureChild = new DeleteFeatureChild(featureChild, timestamp);
		addToComposition(deleteGroupType);
		addToComposition(deleteGroupComposition);
		addToComposition(deleteFeatureChild);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		group.setValidUntil(timestamp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	//Getters
	public HyGroup getGroup() {
		return group;
	}
	public HyFeatureChild getFeatureChild() {
		return featureChild;
	}
	public HyGroupType getGroupType() {
		return groupType;
	}
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}

}
