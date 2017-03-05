/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.complex.operations.DeleteFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.DeleteGroupWithTypeChildAndComposition;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;

/**
 *  represent the delete(iG) which delete a feature and his group
 */
public class DeleteFeatureWithGroup extends ComplexOperation {
	
	private HyFeature feature;
	
	private HyFeatureType featureType;
	private HyName name;
	private HyGroup group;
	private HyGroupComposition groupComposition;
	private HyFeatureChild featureChild;
	private HyGroupType groupType;

	public DeleteFeatureWithGroup(HyFeature feature,HyGroup group, Date timestamp) {

		this.feature = feature;
		this.group = group;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		DeleteFeatureWithNameAndType deleteFeature = new DeleteFeatureWithNameAndType(feature, timestamp);
		DeleteGroupWithTypeChildAndComposition deleteGroup = new DeleteGroupWithTypeChildAndComposition(group, timestamp);
		
		addToComposition(deleteGroup);
		addToComposition(deleteFeature);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		featureType = deleteFeature.getFeatureType();
		name = deleteFeature.getName();
		groupComposition = deleteGroup.getGroupComposition();
		featureChild = deleteGroup.getFeatureChild();
		groupType = deleteGroup.getGroupType();
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
		
		featureType = null;
		name = null;
		groupComposition = null;
		featureChild = null;
		groupType = null;

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
	public HyFeatureType getFeatureType() {
		return featureType;
	}
	public HyName getName() {
		return name;
	}
	public HyGroup getGroup() {
		return group;
	}
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}
	public HyFeatureChild getFeatureChild() {
		return featureChild;
	}
	public HyGroupType getGroupType() {
		return groupType;
	}

}
