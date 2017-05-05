package de.darwinspl.feature.evolution.generator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import de.darwinspl.evolution.guidance.EvolutionOperationType;
import de.darwinspl.feature.evolution.basic.operations.ChangeFeatureType;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.Delete;
import de.darwinspl.feature.evolution.basic.operations.GroupFeature;
import de.darwinspl.feature.evolution.basic.operations.MoveFeature;
import de.darwinspl.feature.evolution.basic.operations.UngroupFeature;
import de.darwinspl.feature.evolution.complex.operations.ExtractFeature;
import de.darwinspl.feature.evolution.complex.operations.MergeFeatures;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperationInvoker;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class FeatureModelEvolutionGenerator {

	private Random rand;
	
//	public enum EvolutionOperationType{DELETE_WITH_CODE,CHANGE_FEATURE_TYPE,CHANGE_GROUP_TYPE,MERGE_FEATURE,MOVE_FEATURE,GROUP_FEATURE,UNGROUP_FEATURE, EXTRACT_FEATURE};
	
	public FeatureModelEvolutionGenerator() {
		rand = new Random();
	}
	
	/**
	 * Each day one evo Op.
	 * @param featureModel
	 * @param amountOfOperations
	 * @param date Date at which the evolution operations should start. 
	 * @return
	 */
	public Map<EvolutionOperation, EvolutionOperationType> generateEvolutionOfFeatureModel(HyFeatureModel featureModel, int amountOfOperations, Date date) {
		EvolutionOperationInvoker evolutionInvoker = new EvolutionOperationInvoker();
		
		
		Map<EvolutionOperation, EvolutionOperationType> appliedEvolutionOperations = new HashMap<EvolutionOperation, EvolutionOperationType>();
		
		for(int i=0;i<amountOfOperations;i++) {
			int randomEvoOpIndex = rand.nextInt(EvolutionOperationType.values().length);
			EvolutionOperationType evolutionOperationType = EvolutionOperationType.values()[randomEvoOpIndex];
			
			EvolutionOperation evolutionOp = null;
				
			switch(evolutionOperationType) {
			case CHANGE_FEATURE_TYPE:
				evolutionOp = createChangeFeatureType(featureModel, date);
				break;
			case CHANGE_GROUP_TYPE:
				evolutionOp = createChangeGroupType(featureModel, date);
				break;
			case MERGE_FEATURE:
				evolutionOp = createMergeFeatures(featureModel, date);
				break;
			case MOVE_FEATURE:
				evolutionOp = createMoveFeature(featureModel, date);
				break;
			case DELETE_WITH_CODE:
				evolutionOp = createDeleteFeature(featureModel, date);
				break;
			case EXTRACT_FEATURE:
				evolutionOp = createExtractFeature(featureModel, date);
				break;
			case GROUP_FEATURE:
				evolutionOp = createGroupFeature(featureModel, date);
				break;
			case UNGROUP_FEATURE:
				evolutionOp = createUngroupFeature(featureModel, date);
				break;
			default:
				break;		
			}
			
			if(evolutionOp != null) {
				evolutionInvoker.invokeOperation(evolutionOp, featureModel);
				appliedEvolutionOperations.put(evolutionOp, evolutionOperationType);
			}
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, 1);
			date = c.getTime();
		}
		
		return appliedEvolutionOperations;
	}
	
	private GroupFeature createGroupFeature(HyFeatureModel featureModel, Date date) {
		
		HyFeature featureToGroup = HyFeatureEvolutionUtil.getRandomNonRootFeature(featureModel, date);
		
		List<HyGroupTypeEnum> allowedTypes = new ArrayList<HyGroupTypeEnum>(2);
		allowedTypes.add(HyGroupTypeEnum.ALTERNATIVE);
		allowedTypes.add(HyGroupTypeEnum.OR);
		
		HyGroup targetGroup = HyFeatureEvolutionUtil.getRandomGroupWithType(featureModel, allowedTypes, date);
		
		return new GroupFeature(featureToGroup, targetGroup, date);
		
	}
	
	private UngroupFeature createUngroupFeature(HyFeatureModel featureModel, Date date) {
		List<HyGroupTypeEnum> allowedTypes = new ArrayList<HyGroupTypeEnum>(2);
		allowedTypes.add(HyGroupTypeEnum.ALTERNATIVE);
		allowedTypes.add(HyGroupTypeEnum.OR);
		
		HyGroup sourceGroup = HyFeatureEvolutionUtil.getRandomGroupWithType(featureModel, allowedTypes, date);
		
		List<HyFeature> features = HyFeatureEvolutionUtil.getFeaturesOfGroup(sourceGroup, date);
		
		int index = rand.nextInt(features.size());
		
		return new UngroupFeature(features.get(index), date);
	}
	
	private ExtractFeature createExtractFeature(HyFeatureModel featureModel, Date date) {
		
		if(featureModel == null || date == null || HyFeatureEvolutionUtil.getFeatures(featureModel, date).size() <= 1) {
			return null;
		}
		
		HyFeature feature = HyFeatureEvolutionUtil.getRandomNonRootFeature(featureModel, date);
		
		return new ExtractFeature(feature, null, null, date);
	}
	
