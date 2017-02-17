package eu.hyvar.feature.graphical.configurator.predicates;

import java.util.function.Predicate;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyVersionSelected;

public class HyConfiguratorElementHasVersionPredicate<HyConfigurationElement> implements Predicate<HyConfigurationElement> {
	public HyVersion version;
	
	@Override
	public boolean test(HyConfigurationElement configuration) {
		if(configuration instanceof HyVersionSelected) {
			HyVersionSelected versionSelected = (HyVersionSelected) configuration;
			if(EcoreUtil.equals(versionSelected.getSelectedVersion(), version)) {
				return true;
			}
		}
		
		return false;
	}  
}
