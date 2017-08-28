package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
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
	private Map<HyContextualInformation, String> contextReconfiguratorIdMapping;
	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;
	
	public DwConfigurationExporter(Map<HyFeature, String> featureReconfiguratorIdMapping, Map<HyVersion, String> versionReconfiguratorIdMapping, Map<HyContextualInformation, String> contextReconfiguratorIdMapping, Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping) {
		this.featureReconfiguratorIdMapping = featureReconfiguratorIdMapping;
		this.versionReconfiguratorIdMapping = versionReconfiguratorIdMapping;
		this.contextReconfiguratorIdMapping = contextReconfiguratorIdMapping;
		this.attributeReconfiguratorIdMapping = attributeReconfiguratorIdMapping;
	}

	public eu.hyvar.reconfigurator.input.format.Configuration getExportedConfiguration(
			HyConfiguration oldConfiguration, List<HyContextValueModel> contextValueModels) {
		eu.hyvar.reconfigurator.input.format.Configuration exportedConfiguration = new eu.hyvar.reconfigurator.input.format.Configuration();

		if (oldConfiguration != null) {
			exportedConfiguration.setSelectedFeatures(getSelectedFeatureIds(oldConfiguration));
			exportedConfiguration.setAttributeValues(getFeatureAttributeValues(oldConfiguration));
		}

		if (contextValueModels != null) {
			exportedConfiguration.setContextValues(new ArrayList<eu.hyvar.reconfigurator.input.format.ContextValue>());
			for(HyContextValueModel contextValueModel: contextValueModels) {
				exportedConfiguration.getContextValues().addAll(getContextValues(contextValueModel));
			}
		}

		return exportedConfiguration;
	}
	
	public eu.hyvar.reconfigurator.input.format.Configuration getExportedConfiguration(
			HyConfiguration oldConfiguration, HyContextValueModel contextValueModel) {
		eu.hyvar.reconfigurator.input.format.Configuration exportedConfiguration = new eu.hyvar.reconfigurator.input.format.Configuration();

		if (oldConfiguration != null) {
			exportedConfiguration.setSelectedFeatures(getSelectedFeatureIds(oldConfiguration));
			exportedConfiguration.setAttributeValues(getFeatureAttributeValues(oldConfiguration));
		}

		if (contextValueModel != null) {
			exportedConfiguration.setContextValues(getContextValues(contextValueModel));
		}

		return exportedConfiguration;
	}
	


	private List<eu.hyvar.reconfigurator.input.format.ContextValue> getContextValues(
			HyContextValueModel contextValueModel) {
		List<eu.hyvar.reconfigurator.input.format.ContextValue> exportedContextValues = new ArrayList<eu.hyvar.reconfigurator.input.format.ContextValue>();

		for (HyContextValue contextValue : contextValueModel.getValues()) {
			eu.hyvar.reconfigurator.input.format.ContextValue exportedContextValue = new eu.hyvar.reconfigurator.input.format.ContextValue();

			exportedContextValue.setId(contextReconfiguratorIdMapping.get(contextValue.getContext()));
			exportedContextValue.setValue(exportValue(contextValue.getValue()));

			exportedContextValues.add(exportedContextValue);
		}

		return exportedContextValues;
	}

	private Integer exportValue(HyValue value) {
		if (value instanceof HyNumberValue) {
			return ((HyNumberValue) value).getValue();
		} else if (value instanceof HyBooleanValue) {
			if (((HyBooleanValue) value).isValue()) {
				return 1;
			} else {
				return 0;
			}
		} else if (value instanceof HyEnumValue) {
			HyEnumValue enumValue = (HyEnumValue) value;
			return enumValue.getEnumLiteral().getValue();
		}

		return 0;
	}

	private List<String> getSelectedFeatureIds(HyConfiguration oldConfiguration) {
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
	private List<eu.hyvar.reconfigurator.input.format.AttributeValue> getFeatureAttributeValues(
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
