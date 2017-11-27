package eu.hyvar.reconfigurator.output.translation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyFeatureSelection;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.reconfigurator.input.exporter.ReconfiguratorIdMapping;

public class HyVarRecOutputTranslator {

	/**
	 * Translates a configuration in form of lists of integers (HyVarRec output: https://github.com/HyVar/hyvar-rec/blob/master/spec/hyvar_output_schema.json) to a HyConfiguration
	 * @param featureModel
	 * @param selectedFeatures
	 * @param attributeValues
	 * @return
	 */
	public static HyConfiguration translateConfiguration(HyFeatureModel featureModel, List<String> featureValues, Map<String, Integer> attributeValues) {
		ReconfiguratorIdMapping idMapper = new ReconfiguratorIdMapping(featureModel, null);

		HyConfiguration configuration = HyConfigurationFactory.eINSTANCE.createHyConfiguration();
		configuration.setFeatureModel(featureModel);

		configuration.getElements().addAll(getFeatureSelection(idMapper, featureValues));
		
		configuration.getElements().addAll(getAttributeValueAssignments(idMapper, attributeValues));

		return configuration;
	}
	
	/**
	 * 
	 * @param featureModel
	 * @param featureValues
	 * @param attributeValues key = id, value = value
	 * @param date
	 * @return
	 */
	public static HyConfiguration translateConfiguration(HyFeatureModel featureModel, List<String> featureValues, Map<String, Integer> attributeValues, Date date) {
		HyConfiguration configuration = translateConfiguration(featureModel, featureValues, attributeValues);
		configuration.setCreationDate(date);
		return configuration;
	}

	/**
	 * Translates a list of integers to feature attribute values
	 * @param fmIdWrapper Mapping from feature attributes to ids (i.e., the respective position in the list)
	 * @param attributeValues Integer representation for numberValues, booleanValues (0,1) and enumValues (value range)
	 * @return List of attribute value assignments
	 */
	private static List<HyAttributeValueAssignment> getAttributeValueAssignments(ReconfiguratorIdMapping idMapper, Map<String, Integer> attributeValues) {
		List<HyAttributeValueAssignment> attributeValueAssignments = new ArrayList<HyAttributeValueAssignment>();
		
		int processedValues = 0;
		outerloop:
		for(Map.Entry<HyFeatureAttribute, String> entry: idMapper.getAttributeIdMapping().entrySet()) {
			for(Entry<String, Integer> attributeValue: attributeValues.entrySet()) {
				String correctedId = "attribute["+attributeValue.getKey()+"]";
				
				if(correctedId.equals(entry.getValue())) {
					
					HyFeatureAttribute featureAttribute = entry.getKey();
					
					HyAttributeValueAssignment attributeValueAssignment = HyConfigurationFactory.eINSTANCE.createHyAttributeValueAssignment();
					attributeValueAssignment.setAttribute(featureAttribute);
					
					int intAttributeValue = attributeValue.getValue();
					
					HyValue value = null;
					
					if(featureAttribute instanceof HyNumberAttribute) {
						HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
						numberValue.setValue(intAttributeValue);
						value = numberValue;
					} else if(featureAttribute instanceof HyBooleanAttribute) {
						HyBooleanValue booleanValue = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
						if(intAttributeValue == 1) {
							booleanValue.setValue(true);
						} else {
							booleanValue.setValue(false);
						}
						value = booleanValue;
					} else if(featureAttribute instanceof HyEnumAttribute) {
						HyEnumAttribute enumAttribute = (HyEnumAttribute) featureAttribute;
						HyEnum hyEnum = enumAttribute.getEnumType();
						
						HyEnumValue enumValue = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
						enumValue.setEnum(hyEnum);
						
						for(HyEnumLiteral literal : hyEnum.getLiterals()) {
							if(literal.getValue() == intAttributeValue) {
								enumValue.setEnumLiteral(literal);
								break;
							}
						}
						
						if(enumValue.getEnumLiteral() == null) {
							throw new IllegalArgumentException("No enum literal available for value "+intAttributeValue);
						}
						
						value = enumValue;
					} else if(featureAttribute instanceof HyStringAttribute) {
						throw new UnsupportedOperationException("String Attributes are currenlty not supported");
					}
					
					attributeValueAssignment.setValue(value);
					attributeValueAssignments.add(attributeValueAssignment);
					
					processedValues++;
					if(processedValues == attributeValues.size()) {
						break;
					}
					continue outerloop;
				}
			}
		}
		
		return attributeValueAssignments;
	}
	
	/**
	 * Translates a List of integers (0,1) to feature and version selection.
	 * @param fmIdWrapper Mapping from features and versions to Ids (i.e., position in the respective list)
	 * @param selectedFeatures List of feature selection (0,1), where each feature and version is represented by an id (position in list) and the selection (0,1)
	 * @return List of selected features and their version
	 */	
	private static List<HyFeatureSelection> getFeatureSelection(ReconfiguratorIdMapping idMapper, List<String> selectedFeatures) {		
		List<HyFeatureSelection> featureSelections = new ArrayList<HyFeatureSelection>();
		
		if(selectedFeatures == null) {
			return featureSelections;
		}
		
		List<String> correctedIds = new ArrayList<String>();
		
		for(String selectedFeature: selectedFeatures) {
			correctedIds.add("feature["+selectedFeature+"]");
		}
		
		
		Map<HyFeature, HyVersion> selectedFeaturesOrVersions = new HashMap<HyFeature, HyVersion>();

		for(Map.Entry<HyFeature, String> entry: idMapper.getFeatureIdMapping().entrySet()) {
			if(correctedIds.contains(entry.getValue())) {
				selectedFeaturesOrVersions.put(entry.getKey(), null);
			}
		}
		
		for(Map.Entry<HyVersion, String> entry: idMapper.getVersionIdMapping().entrySet()) {
			if(correctedIds.contains(entry.getValue())) {
				selectedFeaturesOrVersions.put(entry.getKey().getFeature(), entry.getKey());
			}
		}
		

		// Create feature selections for each feature. If available add version
		for (Map.Entry<HyFeature, HyVersion> entry : selectedFeaturesOrVersions.entrySet()) {
			if (entry.getKey() == null) {
				continue;
			}

			HyFeatureSelected featureSelection = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();

			featureSelection.setSelectedFeature(entry.getKey());

			if (entry.getValue() != null) {
				HyVersionSelected versionSelected = HyConfigurationFactory.eINSTANCE.createHyVersionSelected();
				versionSelected.setSelectedVersion(entry.getValue());
			}

			featureSelections.add(featureSelection);
		}
		
		return featureSelections;
	}
}
