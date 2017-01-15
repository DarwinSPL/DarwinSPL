/**
 * 
 */
package de.darwinspl.feature.evolution.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.basic.operations.AddFeature;
import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import de.darwinspl.feature.evolution.basic.operations.UpdateGroupComposition;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
 */
public class AddFeatureInGroup extends ComplexOperation {

	private String name;
	private HyFeatureTypeEnum featureType;
	private HyGroupComposition oldGroupComposition;
	private HyGroupComposition newGroupComposition;
	private HyFeature feature;

	/**
	 * Add a feature to the model and hang it into a consisting group
	 * @param name of the new feature
	 * @param featureType of the new feature
	 * @param groupComposition into the new feature should be add
	 * @param timestamp from the execution of the evoOp
	 * @param tfm 
	 */
	public AddFeatureInGroup(String name, HyFeatureTypeEnum featureType, HyGroupComposition groupComposition, Date timestamp, HyFeatureModel tfm) {

		this.name = name;
		this.featureType = featureType;
		this.oldGroupComposition = groupComposition;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
		AddFeature newFeature = new AddFeature(name, featureType, timestamp);
		this.feature = newFeature.getFeature();
		
		//add the new created feature to the group composition
		List<HyFeature> features = new ArrayList<HyFeature>();
		features.add(feature);
		UpdateGroupComposition newGroupComposition = new UpdateGroupComposition(groupComposition, features , timestamp);
		this.newGroupComposition = newGroupComposition.getGroupComposition();
		
		add(newFeature);
		add(newGroupComposition);		
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {

		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		//set the last relation between feature and groupCompisition and add the feature to the model
		feature.getGroupMembership().add(newGroupComposition);
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
