package eu.hyvar.feature.example_creation.examples;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.context.contextValidity.HyValidityModel;

public abstract class HyFMExample {

	protected HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public abstract HyFeatureModel createExample();
	
	public abstract HyMappingModel createMappingModel();
	
	public abstract HyConstraintModel createConstraintModel();
	
	public abstract HyContextModel createContextModel();
	
	public abstract HyValidityModel createValidityModel();
	
	public abstract HyPreferenceModel createPreferenceModel();
	
	public abstract HyConfiguration createConfiguration();
}
