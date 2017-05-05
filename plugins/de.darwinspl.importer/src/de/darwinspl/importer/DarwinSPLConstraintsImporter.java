package de.darwinspl.importer;

import java.util.List;
import java.util.Map;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

/**
 * 
 * @author Michael Nieke
 *
 * @param <T> Type of source Feature Model
 * @param <R> Type of features of source feature model
 * @param <S> Type of constraints of source model
 */
public interface DarwinSPLConstraintsImporter <T,R,S> {

	public HyConstraintModel importConstraints(HyFeatureModel featureModel, Map<R, HyFeature> featureMapping, T originalFeatureModel, List<S> constraints);
	
}