//	private AddFeature createAddFeatureEvolutionOperation(HyFeatureModel featureModel, Date date) {
//		String featureName = "newFeature_"+UUID.randomUUID().toString();
//		
//		// Only consider valid groups at that point in time
//		HyGroup parentGroup = HyFeatureEvolutionUtil.getRandomGroup(featureModel, date);
//		
//		// No group exists.
//		if(parentGroup == null) {
//			HyFeature root = HyFeatureEvolutionUtil.getRootFeature(featureModel, date);
//			if(root != null) {
//				// create 
//				parentGroup = HyFeatureFactoryWithIds.eINSTANCE.createHyGroup();
//				parentGroup.setValidSince((Date)date.clone());
//				
//				HyGroupType groupType = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupType();
//				groupType.setType(HyGroupTypeEnum.AND);
//				groupType.setValidSince((Date)date.clone());
//				parentGroup.getTypes().add(groupType);
//				
//				featureModel.getGroups().add(parentGroup);
//				
//				HyFeatureChild featureChild = HyFeatureFactoryWithIds.eINSTANCE.createHyFeatureChild();
//				featureChild.setValidSince(date);
//				root.getParentOf().add(featureChild);
//				featureChild.setChildGroup(parentGroup);
//				
//				HyGroupComposition groupComposition = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupComposition();
//				groupComposition.setCompositionOf(parentGroup);
//			}
//			else {
//				// there is no root -> no valid FM
//				return null;
//			}
//		}
//		
//		
//		boolean isMandatory = false;
//		
//		// If group is and group, randomize type of new feature
//		if(HyFeatureEvolutionUtil.isAnd(parentGroup, date)) {
//			if(rand.nextInt(2)==0) {
//				isMandatory = true;
//			}
//		}
//		
//		return new AddFeature(featureModel, featureName, isMandatory, parentGroup, date);
//	}
	
	private ChangeFeatureType createChangeFeatureType(HyFeatureModel featureModel, Date date) {
		// List of potential features
		List<HyFeature> features = new ArrayList<HyFeature>();
		
		for(HyGroup group: HyFeatureEvolutionUtil.getGroups(featureModel, date)) {
			// Only consider features of AND groups (others type's cannot be changed
			if(HyFeatureEvolutionUtil.isAnd(group, date)) {
				features.addAll(HyFeatureEvolutionUtil.getFeaturesOfGroup(group, date));
			}
		}
		
		if(features.size()<1) {
			return null;
		}
		
		HyFeature feature = features.get(rand.nextInt(features.size()));
		
		return new ChangeFeatureType(feature, date);
	}
	
	private ChangeGroupType createChangeGroupType(HyFeatureModel featureModel, Date date) {
		
		HyGroup group = HyFeatureEvolutionUtil.getRandomGroup(featureModel, date);
		
		if(group == null) {
			return null;
		}
		
		HyGroupTypeEnum currentGroupType = HyFeatureEvolutionUtil.getType(group, date).getType();
		
		HyGroupTypeEnum newGroupType = null;
		
		int newTypeId = rand.nextInt(2);
		switch(currentGroupType) {
		case ALTERNATIVE:
			switch(newTypeId) {
			case 0:
				newGroupType = HyGroupTypeEnum.AND;
				break;
			case 1:
				newGroupType = HyGroupTypeEnum.OR;
				break;
			}
			break;
		case AND:
			switch(newTypeId) {
			case 0:
				newGroupType = HyGroupTypeEnum.ALTERNATIVE;
				break;
			case 1:
				newGroupType = HyGroupTypeEnum.OR;
				break;
			}
			break;
		case OR:
			switch(newTypeId) {
			case 0:
				newGroupType = HyGroupTypeEnum.ALTERNATIVE;
				break;
			case 1:
				newGroupType = HyGroupTypeEnum.AND;
				break;
			}
			break;
		}
		
		return new ChangeGroupType(group, newGroupType, date);
	}
	
	private EvolutionOperation createDeleteFeature(HyFeatureModel featureModel, Date date) {
		// select random feature to delete
		HyFeature featureToDelete = HyFeatureEvolutionUtil.getRandomNonRootFeature(featureModel, date);
		
		if(featureToDelete == null) {
			return null;
		}
		
		EvolutionOperation evoOp;
		evoOp = new Delete(featureToDelete, date);
		
//		// check if feature is leaf.
//		if(HyFeatureEvolutionUtil.isLeaf(featureToDelete, date)) {
//			// If yes, delete.
//		}
//		else {
//			// If not, delete with children.
//			evoOp = new DeleteFeatureWithChildren(featureToDelete, date);
//		}
		
		return evoOp;
	}
	
	private MergeFeatures createMergeFeatures(HyFeatureModel featureModel, Date date) {
		if(HyFeatureEvolutionUtil.getFeatures(featureModel, date).size()<2) {
			return null;
		}
		
		
		// select source randomly
		HyFeature source = HyFeatureEvolutionUtil.getRandomNonRootFeature(featureModel, date);
		// select target randomly
		HyFeature target = HyFeatureEvolutionUtil.getRandomFeature(featureModel, source, date);
		
		return new MergeFeatures(source, target, date);
	}
	
	private MoveFeature createMoveFeature(HyFeatureModel featureModel, Date date) {
		if(HyFeatureEvolutionUtil.getGroups(featureModel, date).size() < 2) {
			return null;
		}
		
		HyFeature featureToMove = HyFeatureEvolutionUtil.getRandomNonRootFeature(featureModel, date);
		HyGroup targetGroup = HyFeatureEvolutionUtil.getRandomGroup(featureModel, HyFeatureEvolutionUtil.getParentGroupOfFeature(featureToMove, date), date);

		return new MoveFeature(featureToMove, targetGroup, date);
	}
	
//	private MoveGroup createMoveGroup(HyFeatureModel featureModel, Date date) {
//		if(HyFeatureEvolutionUtil.getGroups(featureModel, date).size()<2) {
//			return null;
//		}
//		
//		HyGroup group = HyFeatureEvolutionUtil.getRandomGroup(featureModel, date);
//		
//		List<HyFeature> subtreeFeaturesOfGroup = HyFeatureEvolutionUtil.getFeatureOfSubtree(group, date,0);
//		
//		// Check if there are at least two features which 
//		 if((HyFeatureEvolutionUtil.getFeatures(featureModel, date).size() - subtreeFeaturesOfGroup.size()) < 2) {
//			 return null;
//		 }
//		 
//		 HyFeature newParent = HyFeatureEvolutionUtil.getRandomFeature(featureModel, subtreeFeaturesOfGroup, date);
//		 
//		 return new MoveGroup(group, newParent, date);
//	}
//	
//	private SplitFeature createSplitFeature(HyFeatureModel featureModel, Date date) {
//		HyFeature featureToSplit = HyFeatureEvolutionUtil.getRandomFeature(featureModel, date);
//		if(featureToSplit == null) {
//			return null;
//		}
//		
//		return new SplitFeature(featureToSplit, date);
//	}
}
