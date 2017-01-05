package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;

public class MergeFeatures extends DeleteFeature {

	protected HyFeature source;
	protected HyFeature target;
	protected Date date;
	
	/**
	 * The source feature is merged into the target feature at date @date . Children of source are moved under target
	 * @param source
	 * @param target
	 * @param date
	 */
	public MergeFeatures(HyFeature source, HyFeature target, Date date) {
		super(source, date);
		
		this.source = source;
		this.target = target;
		this.date = date;
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		if(! HyEvolutionUtil.isValid(target, date)) {
			throw new EvolutionOperationException();
		}
		
		
		// Delete source from model
		super.applyOperation();
		
		
		
		// Put old children of source to target
		for(HyFeatureChild featureChild: HyEvolutionUtil.getValidTemporalElements(source.getParentOf(), date)) {
			featureChild.setValidUntil(date);
			
			HyFeatureChild newFeatureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			newFeatureChild.setParent(target);
			newFeatureChild.setChildGroup(featureChild.getChildGroup());
			
			// Repair superseding relation. I hope this is the right direction.
			HyLinearTemporalElement oldSupersedingFeatureChild = featureChild.getSupersedingElement();
			featureChild.setSupersedingElement(newFeatureChild);
			newFeatureChild.setSupersedingElement(oldSupersedingFeatureChild);
		}
		
	}
	
}
