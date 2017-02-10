/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
 */
public class AddFeatureInGroup extends ComplexOperation {

	private String name;
	private HyFeatureTypeEnum featureType;
	private HyGroup group;
	private HyFeature feature;
	private HyGroupComposition newGroupComposition, oldGroupComposition;

	/**
	 * Add a feature to the model and hang it into a consisting group
	 * @param name of the new feature
	 * @param featureType of the new feature
	 * @param groupComposition into the new feature should be add
	 * @param timestamp from the execution of the evoOp
	 * @param tfm 
	 */
	public AddFeatureInGroup(String name, HyFeatureTypeEnum featureType, HyGroup group, Date timestamp, HyFeatureModel tfm) {

		this.name = name;
		this.featureType = featureType;
		this.group = group;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
			
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		AddFeatureWithNameAndType newFeature = new AddFeatureWithNameAndType(name, featureType, timestamp);
		//Iterate through the group composition list of the group and find the element where no until is that. This element must by the current valid composition
		for (HyGroupComposition composition : group.getParentOf()) {
			if (composition.getValidUntil() == null) {
				oldGroupComposition = composition; 
				break;
			}
		}
		
		//newGroupComposition needed the new feature object, therefore it AddFeature must be executed before it, instead of the normal procedure with the evoOp-list 
		newFeature.execute();
		this.feature = newFeature.getFeature();
		
		//add the new created feature to the group composition		
		AddToGroupComposition newGroupComposition = new AddToGroupComposition(oldGroupComposition, feature , timestamp);
		newGroupComposition.execute();
		
		addToComposition(newFeature);
		addToComposition(newGroupComposition);
				
		this.newGroupComposition = newGroupComposition.getNewGroupComposition();
		//set the last relation between feature and groupCompisition and add the feature to the model
		feature.getGroupMembership().add(this.newGroupComposition);
		tfm.getFeatures().add(feature);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (newGroupComposition == null) {
			return;
		}
		
		tfm.getFeatures().remove(feature);
		feature.getGroupMembership().remove(newGroupComposition);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		oldGroupComposition = null;
		feature = null;
		newGroupComposition = null;
		

	}

	public HyFeature getFeature() {
		return feature;
	}
	
	public HyGroupComposition getNewGroupComposition() {
		return newGroupComposition;
	}
	
	public HyGroupComposition getOldGroupComposition() {
		return oldGroupComposition;
	}
}
