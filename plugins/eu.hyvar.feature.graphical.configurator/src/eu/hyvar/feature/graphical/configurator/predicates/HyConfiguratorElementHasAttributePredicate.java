package eu.hyvar.feature.graphical.configurator.predicates;

import java.util.function.Predicate;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;

public class HyConfiguratorElementHasAttributePredicate<HyConfigurationElement> implements Predicate<HyConfigurationElement> {
	public HyFeatureAttribute attribute;
	public HyValue value;

	@Override
	public boolean test(HyConfigurationElement configuration) {
		if(configuration instanceof HyAttributeValueAssignment){
			HyAttributeValueAssignment attributeValueAssignment = (HyAttributeValueAssignment) configuration;
			if(EcoreUtil.equals(attributeValueAssignment.getAttribute(), attribute) && EcoreUtil.equals(attributeValueAssignment.getValue(), value)) {
				return true;
			}
		}

		return false;
	}  
}
