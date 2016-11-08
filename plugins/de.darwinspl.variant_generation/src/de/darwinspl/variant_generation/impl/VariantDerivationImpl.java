package de.darwinspl.variant_generation.impl;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.variant_generation.VariantDerivation;
import de.darwinspl.variant_generation.VariantDerivationFailedException;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class VariantDerivationImpl implements VariantDerivation {
	
	
	public static VariantDerivation init() {
		return new VariantDerivationImpl();
	}
	
	
	private VariantDerivationImpl() {
		
	}

	@Override
	public void deriveVariant(HyFeatureModel featureModel, HyConstraintModel constraints, HyConfiguration configuration,
			HyMapping mapping, Date date) throws VariantDerivationFailedException {
		
		if(featureModel == null) {
			EObject potentialFeatureModel = EcoreIOUtil.loadAccompanyingModel(configuration, "", HyFeatureResolverUtil.FILE_EXTENSIONS);
			if(potentialFeatureModel == null || !(potentialFeatureModel instanceof HyFeatureModel))  {
				throw new VariantDerivationFailedException("");
			}
		}
		
		
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void deriveVariant(HyFeatureModel featureModel, HyConfiguration configuration, HyMapping mapping,
			Date date) throws VariantDerivationFailedException{
		deriveVariant(featureModel, null, configuration, mapping, date);
	}




	@Override
	public void deriveVariant(HyFeatureModel featureModel, HyConfiguration configuration, Date date) throws VariantDerivationFailedException {
		deriveVariant(featureModel, null, configuration, null, date);
	}


	@Override
	public void deriveVariant(HyFeatureModel featureModel, HyConstraintModel constraints, HyConfiguration configuration,
			Date date) throws VariantDerivationFailedException {
		deriveVariant(featureModel, null, configuration, null, date);		
	}


	@Override
	public void deriveVariant(HyConfiguration configuration, Date date) throws VariantDerivationFailedException {
		deriveVariant(null, null, configuration, null, date);	
	}

}
