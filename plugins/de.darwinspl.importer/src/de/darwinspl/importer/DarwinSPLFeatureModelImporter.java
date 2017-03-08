package de.darwinspl.importer;

import org.eclipse.core.resources.IFile;

import eu.hyvar.feature.HyFeatureModel;

public interface DarwinSPLFeatureModelImporter<T> {

	public HyFeatureModel importFeatureModel(T featureModel);
	public HyFeatureModel importFeatureModel(String pathToFile);
	public HyFeatureModel importFeatureModel(IFile file);
	
}
