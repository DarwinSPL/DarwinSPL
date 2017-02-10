/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.complex.operations.DeleteFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.RemoveFromGroupComposition;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroupComposition;

/**
 * 
 */
public class DeleteFeatureInGroup extends ComplexOperation {

	private HyFeature feature;
	
	private HyFeatureType featureType;
	private HyName name;
	private HyGroupComposition oldGroupComposition;
	private HyGroupComposition newGroupComposition;
	
    public DeleteFeatureInGroup(HyFeature feature, Date timestamp) {

    	this.feature = feature;
    	this.timestamp = timestamp;
    	
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the current valid membership of the feature
		for (HyGroupComposition membership : feature.getGroupMembership()) {
			if (membership.getValidUntil() == null) {
				this.oldGroupComposition = membership;
				break;
			}
		}
		
		RemoveFromGroupComposition updateGroupComposition = new RemoveFromGroupComposition(oldGroupComposition, feature, timestamp);
		DeleteFeatureWithNameAndType deleteFeature = new DeleteFeatureWithNameAndType(feature, timestamp);
		
		addToComposition(updateGroupComposition);
		addToComposition(deleteFeature);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		//set the rest of global variables
		this.newGroupComposition = updateGroupComposition.getNewGroupComposition();
		this.featureType = deleteFeature.getFeatureType();
		this.name = deleteFeature.getName();
		
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		if (newGroupComposition == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		featureType = null;
		name = null;
		oldGroupComposition = null;
		newGroupComposition = null;

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
	public HyGroupComposition getOldGroupComposition() {
		return oldGroupComposition;
	}
	public HyGroupComposition getNewGroupComposition() {
		return newGroupComposition;
	}

}
