package de.darwinspl.feature.graphical.configurator.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasFeaturePredicate;
import de.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasVersionPredicate;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;

public class DwConfiguratorEditorUtil {
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
			DwConfiguratorElementHasFeaturePredicate<Object> predicate = new DwConfiguratorElementHasFeaturePredicate<>();
			predicate.feature = featureChild;
			
			if(configuration.getElements().removeIf(predicate)){
				removePossibleSelectedVersionsFromConfiguration(configuration, featureChild, date);
				removeChildrenFeaturesFromConfiguration(configuration, featureChild, date);
			}
		}
	}
	
	public static void removePossibleSelectedVersionsFromConfiguration(HyConfiguration configuration, HyFeature feature, Date date){
		for(HyVersion version : feature.getVersions()){
			DwConfiguratorElementHasVersionPredicate<Object> predicate = new DwConfiguratorElementHasVersionPredicate<>();
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
		
//		addFeatureToConfiguration(configuration, attribute.getFeature(), date);
	}
	
	public static EList<HyAttributeValueAssignment> getHyAttributeValueAssignments(HyConfiguration configuration){
		EList<HyAttributeValueAssignment> assignments = new BasicEList<HyAttributeValueAssignment>();
		for(HyConfigurationElement element: configuration.getElements()){
			if(element instanceof HyAttributeValueAssignment){
				assignments.add((HyAttributeValueAssignment) element);
				
			}
		}
		
		return assignments;
	}
	
	public static HyAttributeValueAssignment getValueAssignmentForFeatureAttribute(HyConfiguration configuration, HyFeatureAttribute attribute){
		for(HyAttributeValueAssignment assignment: getHyAttributeValueAssignments(configuration)){
			if(assignment.getAttribute().equals(attribute)){
				return assignment;
			}
		}
		return null;
	}
	
	
	
	public static void changeValueAssignmentOfAttribute(HyConfiguration configuration, HyFeatureAttribute attribute, HyValue value){
		for(HyAttributeValueAssignment assignment: getHyAttributeValueAssignments(configuration)){
			if(assignment.getAttribute().equals(attribute)){
				assignment.setValue(value);
			}
			
		}
	}
}
