package de.darwinspl.evolution.guidance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.darwinspl.feature.evolution.basic.operations.ChangeFeatureType;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.Delete;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.expression.util.DarwinExpressionUtil;
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
		
		// relate numbers of defects and behavioral changes to number of all evolution operations
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
			if(DarwinExpressionUtil.containsFeature(mapping.getExpression(), deleteOperation.getFeature())) {
				// TODO defect in Mapping 
				
				// TODO incorporate sat checker -> replace deleted feature with false. If mapping not satisfiable -> changed behavior
				
				
				if(deleteOperation.getOldFeatureType().equals(HyFeatureTypeEnum.MANDATORY)) {
					HyFeature parent = deleteOperation.getOldParent();
					
					for(HyMapping mappingOfParent: mappingModel.getMappings()) {
						if(mapping == mappingOfParent) {
							continue;
						}
						
						if(DarwinExpressionUtil.containsFeature(mappingOfParent.getExpression(), parent)) {
							// TODO Check if parent satisfies mapping. If yes -> warning that mappingOfParent may rely on mapping -> (behavioral change)
						}
					}
				}
			}
		}
		
		for(HyConfiguration configuration: configurations) {
			if(HyConfigurationUtil.configurationSelects(configuration, deleteOperation.getFeature())) {
				// TODO -> defect in configuration				
			}
		}
	}
	
	/**
	 * see SPLC'17 paper Table 2
	 * @param evolutionOperation
	 */
	protected void guideChangeFeatureType(EvolutionOperation evolutionOperation) {
		ChangeFeatureType changeFeatureTypeOperation = null;
		
		if(evolutionOperation instanceof ChangeFeatureType) {
			changeFeatureTypeOperation = (ChangeFeatureType) evolutionOperation;
		}
		else {
			return;
		}
		
		for(HyMapping mapping: mappingModel.getMappings()) {
			if(changeFeatureTypeOperation.getOldFeatureType().getType().equals(HyFeatureTypeEnum.OPTIONAL) && changeFeatureTypeOperation.getNewFeatureType().getType().equals(HyFeatureTypeEnum.MANDATORY)) {
				// TODO check if parent and not feature required to satisfy mapping -> dead mapping					
			}
			else if(changeFeatureTypeOperation.getOldFeatureType().getType().equals(HyFeatureTypeEnum.MANDATORY) && changeFeatureTypeOperation.getNewFeatureType().getType().equals(HyFeatureTypeEnum.OPTIONAL)) {
				if(DarwinExpressionUtil.containsFeature(mapping.getExpression(), changeFeatureTypeOperation.getParentBeforeEvolution())) {
					//TODO if(check if parent is required to satisfy mapping) {
						for(HyMapping dependenceMapping: mappingModel.getMappings()) {
							if(dependenceMapping == mapping) {
								continue;
							}
							if(DarwinExpressionUtil.containsFeature(mapping.getExpression(), changeFeatureTypeOperation.getFeature())) {
								// TODO check if f0 is required to satisfy dependence mapping -> warning change in behavior (id ii)
							}
						}
					//}
				}
			}
		}
		
		for(HyConfiguration configuration: configurations) {
			if(changeFeatureTypeOperation.getOldFeatureType().getType().equals(HyFeatureTypeEnum.OPTIONAL) && changeFeatureTypeOperation.getNewFeatureType().getType().equals(HyFeatureTypeEnum.MANDATORY)) {
				if(HyConfigurationUtil.configurationSelects(configuration, changeFeatureTypeOperation.getFeature()) && !HyConfigurationUtil.configurationSelects(configuration, changeFeatureTypeOperation.getParentBeforeEvolution())) {
					// // TODO defect (id iii)
				}
			}
		}
	}
	
	protected void guideChangeGroupType(EvolutionOperation evolutionOperation) {
		ChangeGroupType changeGroupTypeOperation = null;
		
		if(evolutionOperation instanceof ChangeGroupType) {
			changeGroupTypeOperation = (ChangeGroupType) evolutionOperation;
		}
		else {
			return;
		}
		
//		List<HyMapping> deadMappings = new ArrayList<HyMapping>();
		
		for(HyMapping mapping: mappingModel.getMappings()) {
			if(changeGroupTypeOperation.getOldGroupType().getType().equals(HyGroupTypeEnum.OR) && changeGroupTypeOperation.getNewGroupType().getType().equals(HyGroupTypeEnum.ALTERNATIVE)) {
				GroupMemberIteration:
				for(int i=0;i<changeGroupTypeOperation.getGroupMembersBeforeEvolution().size()-1;i++) {
					HyFeature groupMember1 = changeGroupTypeOperation.getGroupMembersBeforeEvolution().get(i);
					
					for(int j=i+1;j<changeGroupTypeOperation.getGroupMembersBeforeEvolution().size();j++) {
						HyFeature groupMember2 = changeGroupTypeOperation.getGroupMembersBeforeEvolution().get(j);
						
						// TODO check if groupMember1 and groupMember2 are required to satisfy mapping. If yes -> add to deadMappings, warning. break GroupMemberIteration
					}
				}
			}
			else if(changeGroupTypeOperation.getOldGroupType().getType().equals(HyGroupTypeEnum.ALTERNATIVE) && changeGroupTypeOperation.getNewGroupType().getType().equals(HyGroupTypeEnum.OR)) {
				
			}
			
		}
		
		
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
	
	
}
