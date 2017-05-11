package eu.hyvar.feature.configuration.util;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;

public class HyConfigurationCompleter {

	
	/**
	 * Completes the configuration (versions selected, features not). No new configuration is created! Elements added!
	 * @param configuration
	 * @param date
	 * @return
	 * @throws HyConfigurationWellFormednessException
	 */
	public static HyConfiguration completeConfiguration(HyConfiguration configuration, Date date) throws HyConfigurationWellFormednessException {
		// TODO add default version for features?
		HyConfigurationChecker configurationChecker = new HyConfigurationChecker();
		
		if(configurationChecker.isValid(configuration, date)) {
			
			Set<HyFeature> selectedFeatures = new HashSet<HyFeature>();
			Set<HyFeature> requiredFeatures = new HashSet<HyFeature>();
			
			List<HyConfigurationElement> validConnfigurationArtifacts = HyEvolutionUtil.getValidTemporalElements(configuration.getElements(), date);
			
			for (HyConfigurationElement configurationArtifact : validConnfigurationArtifacts) {
				if (configurationArtifact instanceof HyFeatureSelected) {
					HyFeatureSelected featureSelection = (HyFeatureSelected) configurationArtifact;
					HyFeature feature = featureSelection.getSelectedFeature();
					selectedFeatures.add(feature);
				}
				
				if (configurationArtifact instanceof HyVersionSelected) {
					HyVersionSelected versionSelection = (HyVersionSelected) configurationArtifact;
					HyVersion version = versionSelection.getSelectedVersion();
					HyFeature feature = version.getFeature();
					requiredFeatures.add(feature);
				}
			}
			
			Set<HyFeature> missingFeatures = new HashSet<HyFeature>();
			missingFeatures.addAll(requiredFeatures);
			missingFeatures.removeAll(selectedFeatures);
			
//			HyConfiguration completedConfiguration = EcoreUtil.copy(configuration);
//			List<HyConfigurationElement> completedConfigurationArtifacts = completedConfiguration.getElements();
			
			for (HyFeature missingFeature : missingFeatures) {
				HyFeatureSelected featureSelection = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
				featureSelection.setSelectedFeature(missingFeature);
				configuration.getElements().add(featureSelection);
			}
			
			return configuration;
		} else {
			throw new HyConfigurationWellFormednessException("Configuration is not valid");
		}
		
		
		
	}
	
}
