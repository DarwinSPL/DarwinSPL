package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;

public class DwConfigurationExporter {

	private Map<HyFeature, String> featureReconfiguratorIdMapping;
	private Map<HyVersion, String> versionReconfiguratorIdMapping;
	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;
	
	public DwConfigurationExporter(Map<HyFeature, String> featureReconfiguratorIdMapping, Map<HyVersion, String> versionReconfiguratorIdMapping, Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping) {
		this.featureReconfiguratorIdMapping = featureReconfiguratorIdMapping;
		this.versionReconfiguratorIdMapping = versionReconfiguratorIdMapping;
		this.attributeReconfiguratorIdMapping = attributeReconfiguratorIdMapping;
	}
	

	public List<String> getSelectedFeatureIds(HyConfiguration oldConfiguration) {
		List<String> initialFeatureIds = new ArrayList<String>();

		for (HyConfigurationElement configurationElement : oldConfiguration.getElements()) {
			if (configurationElement instanceof HyFeatureSelected) {
				// Add selected features

				initialFeatureIds.add(featureReconfiguratorIdMapping
						.get(((HyFeatureSelected) configurationElement).getSelectedFeature()));

			} else if (configurationElement instanceof HyVersionSelected) {
				initialFeatureIds.add(versionReconfiguratorIdMapping
						.get(((HyVersionSelected) configurationElement).getSelectedVersion()));
			}
		}

		return initialFeatureIds;
	}

	/**
	 * TODO working?
	 * 
	 * @param oldConfiguration
	 * @return Map where key is attribute[attributeID] and value is value
	 *         assignment
	 */
	public List<eu.hyvar.reconfigurator.input.format.AttributeValue> getFeatureAttributeValues(
			HyConfiguration oldConfiguration) {
		List<eu.hyvar.reconfigurator.input.format.AttributeValue> exportedAttributeValues = new ArrayList<eu.hyvar.reconfigurator.input.format.AttributeValue>();

		// Check if configuration element is attribute value
		for (HyConfigurationElement configEle : oldConfiguration.getElements()) {
			if (configEle instanceof HyAttributeValueAssignment) {
				HyAttributeValueAssignment hyAttributeValueAssignment = (HyAttributeValueAssignment) configEle;
				// Fill the map with the attribute and the corresponding value
				Integer intValue = 0;
				HyValue value = hyAttributeValueAssignment.getValue();
				HyFeatureAttribute attribute = hyAttributeValueAssignment.getAttribute();

				if (value == null) {
					// default values
					if (attribute instanceof HyNumberAttribute) {
						intValue = ((HyNumberAttribute) attribute).getDefault();
					} else if (attribute instanceof HyEnumAttribute) {
						HyEnumAttribute enumAttribute = (HyEnumAttribute) attribute;
						intValue = enumAttribute.getDefault().getValue();
					} else if (attribute instanceof HyBooleanAttribute) {
						if (((HyBooleanAttribute) attribute).isDefault()) {
							intValue = 1;
						} else {
							intValue = 0;
						}
					} else {
						intValue = 0;
						System.err.println("Unsupported Attribute Type");
					}
				} else {
					if (value instanceof HyNumberValue) {
						intValue = ((HyNumberValue) value).getValue();
					} else if (value instanceof HyEnumValue) {
						intValue = ((HyEnumValue) value).getEnumLiteral().getValue();
					} else if (value instanceof HyBooleanValue) {
						if (((HyBooleanValue) value).isValue()) {
							intValue = 1;
						} else {
							intValue = 0;
						}
					} else {
						intValue = 0;
						System.err.println("Unsupported HyValue");
					}
				}

				eu.hyvar.reconfigurator.input.format.AttributeValue exportedAttributeValue = new eu.hyvar.reconfigurator.input.format.AttributeValue();
				exportedAttributeValue.setId(attributeReconfiguratorIdMapping.get(attribute));
				exportedAttributeValue.setValue(intValue);

				exportedAttributeValues.add(exportedAttributeValue);
			}
		}

		return exportedAttributeValues;
	}
}
