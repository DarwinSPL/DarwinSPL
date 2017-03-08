/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

/**
 * Basic evolution operation which delete a feature. Make case analysis to do the right intention of the user.
 */
public class Delete extends ComplexOperation {

	private HyFeature feature;
	private HyGroup group;
	private HyGroupComposition groupComposition;
	private HyFeatureTypeEnum oldFeatureType;
	private HyFeature oldParent;
	
	public Delete(HyFeature feature, Date timestamp) {
		
		this.feature = feature;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		oldFeatureType = HyFeatureEvolutionUtil.getType(feature, timestamp).getType();
		oldParent = HyFeatureEvolutionUtil.getParentFeatureOfFeature(feature, timestamp);
		
		//in case that this evo op will be execute to get the new group composition
		DeleteFeatureInGroup deleteFeatureInGroup = null;
		
		//find the current membership of the feature
		for (HyGroupComposition membership : feature.getGroupMembership()) {
			if (membership.getValidUntil() == null) {
				groupComposition = membership;
				break;
			}
		}
		//if only the feature is a member of the groupCOmposition, the group must also be delete
		if (groupComposition.getFeatures().size() == 1) {
			group = groupComposition.getCompositionOf();
			DeleteFeatureWithGroup deleteFeatureWithGroup = new DeleteFeatureWithGroup(feature, group, timestamp);
			addToComposition(deleteFeatureWithGroup);
		} else {
			deleteFeatureInGroup = new DeleteFeatureInGroup(feature, timestamp);
			addToComposition(deleteFeatureInGroup);
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (groupComposition == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		group = null;
		groupComposition = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
		
	}
	
	//Getter
	public HyFeature getFeature() {
		return feature;
	}
	//in case that the group will also be delete
	public HyGroup getGroup() {
		return group;
	}
	
	public HyFeatureTypeEnum getOldFeatureType() {
		return oldFeatureType;
	}

	public HyFeature getOldParent() {
		return oldParent;
	}
}
