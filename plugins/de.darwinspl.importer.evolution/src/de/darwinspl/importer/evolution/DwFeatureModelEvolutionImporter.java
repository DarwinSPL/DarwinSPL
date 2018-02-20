package de.darwinspl.importer.evolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public abstract class DwFeatureModelEvolutionImporter<T> {

	/**
	 * Creates a new group if necessary.
	 * 
	 * @param featureToBeAdded
	 * @param groupCompositionOfFeatureToBeAdded
	 * @param parentInMergedModel
	 * @param groupTypeEnum
	 * @param featureMap
	 * @param mergedFeatureModel
	 * @param date
	 */
	protected void addFeatureToBestMatchingGroup(HyFeature featureToBeAdded,
			HyGroupComposition groupCompositionOfFeatureToBeAdded, HyFeature parentInMergedModel,
			HyGroupTypeEnum groupTypeEnum, Map<HyFeature, HyFeature> featureMap, HyFeatureModel mergedFeatureModel,
			Date date) {
		HyGroup matchingGroup = null;
		int maximumAmountOfMatchingSiblings = 0;

		for (HyFeatureChild featureChild : HyEvolutionUtil.getValidTemporalElements(parentInMergedModel.getParentOf(),
				date)) {
			HyGroup childGroup = featureChild.getChildGroup();
			if (HyEvolutionUtil.getValidTemporalElement(childGroup.getTypes(), date).getType().equals(groupTypeEnum)) {

				int amountOfMatchingSiblings = 0;

				for (HyFeature featureInGroup : groupCompositionOfFeatureToBeAdded.getFeatures()) {
					if (featureInGroup == featureToBeAdded) {
						continue;
					}

					if (featureMap.get(featureInGroup) != null) {
						amountOfMatchingSiblings++;
					}
				}

				if (amountOfMatchingSiblings > maximumAmountOfMatchingSiblings) {
					amountOfMatchingSiblings = maximumAmountOfMatchingSiblings;
					matchingGroup = childGroup;
				}
			}
		}

		if (matchingGroup != null) {
			// Add feature to best matching alternative group
			HyGroupComposition oldGroupComposition = HyEvolutionUtil
					.getValidTemporalElement(matchingGroup.getParentOf(), date);
			oldGroupComposition.setValidUntil(date);

			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			matchingGroup.getParentOf().add(newGroupComposition);

			for (HyFeature groupFeature : oldGroupComposition.getFeatures()) {
				newGroupComposition.getFeatures().add(groupFeature);
			}
			newGroupComposition.getFeatures().add(featureToBeAdded);
		} else {
			// create a new alternative group
			HyGroup newAlternativeGroup = HyFeatureFactory.eINSTANCE.createHyGroup();
			newAlternativeGroup.setValidSince(date);
			mergedFeatureModel.getGroups().add(newAlternativeGroup);

			HyFeatureChild newFeatureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			newFeatureChild.setValidSince(date);
			newFeatureChild.setChildGroup(newAlternativeGroup);
			newFeatureChild.setParent(parentInMergedModel);

			HyGroupType newGroupType = HyFeatureFactory.eINSTANCE.createHyGroupType();
			newGroupType.setValidSince(date);
			newGroupType.setType(groupTypeEnum);
			newAlternativeGroup.getTypes().add(newGroupType);

			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			newGroupComposition.getFeatures().add(featureToBeAdded);
			newGroupComposition.setCompositionOf(newAlternativeGroup);
		}

		groupCompositionOfFeatureToBeAdded.getFeatures().remove(featureToBeAdded);
	}

	protected boolean checkForEquality(EObject o1, EObject o2, Date date) {
		if (o1 instanceof HyNamedElement && o2 instanceof HyNamedElement) {
			HyNamedElement namedElement1 = (HyNamedElement) o1;
			HyNamedElement namedElement2 = (HyNamedElement) o2;

			HyName name1 = HyEvolutionUtil.getValidTemporalElement(namedElement1.getNames(), date);
			HyName name2 = HyEvolutionUtil.getValidTemporalElement(namedElement2.getNames(), date);

			if (name1.getName().equals(name2.getName())) {
				return true;
			} else {
				return false;
			}
		} else if (o1 instanceof HyEnumLiteral && o2 instanceof HyEnumLiteral) {
			HyEnumLiteral enumLiteral1 = (HyEnumLiteral) o1;
			HyEnumLiteral enumLiteral2 = (HyEnumLiteral) o2;

			if (enumLiteral1.getName().equals(enumLiteral2.getName())) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param elementToBeChecked
	 * @param elementsOfMergedModel
	 * @return null if no equivalent element exists. Otherwise the equivalentElement
	 */
	protected <S extends EObject> S checkIfElementAlreadyExists(S elementToBeChecked, List<S> elementsOfMergedModel,
			Date date) {
		for (S featureOfMergedModel : elementsOfMergedModel) {

			if (checkForEquality(elementToBeChecked, featureOfMergedModel, date)) {
				return featureOfMergedModel;
			}
		}

		return null;
	}

	protected abstract HyFeatureModel importFeatureModel(T featureModel);

	/**
	 * Merges multiple feature model evolution snapshots to one Temporal Feature
	 * Model
	 * 
	 * @param featureModels
	 *            Each feature model has to be associated to a date at which the
	 *            changes have occured.
	 * @return The whole feature model history merged into one TFM.
	 * @throws Exception
	 */
	public HyFeatureModel importFeatureModels(Map<T, Date> featureModels) throws Exception {
		Map<Date, HyFeatureModel> darwinSPLfeatureModels = new HashMap<Date, HyFeatureModel>();

		for (T t : featureModels.keySet()) {
			HyFeatureModel importedFeatureModel = importFeatureModel(t);
			if (importedFeatureModel != null) {
				darwinSPLfeatureModels.put(featureModels.get(t), importedFeatureModel);
			}
		}

		HyFeatureModel mergedFeatureModel = mergeFeatureModels(darwinSPLfeatureModels);

		return mergedFeatureModel;
	}

	protected void mergeEnumAttributes(HyEnumAttribute equivalentEnumAttribute,
			HyEnumAttribute enumAttributeOfFeatureToBeMerged, Date date) throws Exception {
		if (equivalentEnumAttribute.getEnumType() == null || enumAttributeOfFeatureToBeMerged.getEnumType() == null) {
			throw new Exception("Enum type of attribute "
					+ HyEvolutionUtil.getValidTemporalElement(equivalentEnumAttribute.getNames(), date).getName()
					+ " of either the merged or the input model is null. Aborting Merge!");
		}

		if (equivalentEnumAttribute.getEnumType().getName()
				.equals(enumAttributeOfFeatureToBeMerged.getEnumType().getName())) {

			List<HyEnumLiteral> literalsToBeAdded = new ArrayList<HyEnumLiteral>();

			for (HyEnumLiteral enumLiteralOfFeatureAttributeToBeMerged : enumAttributeOfFeatureToBeMerged.getEnumType()
					.getLiterals()) {

				HyEnumLiteral equivalentEnumLiteral = checkIfElementAlreadyExists(
						enumLiteralOfFeatureAttributeToBeMerged, HyEvolutionUtil.getValidTemporalElements(
								equivalentEnumAttribute.getEnumType().getLiterals(), date),
						date);
				boolean equivalentLiteralExists = (equivalentEnumLiteral != null);

				if (!equivalentLiteralExists) {
					literalsToBeAdded.add(enumLiteralOfFeatureAttributeToBeMerged);
				}
			}

			List<Integer> alreadyUsedLiteralValues = new ArrayList<Integer>();

			if (!literalsToBeAdded.isEmpty()) {
				for (HyEnumLiteral literalOfEquivalentAttribute : equivalentEnumAttribute.getEnumType().getLiterals()) {
					alreadyUsedLiteralValues.add(literalOfEquivalentAttribute.getValue());
				}
			}

			for (HyEnumLiteral literalToBeAdded : literalsToBeAdded) {
				int value = 0;
				while (alreadyUsedLiteralValues.contains(value)) {
					value++;
				}
				alreadyUsedLiteralValues.add(value);

				literalToBeAdded.setValue(value);
				equivalentEnumAttribute.getEnumType().getLiterals().add(literalToBeAdded);
			}
		} else {
			throw new Exception("Attribute names of "
					+ HyEvolutionUtil.getValidTemporalElement(equivalentEnumAttribute.getNames(), date).getName()
					+ " are the same but enum types do not match. Aborting merge!");
		}

	}

	protected List<HyFeatureAttribute> mergeFeatureAttributes(HyFeature featureToBeMerged,
			HyFeature equivalentFeatureOfMergedModel, Date date) throws Exception {
		// Step 2: check whether attributes are matching.
		List<HyFeatureAttribute> attributesToBeAddedToEquivalentFeature = new ArrayList<HyFeatureAttribute>();

		for (HyFeatureAttribute attributeOfFeatureToBeMerged : featureToBeMerged.getAttributes()) {

			HyFeatureAttribute equivalentAttribute = checkIfElementAlreadyExists(attributeOfFeatureToBeMerged,
					HyEvolutionUtil.getValidTemporalElements(equivalentFeatureOfMergedModel.getAttributes(), date),
					date);
			boolean attributeAlreadyExists = (equivalentAttribute != null);

			if (!attributeAlreadyExists) {
				attributesToBeAddedToEquivalentFeature.add(attributeOfFeatureToBeMerged);
			} else {
				// Step 1.a: Check whether attribute domains are the same. If not, extend them
				// to have the union of their domains
				if (equivalentAttribute instanceof HyNumberAttribute
						&& attributeOfFeatureToBeMerged instanceof HyNumberAttribute) {
					HyNumberAttribute equivalentNumberAttribute = (HyNumberAttribute) equivalentAttribute;
					HyNumberAttribute numberAttributeOfFeatureToBeMerged = (HyNumberAttribute) attributeOfFeatureToBeMerged;

					int minimum = Math.min(equivalentNumberAttribute.getMin(),
							numberAttributeOfFeatureToBeMerged.getMin());
					int maximum = Math.max(equivalentNumberAttribute.getMax(),
							numberAttributeOfFeatureToBeMerged.getMax());

					equivalentNumberAttribute.setMin(minimum);
					equivalentNumberAttribute.setMax(maximum);
				} else if (equivalentAttribute instanceof HyBooleanAttribute
						&& attributeOfFeatureToBeMerged instanceof HyBooleanAttribute) {
					// nothing to do.
				} else if (equivalentAttribute instanceof HyEnumAttribute
						&& attributeOfFeatureToBeMerged instanceof HyEnumAttribute) {
					HyEnumAttribute equivalentEnumAttribute = (HyEnumAttribute) equivalentAttribute;
					HyEnumAttribute enumAttributeOfFeatureToBeMerged = (HyEnumAttribute) attributeOfFeatureToBeMerged;
					mergeEnumAttributes(equivalentEnumAttribute, enumAttributeOfFeatureToBeMerged, date);
				} else if (equivalentAttribute instanceof HyStringAttribute
						&& attributeOfFeatureToBeMerged instanceof HyStringAttribute) {
					// nothing to do.
				} else {
					throw new Exception("Attributes "
							+ HyEvolutionUtil.getValidTemporalElement(equivalentAttribute.getNames(), date).getName()
							+ " have the same name but have different types. Cannot merge.");
				}
			}

		}

		for (HyFeatureAttribute attributeToBeAdded : attributesToBeAddedToEquivalentFeature) {
			attributeToBeAdded.setValidSince(date);
			equivalentFeatureOfMergedModel.getAttributes().add(attributeToBeAdded);
		}

		return attributesToBeAddedToEquivalentFeature;
	}

	/**
	 * No evolution shall exist in the input models.
	 * 
	 * @param featureModels
	 * @return
	 * @throws Exception
	 */
	protected HyFeatureModel mergeFeatureModels(Map<Date, HyFeatureModel> featureModels) throws Exception {
		HyFeatureModel mergedFeatureModel = HyFeatureFactory.eINSTANCE.createHyFeatureModel();

		List<Date> sortedDateList = new ArrayList<Date>(featureModels.keySet());
		sortedDateList.remove(null);
		Collections.sort(sortedDateList);

		if (featureModels.get(null) != null) {
			mergeFeatureModel(featureModels, mergedFeatureModel, null);
		}

		for (Date date : sortedDateList) {
			mergeFeatureModel(featureModels, mergedFeatureModel, date);
		}

		return mergedFeatureModel;
	}

	protected void mergeFeatureModel(Map<Date, HyFeatureModel> featureModels, HyFeatureModel mergedFeatureModel,
			Date date) throws Exception {
		// Key is the feature of the input model and value is the feature of the merged
		// model.
		Map<HyFeature, HyFeature> featureMap = new HashMap<HyFeature, HyFeature>();
		Map<HyGroup, HyGroup> groupMap = new HashMap<HyGroup, HyGroup>();

		List<HyFeature> featuresToInvalidate = new ArrayList<HyFeature>(mergedFeatureModel.getFeatures());

		// Step 1: Check that each feature / attribute exists. If not create it and set
		// valid since. If a feature / attribute existed before, but not anymore, set
		// valid until.
		HyFeatureModel modelToBeMerged = featureModels.get(date);

		List<HyFeature> featuresToBeAddedToMergedModel = new ArrayList<HyFeature>();

		List<HyFeatureAttribute> addedFeatureAttributes = new ArrayList<HyFeatureAttribute>();

		for(HyGroup groupToBeMerged: modelToBeMerged.getGroups()) {
			HyGroup equivalentGroup = checkIfElementAlreadyExists(groupToBeMerged, HyEvolutionUtil.getValidTemporalElements(mergedFeatureModel.getGroups(), date), date);
			
			if(equivalentGroup != null) {
				groupMap.put(groupToBeMerged, equivalentGroup);
			}
		}
		
		for (HyFeature featureToBeMerged : modelToBeMerged.getFeatures()) {

			HyFeature equivalentFeature = checkIfElementAlreadyExists(featureToBeMerged,
					HyEvolutionUtil.getValidTemporalElements(mergedFeatureModel.getFeatures(), date), date);
			boolean featureAlreadyExists = (equivalentFeature != null);

			if (!featureAlreadyExists) {
				featuresToBeAddedToMergedModel.add(featureToBeMerged);
			} else {
				featuresToInvalidate.remove(equivalentFeature);
				featureMap.put(featureToBeMerged, equivalentFeature);
				addedFeatureAttributes.addAll(mergeFeatureAttributes(featureToBeMerged, equivalentFeature, date));
			}
		}
		
		for(HyGroup groupToBeMerged: modelToBeMerged.getGroups()) {
			for(HyGroup groupFromMergedModel : mergedFeatureModel.getGroups()) {
				
				int amountOfSimilarFeatures = 0;
				
				List<HyFeature> featuresOfMergedGroup = HyFeatureEvolutionUtil.getFeaturesOfGroup(groupFromMergedModel, date);
				
				for(HyFeature featureOfGroupToBeMerged: HyFeatureEvolutionUtil.getFeaturesOfGroup(groupToBeMerged, date)) {
					if(featuresOfMergedGroup.contains(featureMap.get(featureOfGroupToBeMerged))) {
						amountOfSimilarFeatures++;
					}
				}
					
				double sameFeatureRatio = (double)amountOfSimilarFeatures / (double)featuresOfMergedGroup.size();
				if(sameFeatureRatio >= 0.75) {
					groupMap.put(groupToBeMerged, groupFromMergedModel);
				}
			}
		}

		moveFeaturesIfTheyHaveBeenMovedInInputModel(mergedFeatureModel, featureMap, date);
		
		updateFeatureTypes(mergedFeatureModel, featureMap, date);
		
		updateGroupTypes(groupMap, date);

		mergeFeatures(featuresToBeAddedToMergedModel, mergedFeatureModel, featureMap, date);

		// handle enums. Only considered enums which are used by feature attributes.
		Set<HyEnum> enums = new HashSet<HyEnum>();

		for (HyFeatureAttribute addedFeatureAttribute : addedFeatureAttributes) {
			if (addedFeatureAttribute instanceof HyEnumAttribute) {
				HyEnumAttribute enumAttribute = (HyEnumAttribute) addedFeatureAttribute;
				enums.add(enumAttribute.getEnumType());
			}
		}

		mergedFeatureModel.getEnums().addAll(enums);

		// Invalidate features which do not exist anymore. Update group composition.
		for (HyFeature featureToInvalidate : featuresToInvalidate) {
			HyFeatureEvolutionUtil.removeFeatureFromGroup(featureToInvalidate, date);
			featureToInvalidate.setValidUntil(date);
		}
		
	}
	
	


	protected void updateGroupTypes(Map<HyGroup, HyGroup> groupMap, Date date) {
		for(Entry<HyGroup, HyGroup> entry : groupMap.entrySet()) {
			HyGroupType groupTypeOfGroupToBeMerged = HyFeatureEvolutionUtil.getType(entry.getKey(), date);
			HyGroupType groupTypeOfMergedGroup = HyFeatureEvolutionUtil.getType(entry.getValue(), date);
			
			if(!groupTypeOfGroupToBeMerged.getType().equals(groupTypeOfMergedGroup.getType())) {
				groupTypeOfMergedGroup.setValidUntil(date);
				
				HyGroupType newGroupType = HyFeatureFactory.eINSTANCE.createHyGroupType();
				newGroupType.setValidSince(date);
				newGroupType.setType(groupTypeOfGroupToBeMerged.getType());
				entry.getValue().getTypes().add(newGroupType);
			}
		}
	}

	protected void updateFeatureTypes(HyFeatureModel mergedFeatureModel, Map<HyFeature, HyFeature> featureMap,
			Date date) {
		for(Entry<HyFeature, HyFeature> entry: featureMap.entrySet()) {
			// key feature from input mode, value feature from merged model
			HyFeatureType inputType = HyFeatureEvolutionUtil.getType(entry.getKey(), date);
			HyFeatureType mergedType = HyFeatureEvolutionUtil.getType(entry.getValue(), date);
			
			if(!inputType.getType().equals(mergedType.getType())) {
				mergedType.setValidUntil(date);
				
				HyFeatureType newFeatureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
				newFeatureType.setValidSince(date);
				newFeatureType.setType(inputType.getType());
				
				entry.getValue().getTypes().add(newFeatureType);
			}
		}
	}

	protected void mergeFeatures(List<HyFeature> featuresToBeAddedToMergedModel, HyFeatureModel mergedFeatureModel,
			Map<HyFeature, HyFeature> featureMap, Date date) throws Exception {
		for (HyFeature featureToBeAdded : featuresToBeAddedToMergedModel) {
			HyFeatureModel oldFeatureModel = featureToBeAdded.getFeatureModel();
			mergedFeatureModel.getFeatures().add(featureToBeAdded);
			featureToBeAdded.setValidSince(date);
			featureToBeAdded.setValidUntil(null);

			// clear everything from evolution.
			HyName validName = HyEvolutionUtil.getValidTemporalElement(featureToBeAdded.getNames(), date);
			validName.setValidSince(date);
			validName.setValidUntil(null);
			featureToBeAdded.getNames().clear();
			featureToBeAdded.getNames().add(validName);

			HyFeatureType validType = HyEvolutionUtil.getValidTemporalElement(featureToBeAdded.getTypes(), date);
			validType.setValidSince(date);
			validType.setValidUntil(null);
			featureToBeAdded.getTypes().clear();
			featureToBeAdded.getTypes().add(validType);

			List<HyFeatureChild> validFeatureChildren = HyEvolutionUtil
					.getValidTemporalElements(featureToBeAdded.getParentOf(), date);
			featureToBeAdded.getParentOf().clear();
			for (HyFeatureChild featureChild : validFeatureChildren) {
				featureChild.setValidSince(date);
				featureChild.setValidUntil(null);

				HyGroup group = featureChild.getChildGroup();
				mergedFeatureModel.getGroups().add(group);
				group.setValidSince(date);
				group.setValidUntil(null);

				HyGroupType validGroupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
				group.getTypes().clear();
				validGroupType.setValidSince(date);
				validGroupType.setValidUntil(null);
				group.getTypes().add(validGroupType);

				HyGroupComposition validGroupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(),
						date);
				validGroupComposition.setValidSince(date);
				validGroupComposition.setValidUntil(null);
				group.getParentOf().clear();
				group.getParentOf().add(validGroupComposition);
				
				featureToBeAdded.getParentOf().add(featureChild);
			}

			// Put feature in correct group

			HyGroupComposition groupComposition = HyEvolutionUtil
					.getValidTemporalElement(featureToBeAdded.getGroupMembership(), date);

			if (groupComposition != null) {
				HyGroup group = groupComposition.getCompositionOf();
				HyFeatureChild featureChildOfGroup = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
				HyFeature parentFeatureInInputModel = featureChildOfGroup.getParent();

				if (featuresToBeAddedToMergedModel.contains(parentFeatureInInputModel)) {
					// parent feature is also added to the new model. We are done.
					continue;
				}

				HyFeature parentInMergedModel = featureMap.get(parentFeatureInInputModel);
				if (parentInMergedModel != null) {
					HyGroupType groupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);

					HyGroupTypeEnum groupTypeEnum = groupType.getType();
					addFeatureToBestMatchingGroup(featureToBeAdded, groupComposition, parentInMergedModel,
							groupTypeEnum, featureMap, mergedFeatureModel, date);
				} else {
					throw new Exception("We have a problem. The parent of the feature "
							+ HyEvolutionUtil.getValidTemporalElement(featureToBeAdded.getNames(), date).getName()
							+ " is neither newly added to the merged model nor is it already existent in it. Aborting whole merging process");
				}
			} else {
				HyRootFeature oldFeatureModelRootFeature = HyEvolutionUtil
						.getValidTemporalElement(oldFeatureModel.getRootFeature(), date);

				if (oldFeatureModelRootFeature == null || oldFeatureModelRootFeature.getFeature() != featureToBeAdded) {
					throw new Exception("Feature "
							+ HyEvolutionUtil.getValidTemporalElement(featureToBeAdded.getNames(), date).getName()
							+ " did not have a group but is no root feature. Aborted merge.");
				}

				HyRootFeature oldRootFeature = HyEvolutionUtil
						.getValidTemporalElement(mergedFeatureModel.getRootFeature(), date);
				if (oldRootFeature != null) {
					oldRootFeature.setValidUntil(date);
				}

				HyRootFeature newRootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
				newRootFeature.setValidSince(date);
				newRootFeature.setFeature(featureToBeAdded);
				mergedFeatureModel.getRootFeature().add(newRootFeature);
			}
		}
	}

	protected void moveFeaturesIfTheyHaveBeenMovedInInputModel(HyFeatureModel mergedFeatureModel,
			Map<HyFeature, HyFeature> featureMap, Date date) {
		for (Entry<HyFeature, HyFeature> featureEntrySet : featureMap.entrySet()) {
			HyFeature parentOfMergedFeature = HyFeatureEvolutionUtil
					.getParentFeatureOfFeature(featureEntrySet.getValue(), date);
			HyFeature parentFeatureFromInputModel = HyFeatureEvolutionUtil
					.getParentFeatureOfFeature(featureEntrySet.getKey(), date);

			if (parentFeatureFromInputModel == null) {
				// seems to be new root.
				continue;
			}

			HyFeature equivalentToParentFromInputModel = featureMap.get(parentFeatureFromInputModel);

			if (equivalentToParentFromInputModel == null) {
				// parent will be added in the next step. Probably nothing to do.
			} else if (equivalentToParentFromInputModel == parentOfMergedFeature) {
				// parent stayed the same. Nothing to do.
			} else {
				// parents are different.
				HyGroupComposition groupCompositionOfFeatureFromInputModel = HyEvolutionUtil
						.getValidTemporalElement(featureEntrySet.getKey().getGroupMembership(), date);
				HyGroupTypeEnum groupTypeOfGroupOfFeatureFromInputModel = HyEvolutionUtil.getValidTemporalElement(
						groupCompositionOfFeatureFromInputModel.getCompositionOf().getTypes(), date).getType();
				
				addFeatureToBestMatchingGroup(featureEntrySet.getValue(), groupCompositionOfFeatureFromInputModel,
						equivalentToParentFromInputModel, groupTypeOfGroupOfFeatureFromInputModel, featureMap,
						mergedFeatureModel, date);

				HyFeatureEvolutionUtil.removeFeatureFromGroup(featureEntrySet.getValue(), date);
			}
		}
	}

}
