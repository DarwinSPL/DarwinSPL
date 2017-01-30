/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.complex.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.complex.operations.RemoveFromGroupComposition;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroupComposition;

/**
 * On execute the operation will move a Feature from one group into another. The group, which are contains the feature before the evolution operation will still exist after the evolution.
 */
public class MoveFeature extends ComplexOperation {

	private HyFeature feature;
	private HyGroupComposition oldGroupCompositionBefore, newGroupCompositionBefore, oldGroupCompositionAfter, newGroupCompositionAfter;
	
	/**
	 * 
	 * @param feature which should be move 
	 * @param groupComposition new group composition of the feature
	 * @param timestamp
	 */
	public MoveFeature(HyFeature feature, HyGroupComposition groupComposition, Date timestamp) {
		
		this.feature = feature;
		this.newGroupCompositionBefore = groupComposition;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		for (HyGroupComposition composition : feature.getGroupMembership()) {
			if (composition.getValidUntil() == null) {
				this.oldGroupCompositionBefore = composition;
				break;
			}
		}
		
		//remove the feature from the old group composition
		RemoveFromGroupComposition updateOldGroupComposition = new RemoveFromGroupComposition(oldGroupCompositionBefore, feature, timestamp);
		//add the feature to the new group composition
		AddToGroupComposition updateNewGroupComposition = new AddToGroupComposition(newGroupCompositionBefore, feature, timestamp);
		
		addToComposition(updateOldGroupComposition);
		addToComposition(updateNewGroupComposition);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		//get the both new group compositions after the evolution
		this.oldGroupCompositionAfter = updateOldGroupComposition.getNewGroupComposition();
		this.newGroupCompositionAfter = updateNewGroupComposition.getNewGroupComposition();
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
	public HyGroupComposition getOldGroupCompositionBefore() {
		return oldGroupCompositionBefore;
	}
	public HyGroupComposition getNewGroupCompositionBefore() {
		return newGroupCompositionBefore;
	}
	public HyGroupComposition getOldGroupCompositionAfter() {
		return oldGroupCompositionAfter;
	}
	public HyGroupComposition getNewGroupCompositionAfter() {
		return newGroupCompositionAfter;
	}

}
