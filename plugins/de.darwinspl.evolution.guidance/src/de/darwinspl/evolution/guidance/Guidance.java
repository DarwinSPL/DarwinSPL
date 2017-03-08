package de.darwinspl.evolution.guidance;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.darwinspl.feature.evolution.basic.operations.ChangeFeatureType;
import de.darwinspl.feature.evolution.basic.operations.Delete;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.HyMappingModel;

public class Guidance {

	// TODO sensible format for reporting issues? Define requirements first using SPLC'17 paper. Defects in Mapping, Configs. Changed behavior in Mapping, Configs.
	
	protected HyFeatureModel featureModel;
	protected HyMappingModel mappingModel;
	protected List<HyConfiguration> configurations;
	protected Map<EvolutionOperation, EvolutionOperationType> evolutionOperations;
	
	public Guidance(HyFeatureModel featureModel, HyMappingModel mappingModel, List<HyConfiguration> configurations, Map<EvolutionOperation, EvolutionOperationType> evolutionOperations) {
		this.featureModel = featureModel;
		this.mappingModel = mappingModel;
		this.configurations = configurations;
		this.evolutionOperations = evolutionOperations;
	}
	
	public void guide() {
		for(Entry<EvolutionOperation, EvolutionOperationType> entry: evolutionOperations.entrySet()) {
			EvolutionOperation evolutionOperation = entry.getKey();
			
			switch(entry.getValue()) {
			case CHANGE_FEATURE_TYPE:
				guideChangeFeatureType(evolutionOperation);
				break;
			case CHANGE_GROUP_TYPE:
				guideChangeGroupType(evolutionOperation);
				break;
			case DELETE_WITH_CODE:
				guideDeleteWithCode(evolutionOperation);
				break;
			case EXTRACT_FEATURE:
				guideExtractFeature(evolutionOperation);
				break;
			case GROUP_FEATURE:
				guideGroupFeature(evolutionOperation);
				break;
			case MERGE_FEATURE:
				guideMergeFeatures(evolutionOperation);
				break;
			case MOVE_FEATURE:
				guideMoveFeature(evolutionOperation);
				break;
			case UNGROUP_FEATURE:
				guideUngroupFeature(evolutionOperation);
				break;			
			}
		}
	}
	
	/**
	 * (cf. Table 1 in SPLC'17 paper)
	 * @param evolutionOperation
	 */
	protected void guideDeleteWithCode(EvolutionOperation evolutionOperation) {
		Delete deleteOperation;
		if(evolutionOperation instanceof Delete) {
			deleteOperation = (Delete) evolutionOperation;
		}
		else {
			return;
		}
		
		for(HyMapping mapping: mappingModel.getMappings()) {
			if(featureInExpression(deleteOperation.getFeature(), mapping.getExpression())) {
				// TODO defect in Mapping 
				
				// TODO incorporate sat checker -> replace deleted feature with false. If mapping not satisfiable -> changed behavior
				
				
				if(deleteOperation.getOldFeatureType().equals(HyFeatureTypeEnum.MANDATORY)) {
					HyFeature parent = deleteOperation.getOldParent();
					
					for(HyMapping mappingOfParent: mappingModel.getMappings()) {
						if(mapping == mappingOfParent) {
							continue;
						}
						
						if(featureInExpression(parent, mappingOfParent.getExpression())) {
							// TODO Check if parent satisfies mapping. If yes -> warning that mappingOfParent may rely on mapping -> (behavioral change)
						}
					}
				}
			}
		}
		
		for(HyConfiguration configuration: configurations) {
			for(HyConfigurationElement configurationElement: configuration.getElements()) {
				if(configurationElement instanceof HyFeatureSelected) {
					if(((HyFeatureSelected) configurationElement).getSelectedFeature() == deleteOperation.getFeature()) {
						// TODO -> defect in configuration
					}
				}
			}
		}
	}
	
	protected void guideChangeFeatureType(EvolutionOperation evolutionOperation) {
		ChangeFeatureType changeFeatureTypeOperation;
		
		if(evolutionOperation instanceof ChangeFeatureType) {
			changeFeatureTypeOperation = (ChangeFeatureType) evolutionOperation;
		}
		else {
			return;
		}
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected void guideChangeGroupType(EvolutionOperation evolutionOperation) {
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected void guideMoveFeature(EvolutionOperation evolutionOperation) {
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected void guideGroupFeature(EvolutionOperation evolutionOperation) {
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected void guideUngroupFeature(EvolutionOperation evolutionOperation) {
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected void guideMergeFeatures(EvolutionOperation evolutionOperation) {
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected void guideExtractFeature(EvolutionOperation evolutionOperation) {
		
		
		
		// TODO mappings
		// TODO configurations
	}
	
	protected boolean featureInExpression(HyFeature feature, HyExpression expression) {
		if(expression instanceof HyAbstractFeatureReferenceExpression) {
			if(((HyAbstractFeatureReferenceExpression) expression).getFeature() == feature) {
				return true;
			}
		}
		else if(expression instanceof HyUnaryExpression) {
			return featureInExpression(feature, ((HyUnaryExpression) expression).getOperand());
		}
		else if(expression instanceof HyBinaryExpression) {
			HyBinaryExpression binaryExpression = (HyBinaryExpression) expression;
			if(featureInExpression(feature, binaryExpression.getOperand1())) {
				return true;
			}
			
			if(featureInExpression(feature, binaryExpression.getOperand2())) {
				return true;
			}
		}
		
		return false;
	}
	
}
