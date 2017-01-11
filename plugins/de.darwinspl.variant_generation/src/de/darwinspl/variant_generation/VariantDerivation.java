package de.darwinspl.variant_generation;

import java.util.Date;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMapping;

public interface VariantDerivation {

	VariantDerivation eINSTANCE = de.darwinspl.variant_generation.impl.VariantDerivationImpl.init();
	
	public void deriveVariant(HyFeatureModel featureModel, HyConfiguration configuration, HyMapping mapping, Date date) throws VariantDerivationFailedException;
	
	public void deriveVariant(HyFeatureModel featureModel, HyConstraintModel constraints, HyConfiguration configuration, HyMapping mapping, Date date) throws VariantDerivationFailedException;
	
	public void deriveVariant(HyFeatureModel featureModel, HyConfiguration configuration, Date date) throws VariantDerivationFailedException;
	
	public void deriveVariant(HyFeatureModel featureModel, HyConstraintModel constraints, HyConfiguration configuration, Date date) throws VariantDerivationFailedException;
	
	public void deriveVariant(HyConfiguration configuration, Date date) throws VariantDerivationFailedException;
}
