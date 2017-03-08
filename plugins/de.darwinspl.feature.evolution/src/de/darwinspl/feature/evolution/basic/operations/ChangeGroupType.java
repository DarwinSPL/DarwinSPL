/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupType;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

/**
 * Basic evolution operation which change the type of a group
 */
public class ChangeGroupType extends ComplexOperation {
	private HyGroup group;
	private HyGroupTypeEnum newGroupTypeEnum;
	
	private HyGroupType oldGroupType, newGroupType;
	
	protected List<HyFeature> featuresChangedToOptional;
	
	public ChangeGroupType(HyGroup group, HyGroupTypeEnum newType, Date timestamp) {
		this.featuresChangedToOptional = new ArrayList<HyFeature>();
		this.group = group;
		this.newGroupTypeEnum = newType;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the valid groupType object
		this.oldGroupType = HyFeatureEvolutionUtil.getType(group, timestamp);

		DeleteGroupType deleteGroupType = new DeleteGroupType(oldGroupType, timestamp);
		AddGroupType addGroupType = new AddGroupType(newGroupTypeEnum, group, timestamp);
		
		addToComposition(deleteGroupType);
		addToComposition(addGroupType);
		
		// If group was AND and is changed to OR or ALTERNATIVE, all mandatory child have to become optional
		if(oldGroupType.getType().equals(HyGroupTypeEnum.AND) && (newGroupTypeEnum.equals(HyGroupTypeEnum.OR) || newGroupTypeEnum.equals(HyGroupTypeEnum.ALTERNATIVE))) {
			for(HyFeature childFeature: HyFeatureEvolutionUtil.getFeaturesOfGroup(group, timestamp)) {
				if(HyFeatureEvolutionUtil.getType(childFeature, timestamp).getType().equals(HyFeatureTypeEnum.MANDATORY)) {
					ChangeFeatureType changeFeatureType = new ChangeFeatureType(childFeature, timestamp);
					addToComposition(changeFeatureType);
				}
			}			
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
			
			if(evolutionOperation instanceof ChangeFeatureType) {
				featuresChangedToOptional.add(((ChangeFeatureType) evolutionOperation).getFeature());
			}
		}
		
		newGroupType = addGroupType.getGroupType();
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (newGroupType == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		oldGroupType = null;
		newGroupType = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	//Getter
	public HyGroup getFeature() {
		return group;
	}
	public HyGroupType getOldFeatureType() {
		return oldGroupType;
	}
	public HyGroupType getNewFeatureType() {
		return newGroupType;
	}
	public List<HyFeature> getFeaturesChangedToOptional() {
		return featuresChangedToOptional;
	}
	
	

}
