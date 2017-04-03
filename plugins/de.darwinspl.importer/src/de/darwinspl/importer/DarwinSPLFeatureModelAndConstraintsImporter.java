package de.darwinspl.importer;

import org.eclipse.core.resources.IFile;

public interface DarwinSPLFeatureModelAndConstraintsImporter<T> {

	public FeatureModelConstraintsTuple importFeatureModel(T featureModel);
	public FeatureModelConstraintsTuple importFeatureModel(String pathToFile);
	public FeatureModelConstraintsTuple importFeatureModel(IFile file);
	
}
