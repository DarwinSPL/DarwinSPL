package de.darwinspl.feature.graphical.configurator.predicates;

import java.util.function.Predicate;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;

public class DwConfiguratorElementHasAttributeNonKnownValuePredicate<HyConfigurationElement> implements Predicate<HyConfigurationElement> {
	public HyFeatureAttribute attribute;


	@Override
	public boolean test(HyConfigurationElement configuration) {
		if(configuration instanceof HyAttributeValueAssignment){
			HyAttributeValueAssignment attributeValueAssignment = (HyAttributeValueAssignment) configuration;
			if(EcoreUtil.equals(attributeValueAssignment.getAttribute(), attribute)) {
				return true;
			}
		}

		return false;
	}  
}