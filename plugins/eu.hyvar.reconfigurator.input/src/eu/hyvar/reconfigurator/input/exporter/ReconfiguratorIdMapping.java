package eu.hyvar.reconfigurator.input.exporter;

import java.util.HashMap;
import java.util.Map;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;

public class ReconfiguratorIdMapping {
	
	public static final String FEATURE_ATOM = "feature[";
	public static final String VERSION_ATOM = "feature[";
	public static final String ATTRIBUTE_ATOM = "attribute[";
	public static final String CONTEXT_ATOM = "context[";
	public static final String ARRAY_BRACKETS_CLOSING = "]";
	
	
	private Map<HyFeature, String> featureIdMapping;
	private Map<HyVersion, String> versionIdMapping;
	private Map<HyFeatureAttribute, String> attributeIdMapping;
	private Map<HyContextualInformation, String> contextIdMapping;
	
	public ReconfiguratorIdMapping() {
		featureIdMapping = new HashMap<HyFeature, String>();
		versionIdMapping = new HashMap<HyVersion, String>();
		attributeIdMapping = new HashMap<HyFeatureAttribute, String>();
		contextIdMapping = new HashMap<HyContextualInformation, String>();
	}
	
	public ReconfiguratorIdMapping(HyFeatureModel featureModel, HyContextModel contextModel) {
		this();
		
		StringBuilder idBuilder;
		
		if(featureModel != null) {
			for(HyFeature feature: featureModel.getFeatures()) {
				idBuilder = new StringBuilder();

				idBuilder.append(FEATURE_ATOM);
				idBuilder.append(feature.getId());
				idBuilder.append(ARRAY_BRACKETS_CLOSING);
				
				featureIdMapping.put(feature, idBuilder.toString());
				
				for(HyVersion version: feature.getVersions()) {
					idBuilder = new StringBuilder();

					idBuilder.append(VERSION_ATOM);
					idBuilder.append(feature.getId());
					idBuilder.append(ARRAY_BRACKETS_CLOSING);
					
					versionIdMapping.put(version, idBuilder.toString());
				}
				
				
				for(HyFeatureAttribute attribute: feature.getAttributes()) {
					idBuilder = new StringBuilder();
					
					idBuilder.append(ATTRIBUTE_ATOM);
					idBuilder.append(attribute.getId());
					idBuilder.append(ARRAY_BRACKETS_CLOSING);
					
					attributeIdMapping.put(attribute, idBuilder.toString());
				}
			}
		}
		
		if(contextModel != null) {
			for(HyContextualInformation contextualInformation: contextModel.getContextualInformations()) {

				idBuilder = new StringBuilder();
				
				idBuilder.append(CONTEXT_ATOM);
				idBuilder.append(contextualInformation.getId());
				idBuilder.append(ARRAY_BRACKETS_CLOSING);
				
				contextIdMapping.put(contextualInformation, idBuilder.toString());
			}
		}

		
	}

	public Map<HyFeature, String> getFeatureIdMapping() {
		return featureIdMapping;
	}

	public void setFeatureIdMapping(Map<HyFeature, String> featureIdMapping) {
		this.featureIdMapping = featureIdMapping;
	}

	public Map<HyVersion, String> getVersionIdMapping() {
		return versionIdMapping;
	}

	public void setVersionIdMapping(Map<HyVersion, String> versionIdMapping) {
		this.versionIdMapping = versionIdMapping;
	}

	public Map<HyFeatureAttribute, String> getAttributeIdMapping() {
		return attributeIdMapping;
	}

	public void setAttributeIdMapping(Map<HyFeatureAttribute, String> attributeIdMapping) {
		this.attributeIdMapping = attributeIdMapping;
	}

	public Map<HyContextualInformation, String> getContextIdMapping() {
		return contextIdMapping;
	}

	public void setContextIdMapping(Map<HyContextualInformation, String> contextIdMapping) {
		this.contextIdMapping = contextIdMapping;
	}
	
	
}
