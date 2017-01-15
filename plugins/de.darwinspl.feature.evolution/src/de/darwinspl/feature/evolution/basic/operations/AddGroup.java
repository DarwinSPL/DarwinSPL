/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class AddGroup extends ComplexOperation {

	private HyGroupTypeEnum type;
	private HyFeature parent;
	private List<HyFeature> features;

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	private HyGroup group = factory.createHyGroup();
	private HyGroupComposition groupComposition;
	
	public AddGroup(HyGroupTypeEnum type, HyFeature parent, List<HyFeature> features, Date timestamp, HyFeatureModel tfm) {
		
		this.type = type;
		this.parent = parent;
		this.features.addAll(features);
		this.timestamp = timestamp;
		this.tfm = tfm;
		
		AddGroupType groupType = new AddGroupType(type, group, timestamp);
		AddFeatureChild featureChild = new AddFeatureChild(parent, group, timestamp);
		AddGroupComposition groupComposition = new AddGroupComposition(group, features, timestamp);
		
		add(groupType);
		add(featureChild);
		add(groupComposition);
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		//execute each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		group.setValidSince(timestamp);
		group.setValidUntil(null);
		
		tfm.getGroups().add(group);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * This method is needed, to build the relation between the feature and the groupComposition
	 * @return
	 */
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}


}
