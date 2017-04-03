/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.AddGroupWithTypeChildAndComposition;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 * represent the add(mG) which add a feature with a new group
 */
public class AddFeatureWithGroup extends ComplexOperation {

	private String name;
	private HyFeatureTypeEnum featureType;
	private HyFeature parent;
	
	private HyFeature feature;
	private EList<HyFeature> features = new BasicEList<HyFeature>();
	private HyGroupTypeEnum groupType = HyGroupTypeEnum.AND;	//For a new group with only one feature the group should be AND
	private HyGroup group;
	
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

		AddFeatureWithNameAndType newFeature = new AddFeatureWithNameAndType(name, featureType, timestamp, tfm);
		newFeature.execute();
		feature = newFeature.getFeature();
		
		//Only the new created feature is member of the new group
		features.add(feature);	
		AddGroupWithTypeChildAndComposition newGroup = new AddGroupWithTypeChildAndComposition(groupType, parent, features, timestamp, tfm);
		newGroup.execute();
		
		addToComposition(newFeature);
		addToComposition(newGroup);
		
		group = newGroup.getGroup();
		
		tfm.getFeatures().add(feature);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (group == null) {
			return;
		}
		
		tfm.getFeatures().remove(feature);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		features.remove(feature);
		feature = null;
		group = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}

	public HyFeature getFeature() {
		return feature;
	}
	
	public HyGroup getGroup() {
		return group;
	}
	

}
