package de.darwinspl.configuration.generator;

import java.util.Date;
import java.util.List;
import java.util.Random;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DarwinConfigurationGenerator {

	// TODO Yet very simple and not very good! Currently only regarding FM structure. Even for big FMs, configurations are rather small. Descending probability based on tree level?
	// TODO incorporate versions
	// TODO incorporate attributes
	// TODO incorporate constraints
	
	private Random rand;
	private HyConfigurationFactory factory;
	
	public HyConfiguration generateConfiguration(HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		rand = new Random();
		
		factory = HyConfigurationFactory.eINSTANCE;
		
		HyConfiguration configuration = factory.createHyConfiguration();
		configuration.setFeatureModel(featureModel);
		
		HyFeature rootFeature = HyFeatureEvolutionUtil.getRootFeature(featureModel, date);
		addFeatureSelectionAndProcessSubtree(rootFeature, configuration, date);
		
		return configuration;
	}
	
	
	protected void processSubTree(HyFeature parent, HyConfiguration configuration, Date date) {
		for(HyGroup group: HyFeatureEvolutionUtil.getChildsOfFeature(parent, date)) {
			List<HyFeature> featureList = HyFeatureEvolutionUtil.getFeaturesOfGroup(group, date);
			if(featureList.size()<=0) {
				continue;
			}
			
			switch(HyFeatureEvolutionUtil.getType(group, date).getType()) {
			case ALTERNATIVE:
				processAlternativeGroup(featureList, configuration, date);
				break;
			case AND:
				processAndGroup(featureList, configuration, date);
				break;
			case OR:
				processOrGroup(featureList, configuration, date);
				break;				
			}
		}
	}
	
	protected void processAlternativeGroup(List<HyFeature> featuresOfGroup, HyConfiguration configuration, Date date) {
		int index = rand.nextInt(featuresOfGroup.size());
		
		addFeatureSelectionAndProcessSubtree(featuresOfGroup.get(index), configuration, date);
	}
	
	protected void processOrGroup(List<HyFeature> featuresOfGroup,HyConfiguration configuration, Date date) {
		int selectedFeatures = 0;
		
		while(selectedFeatures == 0) {
			for(HyFeature feature: featuresOfGroup) {
				if(rand.nextBoolean()) {
					selectedFeatures++;
					addFeatureSelectionAndProcessSubtree(feature, configuration, date);
				}
			}
		}
	}
	
	protected void processAndGroup(List<HyFeature> featuresOfGroup,HyConfiguration configuration, Date date) {
		for(HyFeature feature: featuresOfGroup) {
			switch (HyFeatureEvolutionUtil.getType(feature, date).getType()) {
			case MANDATORY:
				addFeatureSelectionAndProcessSubtree(feature, configuration, date);
				break;
			case OPTIONAL:
				if(rand.nextBoolean()) {
					addFeatureSelectionAndProcessSubtree(feature, configuration, date);
				}
				break;			
			}
		}
	}
	
	protected void addFeatureSelectionAndProcessSubtree(HyFeature feature, HyConfiguration configuration, Date date) {
		HyFeatureSelected featureSelected = factory.createHyFeatureSelected();
		
		// TODO sensible valid until?!
		featureSelected.setValidSince(date);
		featureSelected.setSelectedFeature(feature);
		configuration.getElements().add(featureSelected);
		
		processSubTree(feature, configuration, date);
	}
}
