package eu.hyvar.feature.graphical.configurator.output;

import java.util.Date;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;

public interface IHyConfigurationDerivation {
	HyConfiguration getConfiguration();
	
	HyFeatureModel getFeatureModel();
	
	Date getDate();
}
