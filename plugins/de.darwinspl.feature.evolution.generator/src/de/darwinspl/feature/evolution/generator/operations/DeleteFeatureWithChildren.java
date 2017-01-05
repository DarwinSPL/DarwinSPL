package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import eu.hyvar.feature.HyFeature;

public class DeleteFeatureWithChildren extends DeleteFeature {

	public DeleteFeatureWithChildren(HyFeature feature, Date date) {
		super(feature, date);
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		
		// Invalidate feature itself
		super.applyOperation();
		
		
	}

	
	// TODO!! what happens if this operation is applied in between of two other operations. Bad things could happen with evolved children or similar
}
