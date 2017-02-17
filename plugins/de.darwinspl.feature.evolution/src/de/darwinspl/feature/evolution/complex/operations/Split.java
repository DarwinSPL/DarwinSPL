/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 * Split a feature into two child features in an Or group
 */
public class Split extends ComplexOperation {

	HyFeature oldFeature, newFeature1, newFeature2;
	HyGroup group;
	String nameOfFeature1, nameOfFeature2;
	
	public Split(HyFeature feature, String name1, String name2, Date timestamp, HyFeatureModel tfm) {
		
		this.oldFeature = feature;
		this.nameOfFeature1 = name1;
		this.nameOfFeature2 = name2;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//feature type should be optional, because to avoid further conflicts
		AddFeatureWithGroup addNewFeatureWithGroup = new AddFeatureWithGroup(nameOfFeature1, HyFeatureTypeEnum.OPTIONAL, oldFeature, timestamp, tfm);
		//the add group is needed for the next evolution operation, therefore this evolutions must be execute
		addNewFeatureWithGroup.execute();
		
		AddFeatureInGroup addSecondFeatureInGroup = new AddFeatureInGroup(nameOfFeature2, HyFeatureTypeEnum.OPTIONAL, addNewFeatureWithGroup.getGroup(), timestamp, tfm);
		addToComposition(addSecondFeatureInGroup);
		
		ChangeGroupType changeGroupToOr = new ChangeGroupType(addNewFeatureWithGroup.getGroup(), HyGroupTypeEnum.OR, timestamp);
		addToComposition(changeGroupToOr);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		//Add for undo operation
		addToComposition(addNewFeatureWithGroup);
		
		group = addNewFeatureWithGroup.getGroup();
		newFeature1 = addNewFeatureWithGroup.getFeature();
		newFeature2 = addSecondFeatureInGroup.getFeature();

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		if (group == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		newFeature1 = null;
		newFeature2 = null;
		group = null;
	}
	//Getter
	public HyFeature getOldFeature() {
		return oldFeature;
	}
	public HyFeature getNewFeature1() {
		return newFeature1;
	}
	public HyFeature getNewFeature2() {
		return newFeature2;
	}
	public HyGroup getGroup() {
		return group;
	}

}
