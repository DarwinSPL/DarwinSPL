/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 *
 */
public class AddGroupComposition implements EvolutionOperation {

	private HyGroup group;
	private List<HyFeature> features;
	private Date timestamp;
	
	private HyGroupComposition groupComposition;
	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddGroupComposition(HyGroup group, List<HyFeature> features, Date timestamp) {
		
		this.group = group;
		this.features = features;
		this.timestamp = timestamp;
		
	}
	
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {

		groupComposition = factory.createHyGroupComposition();
		groupComposition.getFeatures().addAll(features);
		groupComposition.setValidSince(timestamp);
		groupComposition.setValidUntil(null);
		groupComposition.setCompositionOf(group);
		
		//TODO: set until in the old groupComposition 
		group.getParentOf().add(groupComposition);

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
