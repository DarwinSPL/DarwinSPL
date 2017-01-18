/**
 * 
 */
package de.darwinspl.feature.evolution.operations;

import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.basic.operations.AddFeature;
import de.darwinspl.feature.evolution.basic.operations.AddGroup;
import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class AddFeatureWithGroup extends ComplexOperation {

	private String name;
	private HyFeatureTypeEnum featureType;
	private HyFeature parent;
	private Date timestamp;
	
	private HyFeature feature;
	private List<HyFeature> features;
	private HyGroupTypeEnum groupType = HyGroupTypeEnum.AND;	//For a new group with only one feature the group must be AND
	private HyGroupComposition groupComposition;
	private HyFeatureModel tfm;	
	
	/**
	 * Add a feature to the model and create a new (AND-) group where the feature should be located
	 * @param name of the new feature
	 * @param featureType of the new feature
	 * @param parent of the new group
	 * @param timestamp from the execution of the evoOp
	 * @param tfm
	 */
	public AddFeatureWithGroup(String name, HyFeatureTypeEnum featureType, HyFeature parent, Date timestamp, HyFeatureModel tfm) {
		
		this.name = name;
		this.featureType = featureType;
		this.parent = parent;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {

		AddFeature newFeature = new AddFeature(name, featureType, timestamp);
		feature = newFeature.getFeature();
		
		//Only the new created feature is member of the new group
		features.add(feature);	
		AddGroup newGroup = new AddGroup(groupType, parent, features, timestamp, tfm);
		
		addToComposition(newFeature);
		addToComposition(newGroup);
		
		//execute each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
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
