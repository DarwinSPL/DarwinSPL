/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupComposition;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
 */
public class UpdateGroupComposition extends ComplexOperation {

	private HyGroupComposition oldGroupComposition;
	private HyGroupComposition newGroupComposition;
	private HyGroup group;
	private List<HyFeature> features;
	
	/**
	 * Update a consisting group composition, where feature(s) should be moved out of the composition
	 * @param groupComposition which are affected
	 * @param features. List of feature(s) which should be moved
	 * @param timestamp from the execution of the evoOp
	 */
	public UpdateGroupComposition(HyGroupComposition groupComposition,List<HyFeature> features, Date timestamp) {
		
		this.oldGroupComposition = groupComposition;
		this.timestamp = timestamp;
		
		//get the group and the containing features of the group composition 
		this.group = oldGroupComposition.getCompositionOf();
		//get all feature from the old composition
		this.features.addAll(this.oldGroupComposition.getFeatures());
		//check if the affected features are in the old group. In case of this the 
		if (this.features.containsAll(features)) {
			this.features.removeAll(features);
		} else {
			this.features.addAll(features);
		}
		
		DeleteGroupComposition deleteOldComposition = new DeleteGroupComposition(oldGroupComposition, timestamp);
		AddGroupComposition addNewComposition = new AddGroupComposition(group, this.features, timestamp);
		newGroupComposition = addNewComposition.getGroupComposition();
		
		//the order of the append is important for the execute, so first delete then add
		add(deleteOldComposition);
		add(addNewComposition);
		
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	public HyGroupComposition getGroupComposition() {
		return newGroupComposition;
	}
	
	/**
	 * In case of a move out of the group, the affected features are needed
	 * @return
	 */
	public List<HyFeature> getFeatures() {
		return features;
	}
}
