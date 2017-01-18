/**
 * 
 */
package de.darwinspl.feature.evolution.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.basic.operations.AddFeature;
import de.darwinspl.feature.evolution.basic.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
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
	private HyGroupComposition groupComposition;

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
		
		AddFeature newFeature = new AddFeature(name, featureType, timestamp);
		//Iterate through the group composition list of the group and find the element where no until is that. This element must by the current valid composition
		for (HyGroupComposition composition : group.getParentOf()) {
			if (composition.getValidUntil() == null) {
				groupComposition = composition; 
				break;
			}
		}
		
		//add the new created feature to the group composition		
		AddToGroupComposition newGroupComposition = new AddToGroupComposition(groupComposition, feature , timestamp);
		
		addToComposition(newFeature);
		addToComposition(newGroupComposition);	
		
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		this.feature = newFeature.getFeature();
		this.groupComposition = newGroupComposition.getGroupComposition();
		//set the last relation between feature and groupCompisition and add the feature to the model
		feature.getGroupMembership().add(groupComposition);
		tfm.getFeatures().add(feature);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
