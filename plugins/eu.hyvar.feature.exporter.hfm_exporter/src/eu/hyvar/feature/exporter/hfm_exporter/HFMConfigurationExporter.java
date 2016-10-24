package eu.hyvar.feature.exporter.hfm_exporter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.DEVersion;
import org.deltaecore.feature.configuration.DEConfiguration;
import org.deltaecore.feature.configuration.DEConfigurationFactory;
import org.deltaecore.feature.configuration.DEFeatureSelection;
import org.deltaecore.feature.configuration.DEVersionSelection;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.feature.configuration.util.HyConfigurationCompleter;
import eu.hyvar.feature.configuration.util.HyConfigurationWellFormednessException;

public class HFMConfigurationExporter {

	private Map<HyFeature, DEFeature> featureMapping;
	private Map<HyVersion, DEVersion> versionMapping;
//	private HyFeatureModel hyFeatureModel;
	private DEFeatureModel deFeatureModel;
	
	public HFMConfigurationExporter(Map<HyFeature, DEFeature> featureMapping, Map<HyVersion, DEVersion> versionMapping, HyFeatureModel hyFeatureModel, DEFeatureModel deFeatureModel) {
		this.featureMapping = featureMapping;
		this.versionMapping = versionMapping;
		this.deFeatureModel = deFeatureModel;
//		this.hyFeatureModel = hyFeatureModel;
	}
	
	public DEConfiguration exportConfiguration(HyConfiguration configuration, Date date) {
		try {
			HyConfiguration completedConfiguration = HyConfigurationCompleter.completeConfiguration(configuration, date);
			
			DEConfiguration deConfiguration = DEConfigurationFactory.eINSTANCE.createDEConfiguration();
			
			List<HyConfigurationElement> validConfigEles = HyEvolutionUtil.getValidTemporalElements(completedConfiguration.getElements(), date);
			
			for(HyConfigurationElement configurationElement: validConfigEles) {
				if(configurationElement instanceof HyFeatureSelected) {
					
					HyFeatureSelected hyFeatureSelected = (HyFeatureSelected) configurationElement;
					
					DEFeatureSelection deFeatureSelection = DEConfigurationFactory.eINSTANCE.createDEFeatureSelection();
					deFeatureSelection.setFeature(featureMapping.get(hyFeatureSelected.getSelectedFeature()));
					
					deConfiguration.getConfigurationArtifacts().add(deFeatureSelection);
					
				} else if(configurationElement instanceof HyVersionSelected) {
					
					HyVersionSelected hyVersionSelected =(HyVersionSelected) configurationElement;
					HyVersion selectedHyVersion = hyVersionSelected.getSelectedVersion();
					HyFeature respectiveHyFeature = selectedHyVersion.getFeature();
					
					DEVersionSelection deVersionSelection = DEConfigurationFactory.eINSTANCE.createDEVersionSelection();
					deVersionSelection.setVersion(versionMapping.get(selectedHyVersion));
					deVersionSelection.setFeature(featureMapping.get(respectiveHyFeature));
					
					deConfiguration.getConfigurationArtifacts().add(deVersionSelection);
				}
			}
			
			deConfiguration.setFeatureModel(deFeatureModel);
			
			return deConfiguration;
			
		} catch (HyConfigurationWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
