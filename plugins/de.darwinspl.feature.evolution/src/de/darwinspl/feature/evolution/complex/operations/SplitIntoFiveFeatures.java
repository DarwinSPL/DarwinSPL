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
 * Split a feature into five child features in an Or group
 */
public class SplitIntoFiveFeatures extends ComplexOperation {

	HyFeature oldFeature, newFeature1, newFeature2, newFeature3, newFeature4, newFeature5;
	HyGroup group;
	String nameOfFeature1, nameOfFeature2, nameOfFeature3, nameOfFeature4, nameOfFeature5;
	
	public SplitIntoFiveFeatures(HyFeature feature, String name1, String name2, String name3, String name4, String name5, Date timestamp, HyFeatureModel tfm) {
		
		this.oldFeature = feature;
		this.nameOfFeature1 = name1;
		this.nameOfFeature2 = name2;
		this.nameOfFeature3 = name3;
		this.nameOfFeature4 = name4;
		this.nameOfFeature5 = name5;
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
		
		AddFeatureInGroup addThirdFeatureInGroup = new AddFeatureInGroup(nameOfFeature3, HyFeatureTypeEnum.OPTIONAL, addNewFeatureWithGroup.getGroup(), timestamp, tfm);
		addToComposition(addThirdFeatureInGroup);
		
		AddFeatureInGroup addFourthFeatureInGroup = new AddFeatureInGroup(nameOfFeature4, HyFeatureTypeEnum.OPTIONAL, addNewFeatureWithGroup.getGroup(), timestamp, tfm);
		addToComposition(addFourthFeatureInGroup);
		
		AddFeatureInGroup addFifthFeatureInGroup = new AddFeatureInGroup(nameOfFeature5, HyFeatureTypeEnum.OPTIONAL, addNewFeatureWithGroup.getGroup(), timestamp, tfm);
		addToComposition(addFifthFeatureInGroup);
		
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
		newFeature3 = addThirdFeatureInGroup.getFeature();
		newFeature4 = addFourthFeatureInGroup.getFeature();
		newFeature5 = addFifthFeatureInGroup.getFeature();

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
		newFeature3 = null;
		newFeature4 = null;
		newFeature5 = null;
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
	public HyFeature getNewFeature3() {
		return newFeature3;
	}
	public HyFeature getNewFeature4() {
		return newFeature4;
	}
	public HyFeature getNewFeature5() {
		return newFeature5;
	}
	public HyGroup getGroup() {
		return group;
	}

}
