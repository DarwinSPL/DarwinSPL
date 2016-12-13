package de.darwinspl.importer;

import java.util.List;
import java.util.Map;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public interface DarwinSPLConstraintsImporter <T,R,S> {

	public HyConstraintModel importConstraints(HyFeatureModel featureModel, Map<R, HyFeature> featureMapping, T originalFeatureModel, List<S> constraints);
	
}
