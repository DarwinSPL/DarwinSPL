package de.darwinspl.importer;

import eu.hyvar.feature.HyFeatureModel;

public interface DarwinSPLFeatureModelImporter<T> {

	public HyFeatureModel importFeatureModel(T featureModel);
	
}
