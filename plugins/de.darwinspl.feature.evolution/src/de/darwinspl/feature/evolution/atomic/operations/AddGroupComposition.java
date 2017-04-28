/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

/**
 * atomic operation which add a group compositionfor a group to a tfm
 */
public class AddGroupComposition extends EvolutionOperation {

	private HyGroup group;
	private EList<HyFeature> features = new BasicEList<HyFeature>();
	private HyGroupComposition groupComposition;
	
	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddGroupComposition(HyGroup group, EList<HyFeature> features, Date timestamp) {
		
		this.group = group;
		//this.features.addAll(features);
		for (HyFeature hyFeature : features) {
			if (hyFeature != null) {
				this.features.add(hyFeature);
			}
			
		}
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
		
		//group.getParentOf().add(groupComposition);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (groupComposition == null) {
			return;
		}
		group.getParentOf().remove(groupComposition);
		groupComposition = null;
	}
	
	//Getter
	public HyGroupComposition getGroupComposition() {
		return groupComposition;
	}

}
