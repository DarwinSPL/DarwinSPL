/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.complex.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.complex.operations.DeleteGroupWithTypeChildAndComposition;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 * Move a feature from a group which will have no features in his composition after the evolution, to another group.
 */
public class MoveFeatureDeleteGroup extends ComplexOperation {

	private HyFeature feature;
	private HyGroup group;
	private HyGroupComposition newGroupCompositionBefore, newGroupCompositionAfter;
	
	/**
	 * 
	 * @param feature which should be move 
	 * @param group which will be deleted
	 * @param groupComposition new groupComposition of the feature
	 * @param timestamp
	 */
	public MoveFeatureDeleteGroup(HyFeature feature, HyGroup group, HyGroupComposition groupComposition, Date timestamp) {
		
		this.feature = feature;
		this.group = group;
		this.newGroupCompositionBefore = groupComposition;
		this.timestamp = timestamp;
	}
	
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//Delete the current Group of the feature
		DeleteGroupWithTypeChildAndComposition deleteGroup = new DeleteGroupWithTypeChildAndComposition(group, timestamp);
		//add the feature to the groupcomposition
		AddToGroupComposition updateGroupComposition = new AddToGroupComposition(newGroupCompositionBefore, feature, timestamp);
		
		addToComposition(deleteGroup);
		addToComposition(updateGroupComposition);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}

		this.newGroupCompositionAfter = updateGroupComposition.getNewGroupComposition();
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	//Getters
	public HyFeature getFeature() {
		return feature;
	}

	public HyGroup getGroup() {
		return group;
	}

	public HyGroupComposition getNewGroupCompositionBefore() {
		return newGroupCompositionBefore;
	}

	public HyGroupComposition getNewGroupCompositionAfter() {
		return newGroupCompositionAfter;
	}

}
