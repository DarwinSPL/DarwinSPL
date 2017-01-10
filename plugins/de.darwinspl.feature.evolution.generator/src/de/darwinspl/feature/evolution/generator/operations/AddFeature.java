package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;

public class AddFeature implements EvolutionOperation {

	protected HyFeature addedFeature;
	protected HyFeatureModel featureModel;

	protected Date date;

	protected HyFeature parentFeature;

	protected HyGroup groupToAddTo;

	/**
	 * Use this constructor if feature is new root feature
	 * 
	 * @param featureModel
	 * @param featureToAdd
	 */
	public AddFeature(HyFeatureModel featureModel, HyFeature featureToAdd, Date date) {
		this.addedFeature = featureToAdd;
		this.featureModel = featureModel;
		this.date = date;
	}

	/**
	 * Use this constructor if feature is added to a default AND group under a
	 * certain feature
	 * 
	 * @param featureModel
	 * @param featureToAdd
	 * @param parentFeature
	 */
	public AddFeature(HyFeatureModel featureModel, HyFeature featureToAdd, HyFeature parentFeature, Date date) {
		this(featureModel, featureToAdd, date);

		this.parentFeature = parentFeature;
	}

	/**
	 * Use this constructor if feature is added to a certain explicit group
	 * 
	 * @param featureModel
	 * @param featureToAdd
	 * @param groupToAddTo
	 */
	public AddFeature(HyFeatureModel featureModel, HyFeature featureToAdd, HyGroup groupToAddTo, Date date) {
		this(featureModel, featureToAdd, date);

		this.groupToAddTo = groupToAddTo;
	}

	public AddFeature(HyFeatureModel featureModel, String featureName, boolean isMandatory, HyFeature parentFeature,
			Date date) {
		this(featureModel, null, parentFeature, date);
		this.addedFeature = createFeature(featureName, isMandatory, date);
	}

	public AddFeature(HyFeatureModel featureModel, String featureName, boolean isMandatory, HyGroup groupToAddTo,
			Date date) {
		this(featureModel, null, groupToAddTo, date);
		this.addedFeature = createFeature(featureName, isMandatory, date);
	}

	private HyFeature createFeature(String featureName, boolean isMandatory, Date date) {
		HyFeature feature = HyFeatureFactory.eINSTANCE.createHyFeature();
		feature.setValidSince(date);

		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName(featureName);
		name.setValidSince(date);
		feature.getNames().add(name);

		HyFeatureType featureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		featureType.setValidSince(date);
		if (isMandatory) {
			featureType.setType(HyFeatureTypeEnum.MANDATORY);
		} else {
			featureType.setType(HyFeatureTypeEnum.OPTIONAL);
		}
		feature.getTypes().add(featureType);

		return feature;
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		featureModel.getFeatures().add(addedFeature);

		if (parentFeature != null) {
			HyGroup group = HyFeatureFactory.eINSTANCE.createHyGroup();
			group.setValidSince(date);
			
			HyGroupType groupType = HyFeatureFactory.eINSTANCE.createHyGroupType();
			groupType.setValidSince(date);
			groupType.setType(HyGroupTypeEnum.AND);
			group.getTypes().add(groupType);
			
			HyFeatureChild featureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			featureChild.setValidSince(date);
			featureChild.setChildGroup(group);
			featureChild.setParent(parentFeature);
			
			HyGroupComposition groupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			groupComposition.setValidSince(date);
			groupComposition.setCompositionOf(group);
			
			featureModel.getGroups().add(group);
			groupToAddTo = group;
		}

		if (groupToAddTo != null) {
			HyGroupComposition oldGroupComposition = HyEvolutionUtil.getValidTemporalElement(groupToAddTo.getParentOf(),
					date);
			oldGroupComposition.setValidUntil(date);

			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			newGroupComposition.setCompositionOf(groupToAddTo);
			newGroupComposition.getFeatures().addAll(oldGroupComposition.getFeatures());
			newGroupComposition.getFeatures().add(addedFeature);

//			newGroupComposition.setSupersedingElement(oldGroupComposition.getSupersedingElement());

			// Check if old group composition can be deleted
			if (oldGroupComposition.getValidSince().equals(oldGroupComposition.getValidUntil())) {
				HyGroupComposition oldSupersededElement = (HyGroupComposition) oldGroupComposition
						.getSupersededElement();
				EcoreUtil.delete(oldGroupComposition);
				newGroupComposition.setSupersededElement(oldSupersededElement);
			} else {
				newGroupComposition.setSupersededElement(oldGroupComposition);
			}
		}
		// Root feature
		else {
			HyRootFeature oldRootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
			HyRootFeature newRootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
			newRootFeature.setValidSince(date);
			featureModel.getRootFeature().add(newRootFeature);
			newRootFeature.setFeature(addedFeature);

			newRootFeature.setSupersedingElement(oldRootFeature.getSupersedingElement());

			// Check if old root feature can be deleted
			if (newRootFeature.getValidSince().equals(newRootFeature.getValidUntil())) {
				HyRootFeature oldSupersededElement = (HyRootFeature) oldRootFeature.getSupersededElement();
				EcoreUtil.delete(oldRootFeature);
				newRootFeature.setSupersededElement(oldSupersededElement);
			} else {
				newRootFeature.setSupersededElement(oldRootFeature);
			}
		}
	}

}
