package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;

public class MoveFeature implements EvolutionOperation {

	protected HyFeature featureToMove;
	protected Date date;
	protected HyGroup targetGroup;
	protected HyFeature newParentFeature;
	
	public MoveFeature(HyFeature featureToMove, HyGroup targetGroup, Date date) {
		this.featureToMove = featureToMove;
		this.targetGroup = targetGroup;
		this.date = date;
	}
	
	public MoveFeature(HyFeature featureToMove, HyFeature newParentFeature, Date date) {
		this.featureToMove = featureToMove;
		this.newParentFeature = newParentFeature;
		this.date = date;
	}
	
	@Override
	public void applyOperation() throws EvolutionOperationException {
		if(targetGroup == null) {
			HyGroup newGroup = HyFeatureFactoryWithIds.eINSTANCE.createHyGroup();
			newGroup.setValidSince((Date)date.clone());
			featureToMove.getFeatureModel().getGroups().add(newGroup);
			
			HyGroupType newGroupType = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupType();
			newGroupType.setValidSince((Date)date.clone());
			newGroupType.setType(HyGroupTypeEnum.AND);
			newGroup.getTypes().add(newGroupType);
			
			HyFeatureChild newFeatureChild = HyFeatureFactoryWithIds.eINSTANCE.createHyFeatureChild();
			newFeatureChild.setValidSince((Date)date.clone());
			newFeatureChild.setParent(newParentFeature);
			newFeatureChild.setChildGroup(newGroup);
			
			HyGroupComposition newGroupComposition = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince((Date)date.clone());
			
			featureToMove.getFeatureModel().getGroups().add(newGroup);
			targetGroup = newGroup;
		}
		
		// Change type to OPTIONAL of feature if moved to an Alternative or OR group
		if(!HyEvolutionUtil.getValidTemporalElement(targetGroup.getTypes(), date).getType().equals(HyGroupTypeEnum.AND)) {
			HyFeatureType currentFeatureType = HyEvolutionUtil.getValidTemporalElement(featureToMove.getTypes(), date);
			if(currentFeatureType.getType().equals(HyFeatureTypeEnum.MANDATORY)) {
				currentFeatureType.setValidUntil((Date)date.clone());
				
				HyFeatureType newFeatureType = HyFeatureFactoryWithIds.eINSTANCE.createHyFeatureType();
				newFeatureType.setValidSince((Date)date.clone());
				newFeatureType.setType(HyFeatureTypeEnum.OPTIONAL);
				featureToMove.getTypes().add(newFeatureType);
			}
		}
		
		
		// remove feature from previous group
		HyGroupComposition currentMembership = HyEvolutionUtil.getValidTemporalElement(featureToMove.getGroupMembership(), date);
		HyGroup currentGroup = currentMembership.getCompositionOf();
		
		currentMembership.setValidUntil((Date)date.clone());
		
		HyGroupComposition newCompositionOfOldGroup = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupComposition();
		newCompositionOfOldGroup.setValidSince((Date)date.clone());
		newCompositionOfOldGroup.setSupersededElement(currentMembership);
		newCompositionOfOldGroup.setCompositionOf(currentGroup);
		newCompositionOfOldGroup.getFeatures().addAll(currentMembership.getFeatures());
		newCompositionOfOldGroup.getFeatures().remove(featureToMove);
		
		
		// add feature to new group
		HyGroupComposition currentTargetComposition = HyEvolutionUtil.getValidTemporalElement(targetGroup.getParentOf(), date);
		currentTargetComposition.setValidUntil((Date)date.clone());
		HyGroupComposition newTargetComposition = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupComposition();
		newTargetComposition.setValidSince((Date)date.clone());
		newTargetComposition.setSupersededElement(currentTargetComposition);
		newTargetComposition.setCompositionOf(targetGroup);
		newTargetComposition.getFeatures().addAll(currentTargetComposition.getFeatures());
		newTargetComposition.getFeatures().add(featureToMove);
		
		
		// TODO check if old compositions can be removed
	}

}
