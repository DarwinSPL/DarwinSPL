/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
 */
public class Delete extends ComplexOperation {

	private HyFeature feature;
	private HyGroup group;
	private HyGroupComposition newGroupComposition;
	
	public Delete(HyFeature feature, Date timestamp) {
		
		this.feature = feature;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//in case that this evo op will be execute to get the new group composition
		DeleteFeatureInGroup deleteFeatureInGroup = null;
		
		HyGroupComposition groupComposition = null;
		//find the current membership of the feature
		for (HyGroupComposition membership : feature.getGroupMembership()) {
			if (membership.getValidUntil() == null) {
				groupComposition = membership;
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

		if (deleteFeatureInGroup != null) {
			newGroupComposition = deleteFeatureInGroup.getNewGroupComposition();
		}
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	//Getter
	public HyFeature getFeature() {
		return feature;
	}
	public HyGroup getGroup() {
		return group;
	}
	public HyGroupComposition getNewGroupComposition() {
		return newGroupComposition;
	}

}
