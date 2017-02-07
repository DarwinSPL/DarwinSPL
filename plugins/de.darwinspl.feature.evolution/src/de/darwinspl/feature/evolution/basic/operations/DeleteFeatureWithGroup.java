/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.DeleteFeature;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroup;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;

/**
 *
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
		
		DeleteFeature deleteFeature = new DeleteFeature(feature, timestamp);
		DeleteGroup deleteGroup = new DeleteGroup(group, timestamp);
		
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
