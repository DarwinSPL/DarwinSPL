package eu.hyvar.feature.configuration.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureDeselected;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;

public class HyConfigurationUtil {

	
	private static final String CONFIGURATION_MODEL_FILE_EXTENSION_FOR_XMI = "hyconfigurationmodel";
	private static final String CONFIGURATION_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX = "hyconfiguration";
	
	
	public static List<HyFeature> getSelectedFeatures(HyConfiguration configuration, Date date) {
		List<HyConfigurationElement> validConfigurationElements = HyEvolutionUtil.getValidTemporalElements(configuration.getElements(), date);
		return getSelectedFeatures(validConfigurationElements);
	}
	
	public static List<HyFeature> getSelectedFeatures(List<HyConfigurationElement> validConfigurationElements) {
		List<HyFeature> selectedFeatures = new ArrayList<HyFeature>();
		
		for(HyConfigurationElement element: validConfigurationElements) {
			if(element instanceof HyFeatureSelected) {
				selectedFeatures.add(((HyFeatureSelected)element).getSelectedFeature());
			}
		}
		
		return selectedFeatures;
	}
	
	public static List<HyFeature> getSelectedFeatures(List<HyConfigurationElement> configurationElements, Date date){
		List<HyConfigurationElement> validConfigurationElements = HyEvolutionUtil.getValidTemporalElements(configurationElements, date);
		return getSelectedFeatures(validConfigurationElements);
	}
	
	public static List<HyVersion> getSelectedVersions(HyConfiguration configuration, Date date) {
		List<HyConfigurationElement> validConfigurationElements = HyEvolutionUtil.getValidTemporalElements(configuration.getElements(), date);
		return getSelectedVersions(validConfigurationElements);
	}
	
	public static List<HyVersion> getSelectedVersions(List<HyConfigurationElement> validConfigurationElements) {
		List<HyVersion> selectedVersions = new ArrayList<HyVersion>();
		
		for(HyConfigurationElement element: validConfigurationElements) {
			if(element instanceof HyVersionSelected) {
				selectedVersions.add(((HyVersionSelected)element).getSelectedVersion());
			}
		}
		
		return selectedVersions;
	}
	
	public static List<HyVersion> getSelectedVersions(List<HyConfigurationElement> configurationElements, Date date){
		List<HyConfigurationElement> validConfigurationElements = HyEvolutionUtil.getValidTemporalElements(configurationElements, date);
		return getSelectedVersions(validConfigurationElements);
	}
	
	public static boolean configurationSelects(HyConfiguration configuration, HyFeature searchedFeature) {
		if(configuration==null || searchedFeature==null) {
			return false;
		}
		
		for(HyConfigurationElement configEle: configuration.getElements()) {
			if(configEle instanceof HyFeatureSelected) {
				HyFeatureSelected featureSelected = (HyFeatureSelected) configEle;
				if(EcoreUtil.equals(featureSelected.getSelectedFeature(), searchedFeature)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean configurationDeselects(HyConfiguration configuration, HyFeature searchedFeature) {
		if(configuration==null || searchedFeature==null) {
			return false;
		}
		
		for(HyConfigurationElement configEle: configuration.getElements()) {
			if(configEle instanceof HyFeatureDeselected) {
				HyFeatureDeselected featureSelected = (HyFeatureDeselected) configEle;
				if(EcoreUtil.equals(featureSelected.getSelectedFeature(), searchedFeature)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean configurationSelectsVersion(HyConfiguration configuration, HyVersion hyVersion) {
		if(configuration==null || hyVersion==null) {
			return false;
		}
		
		for(HyConfigurationElement configEle: configuration.getElements()) {
			if(configEle instanceof HyVersionSelected) {
				HyVersionSelected versionSelected = (HyVersionSelected) configEle;
				if(EcoreUtil.equals(versionSelected.getSelectedVersion(), hyVersion)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static List<HyAttributeValueAssignment> getAttributeValueAssignments(HyConfiguration configuration, Date date) {
		List<HyConfigurationElement> validConfigurationElements = HyEvolutionUtil.getValidTemporalElements(configuration.getElements(), date);
		return getAttributeValueAssignments(validConfigurationElements);
	}
	
	public static List<HyAttributeValueAssignment> getAttributeValueAssignments(List<HyConfigurationElement> validConfigurationElements) {
		List<HyAttributeValueAssignment> attributeValueAssignments = new ArrayList<HyAttributeValueAssignment>();
		
		for(HyConfigurationElement configEle: validConfigurationElements) {
			if(configEle instanceof HyAttributeValueAssignment) {
				attributeValueAssignments.add((HyAttributeValueAssignment)configEle);
			}
		}
		
		return attributeValueAssignments;
	}

	public static String getConfigurationModelFileExtensionForXmi() {
		return CONFIGURATION_MODEL_FILE_EXTENSION_FOR_XMI;
	}

	public static String getConfigurationModelFileExtensionForConcreteSyntax() {
		return CONFIGURATION_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX;
	}
	
	
}
