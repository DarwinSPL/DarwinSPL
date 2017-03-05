/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.AddGroup;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 * Add a new group with type, feature child and group composition
 */
public class AddGroupWithTypeChildAndComposition extends ComplexOperation {

	private HyGroupTypeEnum type;
	private HyFeature parent;
	private EList<HyFeature> features;

	private HyGroup group;
	private HyGroupComposition groupComposition;
	private HyGroupType groupType;
	private HyFeatureChild featureChild;
	
	private HyFeatureModel tfm;
	
	public AddGroupWithTypeChildAndComposition(HyGroupTypeEnum type, HyFeature parent, EList<HyFeature> features, Date timestamp, HyFeatureModel tfm) {
		
		this.type = type;
		this.parent = parent;
		this.features = new BasicEList<HyFeature>();
		this.features.addAll(features);
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		AddGroup addGroup = new AddGroup(timestamp, tfm);
		//The add group atomic op must be execute, because the next operations are need the group which will be create. 
		addGroup.execute();
		group = addGroup.getGroup();
		
		AddGroupType groupType = new AddGroupType(type, group, timestamp);
		AddFeatureChild featureChild = new AddFeatureChild(parent, group, timestamp);
		AddGroupComposition groupComposition = new AddGroupComposition(group, features, timestamp);
		
		addToComposition(groupType);
		addToComposition(featureChild);
		addToComposition(groupComposition);
		
		//execute each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		this.groupType = groupType.getGroupTyp();
		this.featureChild = featureChild.getFeatureChild();
		this.groupComposition = groupComposition.getGroupComposition();
		
		addToComposition(addGroup);
		

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (group == null) {
			return;
		}

		//undo each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		groupType = null;
		featureChild = null;
		groupComposition = null;
		group = null;		

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	//Getters
	public HyGroup getGroup() {
		return group;
	}
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}
	
	public HyGroupType getGroupType() {
		return groupType;
	}
	public HyFeatureChild getFeatureChild() {
		return featureChild;
	}


}
