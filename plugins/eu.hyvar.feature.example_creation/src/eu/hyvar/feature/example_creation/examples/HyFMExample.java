package eu.hyvar.feature.example_creation.examples;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.context.contextValidity.HyValidityModel;

public abstract class HyFMExample {

	protected HyFeatureFactory factory = HyFeatureFactoryWithIds.eINSTANCE;
	
	public abstract HyFeatureModel createExample();
	
	public abstract HyMappingModel createMappingModel();
	
	public abstract HyConstraintModel createConstraintModel();
	
	public abstract HyContextModel createContextModel();
	
	public abstract HyValidityModel createValidityModel();
	
	public abstract HyProfile createPreferenceModel();
	
	public abstract HyConfiguration createConfiguration();
}
