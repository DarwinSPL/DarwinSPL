package eu.hyvar.feature.graphical.configurator.predicates;

import java.util.function.Predicate;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.configuration.HyFeatureSelected;

public class HyConfiguratorElementHasFeaturePredicate<HyConfigurationElement> implements Predicate<HyConfigurationElement> {
	public HyFeature feature;

	@Override
	public boolean test(HyConfigurationElement configuration) {
		if(configuration instanceof HyFeatureSelected){
			HyFeatureSelected featureSelected = (HyFeatureSelected) configuration;
			
			if(EcoreUtil.equals(featureSelected.getSelectedFeature(), feature)) {
				return true;
			}
		}
		
		return false;
	}  
}
