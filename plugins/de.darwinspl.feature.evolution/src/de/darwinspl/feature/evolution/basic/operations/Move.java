/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.complex.operations.AddGroupWithTypeChildAndComposition;
import de.darwinspl.feature.evolution.complex.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.complex.operations.DeleteGroupWithTypeChildAndComposition;
import de.darwinspl.feature.evolution.complex.operations.RemoveFromGroupComposition;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class Move extends ComplexOperation {

	private HyFeature feature, parent;
	private HyGroup group;
	private HyGroupComposition oldGroupCompositionBefore, newGroupCompositionBefore;	//group composition before the evolution
	
	/**
	 * 
	 * @param feature which should be move
	 * @param parent new parent of the feature which should be move
	 * @param group is necessary in case of more than one group exists under the parent. So only the parent feature wouldn't enough for the move operation
	 * @param timestamp
	 * @param tfm
	 */
	public Move(HyFeature feature, HyFeature parent, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		this.feature = feature;
		this.parent = parent;
		this.group = group;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		
		for (HyGroupComposition membership : feature.getGroupMembership()) {
			if (membership.getValidUntil() == null) {
				oldGroupCompositionBefore = membership;
				break;
			}
		}
		//check if the feature which should be move is the only feature of the old group composition
		if (oldGroupCompositionBefore.getFeatures().size() == 1) {
			//delete old group
			DeleteGroupWithTypeChildAndComposition deleteGroup = new DeleteGroupWithTypeChildAndComposition(oldGroupCompositionBefore.getCompositionOf(), timestamp);
			addToComposition(deleteGroup);
			
		} else {
			//remove the feature from his current membership
			RemoveFromGroupComposition removeFromGroupComposition = new RemoveFromGroupComposition(oldGroupCompositionBefore, feature, timestamp);
			addToComposition(removeFromGroupComposition);
			
		}
		
		//check if a targeting group was selected, otherwise a new group must be create.
		if (group == null) {
			
			EList<HyFeature> features = new BasicEList<HyFeature>();
			features.add(feature);
			
			//create a new AND-group for the feature under the parent
			AddGroupWithTypeChildAndComposition addGroup = new AddGroupWithTypeChildAndComposition(HyGroupTypeEnum.AND, parent, features, timestamp, tfm);
			addToComposition(addGroup);
			
		} else {
			
			for (HyGroupComposition composition : group.getParentOf()) {
				if (composition.getValidUntil() == null) {
					newGroupCompositionBefore = composition;
				}
			}
			
			//add the feature to the new group composition
			AddToGroupComposition addToGroupComposition = new AddToGroupComposition(newGroupCompositionBefore, feature, timestamp);
			addToComposition(addToGroupComposition);
			
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		if (oldGroupCompositionBefore == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		if (newGroupCompositionBefore != null) {
			newGroupCompositionBefore = null;
		}

	}
	
	//Getters
	public HyFeature getFeature() {
		return feature;
	}
	public HyFeature getParent() {
		return parent;
	}
	public HyGroup getGroup() {
		return group;
	}
	public HyGroupComposition getOldGroupCompositionBefore() {
		return oldGroupCompositionBefore;
	}
	public HyGroupComposition getNewGroupCompositionBefore() {
		return newGroupCompositionBefore;
	}

}
