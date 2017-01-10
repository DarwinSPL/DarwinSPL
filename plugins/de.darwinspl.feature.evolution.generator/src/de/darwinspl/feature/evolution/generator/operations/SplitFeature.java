package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public class SplitFeature implements EvolutionOperation {

	// DOES CURRENTLY ONLY WORK AT THE END OF EVOLUTION HISTORY!

	protected HyFeature featureToSplit;
	protected HyFeature newlyAddedFeature;
	protected Date date;

	public SplitFeature(HyFeature featureToSplit, HyFeature newlyAddedFeature, Date date) {
		this.featureToSplit = featureToSplit;
		this.newlyAddedFeature = newlyAddedFeature;
		this.date = date;
	}

	public SplitFeature(HyFeature featureToSplit, String newFeatureName, Date date) {
		this.featureToSplit = featureToSplit;
		this.date = date;
		this.newlyAddedFeature = createNewFeature(featureToSplit, newFeatureName, date);
	}

	/**
	 * New feature name: oldFeatureName+"_splitted"
	 * 
	 * @param featureToSplit
	 * @param date
	 */
	public SplitFeature(HyFeature featureToSplit, Date date) {
		String newFeatureName = HyEvolutionUtil.getValidTemporalElement(featureToSplit.getNames(), date).getName();
		this.featureToSplit = featureToSplit;
		this.date = date;
		this.newlyAddedFeature = createNewFeature(featureToSplit, newFeatureName, date);
	}

	private HyFeature createNewFeature(HyFeature featureToSplit, String newFeatureName, Date date) {
		HyFeature newlyAddedFeature = HyFeatureFactory.eINSTANCE.createHyFeature();
		newlyAddedFeature.setValidSince(date);

		HyName featureName = HyEvolutionFactory.eINSTANCE.createHyName();
		featureName.setValidSince(date);
		featureName.setName(newFeatureName);
		newlyAddedFeature.getNames().add(featureName);

		HyFeatureType featureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		featureType.setValidSince(date);
		newlyAddedFeature.getTypes().add(featureType);

		featureType.setType(HyEvolutionUtil.getValidTemporalElement(featureToSplit.getTypes(), date).getType());

		return newlyAddedFeature;
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		featureToSplit.getFeatureModel().getFeatures().add(newlyAddedFeature);

		HyGroupComposition oldGroupComposition = HyEvolutionUtil
				.getValidTemporalElement(featureToSplit.getGroupMembership(), date);
		HyGroup groupOfSplittedFeature = oldGroupComposition.getCompositionOf();

		HyGroupTypeEnum groupOfSplittedFeatureType = HyEvolutionUtil
				.getValidTemporalElement(groupOfSplittedFeature.getTypes(), date).getType();

		if (groupOfSplittedFeatureType.equals(HyGroupTypeEnum.ALTERNATIVE)) {
			HyGroup newGroup = HyFeatureFactory.eINSTANCE.createHyGroup();
			newGroup.setValidSince(date);
			featureToSplit.getFeatureModel().getGroups().add(newGroup);

			HyFeature currentParentFeature = HyEvolutionUtil
					.getValidTemporalElement(groupOfSplittedFeature.getChildOf(), date).getParent();
			HyFeatureChild newFeatureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			newFeatureChild.setValidSince(date);
			newFeatureChild.setChildGroup(newGroup);
			newFeatureChild.setParent(currentParentFeature);

			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			newGroupComposition.setCompositionOf(newGroup);
			newGroupComposition.getFeatures().add(newlyAddedFeature);

			HyGroupType newGroupType = HyFeatureFactory.eINSTANCE.createHyGroupType();
			newGroupType.setValidSince(date);
			newGroupType.setType(HyGroupTypeEnum.AND);
			newGroup.getTypes().add(newGroupType);
		} 
		else {
			// create new GC, add existing features, valid since
			// date. Old GC valid until date, repair superseding
			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			oldGroupComposition.setValidUntil(date);
			groupOfSplittedFeature.getParentOf().add(newGroupComposition);

			newGroupComposition.getFeatures().addAll(oldGroupComposition.getFeatures());
			newGroupComposition.getFeatures().add(newlyAddedFeature);

			if (oldGroupComposition.getValidUntil().equals(oldGroupComposition.getValidSince())) {
				// Check if old group composition can be deleted
				HyLinearTemporalElement oldSupersededElement = oldGroupComposition.getSupersededElement();
				EcoreUtil.delete(oldGroupComposition);
				newGroupComposition.setSupersededElement(oldSupersededElement);
			} else {
				newGroupComposition.setSupersededElement(oldGroupComposition);
			}
		}

	}

}
