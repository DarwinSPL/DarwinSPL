/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureChild;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;

/**
 *
 */
public class MoveGroup extends ComplexOperation {

	private HyGroup group;
	private HyFeature parent;
	
	private HyFeatureChild oldFeatureChild, newFeatureChild;
	
	public MoveGroup(HyGroup group, HyFeature parent, Date timestamp) {
		
		this.group = group;
		this.parent = parent;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the valid feature child of the group
		for (HyFeatureChild featureChild : group.getChildOf()) {
			if (featureChild.getValidUntil() == null) {
				this.oldFeatureChild = featureChild;
			}
		}
		
		DeleteFeatureChild deleteFeatureChild = new DeleteFeatureChild(oldFeatureChild, timestamp);
		AddFeatureChild addFeatureChild = new AddFeatureChild(parent, group, timestamp);
		
		addToComposition(deleteFeatureChild);
		addToComposition(addFeatureChild);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		this.newFeatureChild = addFeatureChild.getFeatureChild();

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	//Getter
	public HyGroup getGroup() {
		return group;
	}
	public HyFeature getParent() {
		return parent;
	}
	public HyFeatureChild getOldFeatureChild() {
		return oldFeatureChild;
	}
	public HyFeatureChild getNewFeatureChild() {
		return newFeatureChild;
	}

}
