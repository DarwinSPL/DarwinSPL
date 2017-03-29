package de.darwinspl.configuration.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import de.darwinspl.feature.analyses.DwSatisfiabilityChecker;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyFeatureSelection;
import eu.hyvar.feature.configuration.util.HyConfigurationCompleter;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.configuration.util.HyConfigurationWellFormednessException;
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
		HyConfigurationUtil.selectFeature(rootFeature, configuration, date);
		
		List<HyFeature> possibleFeatures = new ArrayList<HyFeature>(HyFeatureEvolutionUtil.getFeatures(featureModel, date).size());
		possibleFeatures.addAll(HyFeatureEvolutionUtil.getFeatures(featureModel, date));
		possibleFeatures.remove(rootFeature);
		
		try {
			configuration = HyConfigurationCompleter.completeConfiguration(configuration, date);
		} catch (HyConfigurationWellFormednessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		removeFeaturesOfPossibleSelections(possibleFeatures, configuration);
		
		DwSatisfiabilityChecker satChecker = new DwSatisfiabilityChecker();
		
		
		// TODO dead end possible?
		while(possibleFeatures.size()>0) {
			HyFeatureSelection selection = null;
			
			// select random feature
			int index = rand.nextInt(possibleFeatures.size());		
			HyFeature feature = possibleFeatures.get(index);
			
			// randomly decide about selection / deselection
			int selected = rand.nextInt(2);
			
			boolean deselected = false;
			
			if(selected == 0) {
				// not selected
				deselected = true;
				selection = HyConfigurationUtil.deselectFeature(feature, configuration, date);
			} else {			
				// selected
				selection = HyConfigurationUtil.selectFeature(feature, configuration, date);
			}
			
			boolean wasSat = true;
			
			if(!satChecker.isSatisfiable(configuration, constraintModel, date)) {
				wasSat = false;
				configuration.getElements().remove(selection);
				
				if(deselected) {
					wasSat = true;
					deselected = false;
					
					selection = factory.createHyFeatureSelected();
					
					selection.setSelectedFeature(feature);
					
					configuration.getElements().add(selection);
				} else {
					deselected = true;
					
					selection = factory.createHyFeatureDeselected();
					
					selection.setSelectedFeature(feature);
					
					configuration.getElements().add(selection);
				}
			}
			
			if(wasSat && selection instanceof HyFeatureSelected) {
				try {
					configuration = HyConfigurationCompleter.completeConfiguration(configuration, date);
				} catch (HyConfigurationWellFormednessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// remove all newly selected / deselected features from set of possible configurations
			removeFeaturesOfPossibleSelections(possibleFeatures, configuration);
//			possibleFeatures.remove(index);
		}
		
		
		return configuration;
	}
	
	protected void removeFeaturesOfPossibleSelections(List<HyFeature> possibleFeature, HyConfiguration configuration) {
		for(HyConfigurationElement configEle: configuration.getElements()) {
			if(configEle instanceof HyFeatureSelection) {
				possibleFeature.remove(((HyFeatureSelection)configEle).getSelectedFeature());
			}
		}
	}
}
