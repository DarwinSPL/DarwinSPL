/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.atomic.operations.AddGroup;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroup;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 * Move a feature from a group which will have no features in his composition after the evolution, under a feature where no group exists or fit.
 */
public class MoveFeatureDeleteAndAddGroup extends ComplexOperation {

	private HyFeature feature, parent;
	private HyGroup oldGroup, newGroup;
	
	/**
	 * 
	 * @param feature which should be move
	 * @param group which should be delete
	 * @param parent of the new group
	 * @param timestamp
	 * @param tfm
	 */
	public MoveFeatureDeleteAndAddGroup(HyFeature feature, HyGroup group, HyFeature parent, Date timestamp, HyFeatureModel tfm) {
		
		this.feature = feature;
		this.parent = parent;
		this.oldGroup = group;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		DeleteGroup deleteGroup = new DeleteGroup(oldGroup, timestamp);
		
		EList<HyFeature> features = new BasicEList<HyFeature>();
		features.add(feature);
		//add a new group for the feature und the parent. The group type must be AND because at this point the group will only have one feature in his composition
		AddGroup addGroup = new AddGroup(HyGroupTypeEnum.AND, parent, features, timestamp, tfm);
		
		addToComposition(deleteGroup);
		addToComposition(addGroup);
		
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		this.newGroup = addGroup.getGroup();

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

	public HyFeature getParent() {
		return parent;
	}

	public HyGroup getOldGroup() {
		return oldGroup;
	}

	public HyGroup getNewGroup() {
		return newGroup;
	}

}
