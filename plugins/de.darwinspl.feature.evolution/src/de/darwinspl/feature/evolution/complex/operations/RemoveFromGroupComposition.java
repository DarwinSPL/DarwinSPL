/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupComposition;
import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
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
		// TODO Auto-generated method stub

	}

	public HyGroupComposition getGroupComposition() {
		return newGroupComposition;
	}
	
	/**
	 * In case of a move out of the group, the affected features are needed
	 * @return
	 */
	public HyFeature getRemovedFeature() {
		return feature;
	}
}
