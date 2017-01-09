package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

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
			HyGroup newGroup = HyFeatureFactory.eINSTANCE.createHyGroup();
			newGroup.setValidSince(date);
			featureToMove.getFeatureModel().getGroups().add(newGroup);
			
			HyGroupType newGroupType = HyFeatureFactory.eINSTANCE.createHyGroupType();
			newGroupType.setValidSince(date);
			newGroupType.setType(HyGroupTypeEnum.AND);
			newGroup.getTypes().add(newGroupType);
			
			HyFeatureChild newFeatureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			newFeatureChild.setValidSince(date);
			newFeatureChild.setParent(newParentFeature);
			newFeatureChild.setChildGroup(newGroup);
			
			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			
			targetGroup = newGroup;
		}
		
		// Change type to OPTIONAL of feature if moved to an Alternative or OR group
		if(!HyEvolutionUtil.getValidTemporalElement(targetGroup.getTypes(), date).getType().equals(HyGroupTypeEnum.AND)) {
			HyFeatureType currentFeatureType = HyEvolutionUtil.getValidTemporalElement(featureToMove.getTypes(), date);
			if(currentFeatureType.getType().equals(HyFeatureTypeEnum.MANDATORY)) {
				currentFeatureType.setValidUntil(date);
				
				HyFeatureType newFeatureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
				newFeatureType.setValidSince(date);
				newFeatureType.setType(HyFeatureTypeEnum.OPTIONAL);
				featureToMove.getTypes().add(newFeatureType);
			}
		}
		
		
		// remove feature from previous group
		HyGroupComposition currentMembership = HyEvolutionUtil.getValidTemporalElement(featureToMove.getGroupMembership(), date);
		HyGroup currentGroup = currentMembership.getCompositionOf();
		
		currentMembership.setValidUntil(date);
		
		HyGroupComposition newCompositionOfOldGroup = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
		newCompositionOfOldGroup.setValidSince(date);
		newCompositionOfOldGroup.setSupersededElement(currentMembership);
		newCompositionOfOldGroup.setCompositionOf(currentGroup);
		newCompositionOfOldGroup.getFeatures().addAll(currentMembership.getFeatures());
		newCompositionOfOldGroup.getFeatures().remove(featureToMove);
			// TODO not done: if operation was in between two other operations.
		
		
		// add feature to new group
		HyGroupComposition currentTargetComposition = HyEvolutionUtil.getValidTemporalElement(targetGroup.getParentOf(), date);
		currentTargetComposition.setValidUntil(date);
		HyGroupComposition newTargetComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
		newTargetComposition.setValidSince(date);
		newTargetComposition.setSupersededElement(currentTargetComposition);
		newTargetComposition.setCompositionOf(targetGroup);
		newTargetComposition.getFeatures().addAll(currentTargetComposition.getFeatures());
		newTargetComposition.getFeatures().add(featureToMove);
	}

}
