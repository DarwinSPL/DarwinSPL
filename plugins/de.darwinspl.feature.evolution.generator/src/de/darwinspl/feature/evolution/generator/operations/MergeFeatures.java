package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;

public class MergeFeatures implements EvolutionOperation {

	protected HyFeature source;
	protected HyFeature target;
	protected Date date;
	
	protected DeleteFeature deleteFeatureOperation;
	
	/**
	 * The source feature is merged into the target feature at date @date . Children of source are moved under target
	 * @param source
	 * @param target
	 * @param date
	 */
	public MergeFeatures(HyFeature source, HyFeature target, Date date) {
		deleteFeatureOperation = new DeleteFeature(source, date);
		
		this.source = source;
		this.target = target;
		this.date = date;
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		if(! HyEvolutionUtil.isValid(target, date)) {
			throw new EvolutionOperationException();
		}
		
		// Invalidate source in model
		deleteFeatureOperation.applyOperation();		
		
		// Put old children of source to target
		for(HyFeatureChild featureChild: HyEvolutionUtil.getValidTemporalElements(source.getParentOf(), date)) {
			featureChild.setValidUntil((Date)date.clone());
			
			HyFeatureChild newFeatureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			newFeatureChild.setParent(target);
			newFeatureChild.setChildGroup(featureChild.getChildGroup());
			
			newFeatureChild.setSupersededElement(featureChild);
			
		}
		
	}
	
}
