/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.atomic.operations.AddGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupComposition;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 * Remove a feature from a group composition
 */
public class RemoveFromGroupComposition extends ComplexOperation {

	private HyGroupComposition oldGroupComposition;
	private HyGroupComposition newGroupComposition;
	private HyGroup group;
	private HyFeature feature;
	
	/**
	 * Update a consisting group composition, where feature(s) should be removed from the composition
	 * @param groupComposition which are affected
	 * @param feature which should be removed
	 * @param timestamp from the execution of the evoOp
	 */
	public RemoveFromGroupComposition(HyGroupComposition groupComposition, HyFeature feature, Date timestamp) {
		
		this.oldGroupComposition = groupComposition;
		this.timestamp = timestamp;
		this.feature = feature;
				
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the group and the containing features of the group composition 
		this.group = oldGroupComposition.getCompositionOf();
		
		EList<HyFeature> features = new BasicEList<HyFeature>();
		features.addAll(oldGroupComposition.getFeatures());
		features.remove(feature);
		
		DeleteGroupComposition deleteOldComposition = new DeleteGroupComposition(oldGroupComposition, timestamp);
		AddGroupComposition addNewComposition = new AddGroupComposition(group, features , timestamp);
						
		//the order of the append is important for the execute, so first delete then add
		addToComposition(deleteOldComposition);
		addToComposition(addNewComposition);
		
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		newGroupComposition = addNewComposition.getGroupComposition();
		
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
				
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		group = null;
		newGroupComposition = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}

	//Getters
	public HyGroupComposition getNewGroupComposition() {
		return newGroupComposition;
	}
	
	public HyGroupComposition getOldGroupComposition() {
		return oldGroupComposition;
	}
	
	public HyFeature getRemovedFeature() {
		return feature;
	}

}
