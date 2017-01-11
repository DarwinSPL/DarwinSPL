package de.darwinspl.feature.evolution.generator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import de.darwinspl.feature.evolution.generator.operations.AddFeature;
import de.darwinspl.feature.evolution.generator.operations.ChangeFeatureType;
import de.darwinspl.feature.evolution.generator.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.generator.operations.DeleteFeature;
import de.darwinspl.feature.evolution.generator.operations.DeleteFeatureWithChildren;
import de.darwinspl.feature.evolution.generator.operations.EvolutionOperation;
import de.darwinspl.feature.evolution.generator.operations.EvolutionOperationException;
import de.darwinspl.feature.evolution.generator.operations.MergeFeatures;
import de.darwinspl.feature.evolution.generator.operations.MoveFeature;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class FeatureModelEvolutionGenerator {

	private Random rand;
	
	private enum EvolutionOperationType{ADD_FEATURE,CHANGE_FEATURE_TYPE,CHANGE_GROUP_TYPE,DELETE_FEATURE_POSSIBLY_WITH_CHILDREN,MERGE_FEATURE,MOVE_FEATURE,MOVE_GROUP,SPLIT_FEATURE};
	
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
	public List<EvolutionOperation> generateEvolutionOfFeatureModel(HyFeatureModel featureModel, int amountOfOperations, Date date) {
		
		
		
		ArrayList<EvolutionOperation> appliedEvolutionOperations = new ArrayList<EvolutionOperation>(amountOfOperations);
		
		for(int i=0;i<amountOfOperations;i++) {
			int randomEvoOpIndex = rand.nextInt(EvolutionOperationType.values().length);
			EvolutionOperationType evolutionOperationType = EvolutionOperationType.values()[randomEvoOpIndex];
			
			EvolutionOperation evolutionOp = null;
			
			switch(evolutionOperationType) {
			case ADD_FEATURE:
				evolutionOp = createAddFeatureEvolutionOperation(featureModel, date);
				break;
			case CHANGE_FEATURE_TYPE:
				evolutionOp = createChangeFeatureType(featureModel, date);
				break;
			case CHANGE_GROUP_TYPE:
				evolutionOp = createChangeGroupType(featureModel, date);
				break;
			case DELETE_FEATURE_POSSIBLY_WITH_CHILDREN:
				evolutionOp = createDeleteFeature(featureModel, date);
				break;
			case MERGE_FEATURE:
				evolutionOp = createMergeFeatures(featureModel, date);
				break;
			case MOVE_FEATURE:
				evolutionOp = createMoveFeature(featureModel, date);
				break;
			case MOVE_GROUP:
				break;
			case SPLIT_FEATURE:
				break;			
			}
			
			if(evolutionOp != null) {
				try {
					evolutionOp.applyOperation();
					appliedEvolutionOperations.add(evolutionOp);
				} catch (EvolutionOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, 1);
			date = c.getTime();
		}
		
		return appliedEvolutionOperations;
	}
	
	
	private AddFeature createAddFeatureEvolutionOperation(HyFeatureModel featureModel, Date date) {
		String featureName = "newFeature_"+UUID.randomUUID().toString();
		
		// Only consider valid groups at that point in time
		HyGroup parentGroup = getRandomGroup(featureModel, date);
		
		boolean isMandatory = false;
		
		// If group is and group, randomize type of new feature
		if(HyFeatureEvolutionUtil.isAnd(parentGroup, date)) {
			if(rand.nextInt(2)==0) {
				isMandatory = true;
			}
		}
		
		return new AddFeature(featureModel, featureName, isMandatory, parentGroup, date);
	}
	
	private ChangeFeatureType createChangeFeatureType(HyFeatureModel featureModel, Date date) {
		// List of potential features
		List<HyFeature> features = new ArrayList<HyFeature>();
		
		for(HyGroup group: HyFeatureEvolutionUtil.getGroups(featureModel, date)) {
			// Only consider features of AND groups (others type's cannot be changed
			if(HyFeatureEvolutionUtil.isAnd(group, date)) {
				features.addAll(HyFeatureEvolutionUtil.getFeaturesOfGroup(group, date));
			}
		}
		
		HyFeature feature = features.get(rand.nextInt(features.size()));
		
		return new ChangeFeatureType(feature, date);
	}
	
	private ChangeGroupType createChangeGroupType(HyFeatureModel featureModel, Date date) {
		
		HyGroup group = getRandomGroup(featureModel, date);
		
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
		HyFeature featureToDelete = getRandomNonRootFeature(featureModel, date);
		
		EvolutionOperation evoOp;
		
		// check if feature is leaf.
		if(HyFeatureEvolutionUtil.isLeaf(featureToDelete, date)) {
			// If yes, delete.
			evoOp = new DeleteFeature(featureToDelete, date);
		}
		else {
			// If not, delete with children.
			evoOp = new DeleteFeatureWithChildren(featureToDelete, date);
		}
		
		return evoOp;
	}
	
	private MergeFeatures createMergeFeatures(HyFeatureModel featureModel, Date date) {
		if(HyFeatureEvolutionUtil.getFeatures(featureModel, date).size()<2) {
			return null;
		}
		
		
		// select source randomly
		HyFeature source = getRandomNonRootFeature(featureModel, date);
		
		HyFeature target = getRandomFeature(featureModel, date);
		while(target==source) {
			target = getRandomFeature(featureModel, date);
		}
		
		return new MergeFeatures(source, target, date);
	}
	
	private MoveFeature createMoveFeature(HyFeatureModel featureModel, Date date) {
		if(HyFeatureEvolutionUtil.getGroups(featureModel, date).size() < 2) {
			return null;
		}
		
		HyFeature featureToMove = getRandomNonRootFeature(featureModel, date);
		HyGroup targetGroup = getRandomGroup(featureModel, date);
		while(HyFeatureEvolutionUtil.isInGroup(featureToMove, targetGroup, date)) {
			targetGroup = getRandomGroup(featureModel, date);
		}
		
		return new MoveFeature(featureToMove, targetGroup, date);
	}
	
	private MoveGroup createMoveGroup(HyFeatureModel featureModel, Date date) {
		 
	}
	
	private HyGroup getRandomGroup(HyFeatureModel featureModel, Date date) {
		List<HyGroup> validGroups = HyFeatureEvolutionUtil.getGroups(featureModel, date);
		int groupIndex = rand.nextInt(validGroups.size());
		return validGroups.get(groupIndex);
	}
	
	private HyFeature getRandomFeature(HyFeatureModel featureModel, Date date) {
		List<HyFeature> validFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, date);
		int index = rand.nextInt(validFeatures.size());
		return validFeatures.get(index);
	}
	
	private HyFeature getRandomNonRootFeature(HyFeatureModel featureModel, Date date) {
		List<HyFeature> validFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, date);
		validFeatures.remove(HyFeatureEvolutionUtil.getRootFeature(featureModel, date));
		int index = rand.nextInt(validFeatures.size());
		return validFeatures.get(index);
	}
}
