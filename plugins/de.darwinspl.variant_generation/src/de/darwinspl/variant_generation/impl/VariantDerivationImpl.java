package de.darwinspl.variant_generation.impl;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.variant_generation.VariantDerivation;
import de.darwinspl.variant_generation.VariantDerivationFailedException;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
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
		
		if(configuration==null) {
			throw new VariantDerivationFailedException("Configuration was null. Cannot derive variant!");
		}
		
		if(featureModel == null) {
			EObject potentialFeatureModel = EcoreIOUtil.loadAccompanyingModel(configuration, "", HyFeatureResolverUtil.FILE_EXTENSIONS);
			if(potentialFeatureModel == null || !(potentialFeatureModel instanceof HyFeatureModel))  {
				throw new VariantDerivationFailedException("No Feature Model found!");
			}
			
			featureModel = (HyFeatureModel) potentialFeatureModel;
		}
		
		if(constraints == null) {
			EObject potentialConstraintModel = EcoreIOUtil.loadAccompanyingModel(configuration, "", HyConstraintUtil.CONSTRAINT_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX);
			if(potentialConstraintModel == null) {
				potentialConstraintModel = EcoreIOUtil.loadAccompanyingModel(configuration, "", HyConstraintUtil.CONSTRAINT_MODEL_FILE_EXTENSION_FOR_XMI);
			}
			if(potentialConstraintModel==null || !(potentialConstraintModel instanceof HyConstraintModel)) {
				// TODO logging
			} 
			
			constraints = (HyConstraintModel) potentialConstraintModel;
		}
		
		// get Mapping
		
		// Check if config respects FM structure and Constraint (valid at @date)
		
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
