/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.basic.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
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
	private EList<HyFeature> features;

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	private HyGroup group = factory.createHyGroup();
	private HyGroupComposition groupComposition;
	
	public AddGroup(HyGroupTypeEnum type, HyFeature parent, EList<HyFeature> features, Date timestamp, HyFeatureModel tfm) {
		
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
	
	//Getters
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}
	
	public HyGroup getGroup() {
		return group;
	}
	public HyFeature getParent() {
		return parent;
	}


}
