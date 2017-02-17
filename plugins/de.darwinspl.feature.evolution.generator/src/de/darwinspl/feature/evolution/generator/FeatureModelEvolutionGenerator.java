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
import de.darwinspl.feature.evolution.generator.operations.MoveGroup;
import de.darwinspl.feature.evolution.generator.operations.SplitFeature;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.exporter.HyFeatureModelConsoleExporter;
import eu.hyvar.feature.util.exporter.HyFeatureModelConsoleExporter;

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
				evolutionOp = createMoveGroup(featureModel, date);
				break;
			case SPLIT_FEATURE:
				evolutionOp = createSplitFeature(featureModel, date);
				break;			
			}
			
			if(evolutionOp != null) {
					try {
						evolutionOp.applyOperation();
					} catch (EvolutionOperationException e) {
						e.printStackTrace();
					}
					appliedEvolutionOperations.add(evolutionOp);
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
		HyGroup parentGroup = HyFeatureEvolutionUtil.getRandomGroup(featureModel, date);
		
		// No group exists.
		if(parentGroup == null) {
			HyFeature root = HyFeatureEvolutionUtil.getRootFeature(featureModel, date);
			if(root != null) {
				// create 
				parentGroup = HyFeatureFactoryWithIds.eINSTANCE.createHyGroup();
				parentGroup.setValidSince((Date)date.clone());
				
				HyGroupType groupType = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupType();
				groupType.setType(HyGroupTypeEnum.AND);
				groupType.setValidSince((Date)date.clone());
				parentGroup.getTypes().add(groupType);
				
				featureModel.getGroups().add(parentGroup);
				
				HyFeatureChild featureChild = HyFeatureFactoryWithIds.eINSTANCE.createHyFeatureChild();
				featureChild.setValidSince(date);
				root.getParentOf().add(featureChild);
				featureChild.setChildGroup(parentGroup);
				
				HyGroupComposition groupComposition = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupComposition();
				groupComposition.setCompositionOf(parentGroup);
			}
			else {
				// there is no root -> no valid FM
				return null;
			}
		}
		
		
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
	
	private MoveGroup createMoveGroup(HyFeatureModel featureModel, Date date) {
		if(HyFeatureEvolutionUtil.getGroups(featureModel, date).size()<2) {
			return null;
		}
		
		HyGroup group = HyFeatureEvolutionUtil.getRandomGroup(featureModel, date);
		
		List<HyFeature> subtreeFeaturesOfGroup = HyFeatureEvolutionUtil.getFeatureOfSubtree(group, date,0);
		
		// Check if there are at least two features which 
		 if((HyFeatureEvolutionUtil.getFeatures(featureModel, date).size() - subtreeFeaturesOfGroup.size()) < 2) {
			 return null;
		 }
		 
		 HyFeature newParent = HyFeatureEvolutionUtil.getRandomFeature(featureModel, subtreeFeaturesOfGroup, date);
		 
		 return new MoveGroup(group, newParent, date);
	}
	
	private SplitFeature createSplitFeature(HyFeatureModel featureModel, Date date) {
		HyFeature featureToSplit = HyFeatureEvolutionUtil.getRandomFeature(featureModel, date);
		if(featureToSplit == null) {
			return null;
		}
		
		return new SplitFeature(featureToSplit, date);
	}
}
