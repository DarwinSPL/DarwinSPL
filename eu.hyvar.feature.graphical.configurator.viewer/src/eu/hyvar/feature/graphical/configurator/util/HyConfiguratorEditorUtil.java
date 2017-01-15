package eu.hyvar.feature.graphical.configurator.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.hyvar.dataValues.HyValue;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.graphical.configurator.predicates.HyConfiguratorElementHasFeaturePredicate;
import eu.hyvar.feature.graphical.configurator.predicates.HyConfiguratorElementHasVersionPredicate;

public class HyConfiguratorEditorUtil {
	public static HyFeature getParentFeature(HyFeature feature, Date date){
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		if(composition == null) return null;
		
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getChildOf(), date);
		if(child == null) return null;
		
		return child.getParent();
	}
	
	public static List<HyFeature> getChildrenFeatures(HyFeature feature, Date date){
		List<HyFeature> featureChildren = new ArrayList<HyFeature>();
		List<HyFeatureChild> featureChildChildren = HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), date);
				
		for(HyFeatureChild featureChild : featureChildChildren){
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(featureChild.getChildGroup().getParentOf(), date);
			featureChildren.addAll(groupComposition.getFeatures());
		}
		
		return featureChildren;
	}

	public static void addParentFeaturesToConfiguration(HyConfiguration configuration, HyFeature feature, Date date){
		HyFeature parentFeature = getParentFeature(feature, date);
		
		if(parentFeature != null){
			if(!HyConfigurationUtil.configurationSelects(configuration, parentFeature)){
				HyFeatureSelected featureSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
				featureSelected.setSelectedFeature(parentFeature);
				configuration.getElements().add(featureSelected);
				
				addParentFeaturesToConfiguration(configuration, parentFeature, date);
			}
		}
	}
	
	public static void removeChildrenFeaturesFromConfiguration(HyConfiguration configuration, HyFeature feature, Date date){
		List<HyFeature> featureChildren = getChildrenFeatures(feature, date);
		
		for(HyFeature featureChild : featureChildren){
			HyConfiguratorElementHasFeaturePredicate<Object> predicate = new HyConfiguratorElementHasFeaturePredicate<>();
			predicate.feature = featureChild;
			
			if(configuration.getElements().removeIf(predicate)){
				removePossibleSelectedVersionsFromConfiguration(configuration, featureChild, date);
				removeChildrenFeaturesFromConfiguration(configuration, featureChild, date);
			}
		}
	}
	
	public static void removePossibleSelectedVersionsFromConfiguration(HyConfiguration configuration, HyFeature feature, Date date){
		for(HyVersion version : feature.getVersions()){
			HyConfiguratorElementHasVersionPredicate<Object> predicate = new HyConfiguratorElementHasVersionPredicate<>();
			predicate.version = version;
			
			configuration.getElements().removeIf(predicate);
		}
	}

	public static void addFeatureToConfiguration(HyConfiguration configuration, HyFeature feature, Date date){
		HyFeatureSelected featureSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		featureSelected.setSelectedFeature(feature);
		configuration.getElements().add(featureSelected);
		
		addParentFeaturesToConfiguration(configuration, feature, date);
	}
	
	public static void addAttributeToConfiguration(HyConfiguration configuration, HyFeatureAttribute attribute, HyValue value, Date date){
		HyAttributeValueAssignment attributeValueAssignment = HyConfigurationFactory.eINSTANCE.createHyAttributeValueAssignment();
		attributeValueAssignment.setAttribute(attribute);
		attributeValueAssignment.setValue(value);
		configuration.getElements().add(attributeValueAssignment);
		
		addFeatureToConfiguration(configuration, attribute.getFeature(), date);
	}
}
