package de.darwinspl.importer.evolution;

import eu.hyvar.feature.HyFeatureModel;

public class DwTemporalFeatureModelEvolutionImporter extends DwFeatureModelEvolutionImporter<HyFeatureModel> {

	@Override
	protected HyFeatureModel importFeatureModel(HyFeatureModel featureModel) {
		return featureModel;
	}

}
