/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;

/**
 *
 */
public class AddFeatureChild implements EvolutionOperation {

	private HyFeature parent;
	private HyGroup group;
	private Date timestamp;
	
	private HyFeatureChild featureChild;
	
	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddFeatureChild(HyFeature parent, HyGroup group, Date timestamp) {

		this.parent = parent;
		this.group = group;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {

		featureChild = factory.createHyFeatureChild();
		featureChild.setParent(parent);
		featureChild.setChildGroup(group);
		featureChild.setValidSince(timestamp);
		featureChild.setValidUntil(null);

		//parent.getParentOf().add(featureChild);
		
		//group.getChildOf().add(featureChild);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	//Getter
	public HyFeature getParent() {
		return parent;
	}
	public HyGroup getGroup() {
		return group;
	}
	public HyFeatureChild getFeatureChild() {
		return featureChild;
	}

}
