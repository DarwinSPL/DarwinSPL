package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;
import java.util.List;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

public class DeleteFeatureWithChildren extends DeleteFeature {
	
	public DeleteFeatureWithChildren(HyFeature feature, Date date) {
		super(feature, date);
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		
		// Invalidate feature itself
		super.applyOperation();
		
		
		invalidateSubElements(feature);
		
	}

	private void invalidateSubElements(HyFeature feature) {
		
		List<HyFeatureChild> validFeatureChildren = HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), date);
		
		for(HyFeatureChild validFeatureChild: validFeatureChildren) {
			// Invalidate each Feature child which was valid for this group
			for(HyLinearTemporalElement supersedingElement: HyEvolutionUtil.getAllSupersedingElements(validFeatureChild)) {
				invalidateElement(supersedingElement);
			}
			
			invalidateElement(validFeatureChild);
			
			HyGroup childGroup = validFeatureChild.getChildGroup();
			
			if(HyEvolutionUtil.isValid(childGroup, date)) {
				invalidateElement(childGroup);				
			}
			
			List<HyGroupComposition> validGroupCompositions = HyEvolutionUtil.getValidTemporalElements(childGroup.getParentOf(), date);
			for(HyGroupComposition groupComposition: validGroupCompositions) {				
				invalidateElement(groupComposition);
				
				List<HyFeature> validSubFeatures = HyEvolutionUtil.getValidTemporalElements(groupComposition.getFeatures(), date);
				for(HyFeature subFeature: validSubFeatures) {
					invalidateElement(subFeature);
					invalidateSubElements(subFeature);
				}
			}
			
		}
		
		
	}
	
	private void invalidateElement(HyTemporalElement element) {
		if(element.getValidSince().after(date)) {
			element.setValidSince(date);
		}
		element.setValidUntil(date);
	}
	
	
	// TODO!! what happens if this operation is applied in between of two other operations. Bad things could happen with evolved children or similar
}
