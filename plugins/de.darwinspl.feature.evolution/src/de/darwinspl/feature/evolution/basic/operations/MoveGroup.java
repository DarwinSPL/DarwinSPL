/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureChild;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;

/**
 * move a whole group.
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
				break;
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
		//check if the execute method was executed, otherwise leave this method
		if (newFeatureChild == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		oldFeatureChild = null;
		newFeatureChild = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}

	}
	
	//Getter
	public HyGroup getGroup() {
		return group;
	}
	public HyFeature getParent() {
		return parent;
	}
	public HyFeatureChild getNewFeatureChild() {
		return newFeatureChild;
	}

}
