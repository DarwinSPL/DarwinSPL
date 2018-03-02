package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyModelDiff;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
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
import eu.hyvar.feature.HyVersion;

public class HyFeatureEvolutionUtil {

	public static HyModelDiff getFeatureModelDiff(HyFeatureModel featureModel, Date originDate, Date evolvedDate) {
		return HyEvolutionUtil.getModelDiff(featureModel, originDate, evolvedDate);
	}

	public static boolean isRootFeature(HyFeatureModel featureModel, HyFeature feature, Date date) {
		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		if (rootFeature.getFeature() == feature) {
			return true;
		}
		return false;
	}

	public static List<HyGroup> getChildsOfFeature(HyFeature feature, Date date) {
		List<HyGroup> validGroups = new ArrayList<HyGroup>();

		List<HyFeatureChild> validFeatureChilds = HyEvolutionUtil
				.getValidTemporalElements(feature.getParentOf(), date);
		for (HyFeatureChild featureChild : validFeatureChilds) {
			HyGroup childGroup = featureChild.getChildGroup();
			if(HyEvolutionUtil.isValid(childGroup, date)) {
				validGroups.add(featureChild.getChildGroup());				
			}
		}

		return validGroups;
	}

	public static List<HyFeature> getChildsOfGroup(HyGroup group, Date date) {
		// TODO Assumption: Feature validity >= GroupComposition validity
		return getGroupComposition(group, date).getFeatures();
	}

	public static HyName getName(HyNamedElement namedElement, Date date) {
		return (HyName) HyEvolutionUtil.getValidTemporalElement(namedElement.getNames(), date);
	}

	@SuppressWarnings("unchecked")
	public static List<HyVersion> getFeatureVersions(HyFeature feature, Date date) {
		return (List<HyVersion>) (List<?>) HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date);
	}

	public static HyFeature getRootFeature(HyFeatureModel featureModel, Date date) {
		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		HyFeature rootFeatureFeature = rootFeature.getFeature();
		return rootFeatureFeature;
	}

	public static HyGroupComposition getGroupComposition(HyGroup group, Date date) {
		// TODO assumption: only one valid GroupComposition at a time
		return (HyGroupComposition) HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
	}

	public static HyFeatureChild getFeatureChild(HyGroup group, Date date) {
		// TODO assumption: only one valid FeatureChild of a group at a time
		return (HyFeatureChild) HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
	}

	@SuppressWarnings("unchecked")
	public static List<HyEnum> getEnums(HyFeatureModel featureModel, Date date) {
		return (List<HyEnum>) (List<?>) HyEvolutionUtil.getValidTemporalElements(featureModel.getEnums(), date);
	}

	@SuppressWarnings({ "unchecked" })
	public static List<HyFeatureAttribute> getAttributes(HyFeature feature, Date date) {
		return (List<HyFeatureAttribute>) (List<?>) HyEvolutionUtil.getValidTemporalElements(feature.getAttributes(),
				date);
	}

	@SuppressWarnings("unchecked")
	public static List<HyEnumValue> getEnumLiterals(HyEnum hyEnum, Date date) {
		return (List<HyEnumValue>) (List<?>) HyEvolutionUtil.getValidTemporalElements(hyEnum.getLiterals(), date);
	}

	// public static boolean isDeprecated(HyFeature feature, Date date) {
	// if (feature == null) {
	// System.err.println(
	// "Something bad happened. Could not determine deprecation status of
	// feature as feature given to isDeprecated(...) was null");
	// return false;
	// }
	//
	// if (feature.getDeprecatedSince() != null &&
	// (feature.getDeprecatedSince().compareTo(date) <= 0)) {
	// return true;
	// }
	//
	// return false;
	// }

	// public static HyLinearTemporalElement
	// getMostRecentLinearTemporalElement(EList<?> elements) {
	// if(elements == null || elements.isEmpty()) {
	// System.err.println("Something bad happened. get most recent element of a
	// list of versions. EList<?> given to
	// getMostRecentLinearTemporalElement(...) was null or empty");
	// return null;
	// }
	//
	// for(Object o: elements) {
	// if(o instanceof HyLinearTemporalElement) {
	// HyLinearTemporalElement element = (HyLinearTemporalElement) o;
	// if (element.getSupersedingElement() == null) {
	// return element;
	// }
	// }
	// }
	//
	// return null;
	// }

	public static HyName getMostRecentFeatureName(HyFeature feature) {
		if (feature == null) {
			System.err.println(
					"Something bad happened. Could not get most recent feature name as DEFeature given to getMostRecentFeatureName(...) was null");
			return null;
		}
		List<HyLinearTemporalElement> names = new ArrayList<HyLinearTemporalElement>();
		names.addAll(feature.getNames());

		HyLinearTemporalElement featureName = HyEvolutionUtil.getMostRecentLinearTemporalElement(names);
		if (featureName == null) {
			System.err.println("Something bad happened. Could not get most recent feature name of " + feature
					+ " as getMostRecentLinearTemporalElement returned null. In getMostRecentFeatureName(...)");
		}

		if (featureName instanceof HyName) {
			return ((HyName) featureName);
		} else {
			System.err.println("Something bad happened. Could not get most recent feature name of " + feature
					+ " as getMostRecentLinearTemporalElement returned no element of type Name. In getMostRecentFeatureName(...)");
			return null;
		}
	}
	//
	// // With supersedes
	// public static HyVersion getMostRecentVersion(List<HyVersion> versions) {
	// if(versions == null || versions.isEmpty()) {
	// System.err.println("Something bad happened. get most recent version of a
	// list of versions. List<DEVersion> given to getMostRecentVersion(...) was
	// null or empty");
	// return null;
	// }
	//
	// for (HyVersion version : versions) {
	// if (version.getSupersedingVersions() == null
	// || version.getSupersedingVersions().isEmpty()) {
	// return version;
	// }
	// }
	//
	// return null;
	// }
	//
	// // Without supersedes!
	// public static HyTemporalElement getMostRecentTemporalElement(
	// List<HyTemporalElement> elements) {
	//
	// if(elements == null || elements.isEmpty()) {
	// System.err.println("Something bad happened. get most recent element of a
	// list of eleents. List<TemporalElement> given to
	// getMostRecentTemporalElement(...) was null or empty");
	// return null;
	// }
	//
	// HyTemporalElement mostRecentVersion = null;
	//
	// for (HyTemporalElement version : elements) {
	// if (version.getValidUntil() == null) {
	// return version;
	// }
	//
	// if (mostRecentVersion.getValidUntil().before(
	// version.getValidUntil())
	// || mostRecentVersion == null) {
	// mostRecentVersion = version;
	// }
	// }
	//
	// return mostRecentVersion;
	// }

	public static List<HyFeature> getFeaturesOfGroup(HyGroup group, Date date) {
		if (group == null) {
			return new ArrayList<HyFeature>();
		}

		HyGroupComposition validGroupComposition = HyEvolutionUtil
				.getValidTemporalElement(group.getParentOf(), date);

		if (validGroupComposition == null) {
			System.err.println("Something Bad Happened. Group: " + group
					+ " has no or multiple valid compositions at date: " + date);

			return null;
		}

		return validGroupComposition.getFeatures();
	}

	public static boolean isAlternative(HyGroup group, Date date) {
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
		if (type.getType() == HyGroupTypeEnum.ALTERNATIVE) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isOr(HyGroup group, Date date) {
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
		if (type.getType() == HyGroupTypeEnum.OR) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isAnd(HyGroup group, Date date) {
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
		if (type.getType() == HyGroupTypeEnum.AND) {
			return true;
		} else {
			return false;
		}
	}

	public static HyGroup getParentGroupOfFeature(HyFeature feature, Date date) {
		if (feature == null) {
			return null;
		}

		HyTemporalElement validGroupComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(),
				date);

		if (validGroupComposition == null) {
			try {
				if(HyFeatureUtil.isRootFeature(feature, date)) {
					System.out.println("Tried to get parent group of root feature");
				}
				else {
					System.err.println("Something bad happened. Feature " + feature
							+ " is not member of any group or member of multiple groups at date " + date);
				}
				return null;
			} catch (HyFeatureModelWellFormednessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (validGroupComposition instanceof HyGroupComposition) {
			return ((HyGroupComposition) validGroupComposition).getCompositionOf();
		} else {
			System.err.println("Something bad happened. HyGroupComposition expected but not received at date " + date
					+ " in method getParentGroupOfFeature");
			return null;
		}
	}

	public static HyFeature getParentFeatureOfFeature(HyFeature feature, Date date) {
		return getParentOfGroup(getParentGroupOfFeature(feature, date), date);
	}

	public static HyFeature getParentOfGroup(HyGroup group, Date date) {
		if (group == null) {
			return null;
		}

		HyTemporalElement validFeatureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);

		if (validFeatureChild == null) {
			System.err.println("Something bad happened. Group " + group + " has no or multiple parent at date " + date);
			return null;
		}

		if (validFeatureChild instanceof HyFeatureChild) {
			return ((HyFeatureChild) validFeatureChild).getParent();
		} else {
			System.err.println("Something bad happened. HyFeatureChild expected but not received at date " + date
					+ " in method getParentOfGroup");
			return null;
		}
	}

	public static HyFeatureType getType(HyFeature feature, Date date) {
		return HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
	}

	public static HyGroupType getType(HyGroup group, Date date) {
		return HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
	}

	public static List<HyFeature> getFeatures(HyFeatureModel featureModel, Date date) {
		return HyEvolutionUtil.getValidTemporalElements(featureModel.getFeatures(), date);
	}

	public static List<HyGroup> getGroups(HyFeatureModel featureModel, Date date) {
		return HyEvolutionUtil.getValidTemporalElements(featureModel.getGroups(), date);
	}

	public static boolean isMandatory(HyFeature feature, Date date) {
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
		if (type.getType() == HyFeatureTypeEnum.MANDATORY) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isOptional(HyFeature feature, Date date) {
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
		if (type.getType() == HyFeatureTypeEnum.OPTIONAL) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLeaf(HyFeature feature, Date date) {
		List<HyFeatureChild> children = feature.getParentOf();

		if (children == null || HyEvolutionUtil.getValidTemporalElements(children, date).isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isInGroup(HyFeature feature, HyGroup group, Date date) {
		return getFeaturesOfGroup(group, date).contains(feature);
	}

	/**
	 * Get all features in the subtree under @feature
	 * 
	 * @param feature
	 * @param date
	 * @return
	 */
	public static List<HyFeature> getFeaturesOfSubtree(HyFeature feature, Date date, int depth) {
		List<HyFeature> features = new ArrayList<HyFeature>();

		for (HyGroup group : getChildsOfFeature(feature, date)) {
			List<HyFeature> subFeatures = getFeaturesOfGroup(group, date);
			features.addAll(subFeatures);

			for (HyFeature subFeature : subFeatures) {
				features.addAll(getFeaturesOfSubtree(subFeature, date, depth));	
			}
		}

		return features;
	}

	public static List<HyFeature> getFeatureOfSubtree(HyGroup group, Date date, int depth) {
		depth++;
		List<HyFeature> features = new ArrayList<HyFeature>();
		
		for (HyFeature groupFeature : getFeaturesOfGroup(group, date)) {
			features.add(groupFeature);

			features.addAll(getFeaturesOfSubtree(groupFeature, date, depth));
		}

		return features;
	}

	public static HyGroup getRandomGroup(HyFeatureModel featureModel, Date date) {
		List<HyGroup> validGroups = HyFeatureEvolutionUtil.getGroups(featureModel, date);
		if (validGroups.size() < 1) {
			return null;
		}
		Random rand = new Random();
		int groupIndex = rand.nextInt(validGroups.size());
		return validGroups.get(groupIndex);
	}
	
	public static HyGroup getRandomGroupWithType(HyFeatureModel featureModel, HyGroupTypeEnum allowedGroupType, Date date) {
		List<HyGroupTypeEnum> groupTypes = new ArrayList<HyGroupTypeEnum>(1);
		groupTypes.add(allowedGroupType);
		
		return getRandomGroupWithType(featureModel, groupTypes, date);
	}
	
	public static HyGroup getRandomGroupWithType(HyFeatureModel featureModel, List<HyGroupTypeEnum> allowedGroupTypes, Date date) {
		List<HyGroup> potentialGroups = new ArrayList<HyGroup>();

		outerFor:
		for(HyGroup group: HyFeatureEvolutionUtil.getGroups(featureModel, date)) {
			HyGroupTypeEnum groupType = HyFeatureEvolutionUtil.getType(group, date).getType();
			
			for(HyGroupTypeEnum allowedType: allowedGroupTypes) {
				if(groupType.equals(allowedType)) {
					potentialGroups.add(group);
					continue outerFor;
				}
			}
		}
		
		Random rand = new Random();
		int groupIndex = rand.nextInt(potentialGroups.size());
		return potentialGroups.get(groupIndex);
	}

	public static HyGroup getRandomGroup(HyFeatureModel featureModel, List<HyGroup> excludedGroups, Date date) {
		List<HyGroup> validGroups = HyFeatureEvolutionUtil.getGroups(featureModel, date);
		validGroups.removeAll(excludedGroups);

		if (validGroups.size() < 1) {
			return null;
		}
		Random rand = new Random();
		int groupIndex = rand.nextInt(validGroups.size());
		return validGroups.get(groupIndex);
	}

	public static HyGroup getRandomGroup(HyFeatureModel featureModel, HyGroup excludedGroup, Date date) {
		List<HyGroup> validGroups = HyFeatureEvolutionUtil.getGroups(featureModel, date);
		validGroups.remove(excludedGroup);

		if (validGroups.size() < 1) {
			return null;
		}
		Random rand = new Random();
		int groupIndex = rand.nextInt(validGroups.size());
		return validGroups.get(groupIndex);
	}

	public static HyFeature getRandomFeature(HyFeatureModel featureModel, Date date) {
		List<HyFeature> validFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, date);
		if (validFeatures.size() < 1) {
			return null;
		}
		Random rand = new Random();
		int index = rand.nextInt(validFeatures.size());
		return validFeatures.get(index);
	}

	public static HyFeature getRandomFeature(HyFeatureModel featureModel, List<HyFeature> excludedFeatures, Date date) {
		List<HyFeature> validFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, date);
		validFeatures.removeAll(excludedFeatures);
		if (validFeatures.size() < 1) {
			return null;
		}
		Random rand = new Random();
		int index = rand.nextInt(validFeatures.size());
		if (validFeatures.get(index) == null) {
			System.out.println("WTDF?");
		}
		return validFeatures.get(index);
	}

	public static HyFeature getRandomFeature(HyFeatureModel featureModel, HyFeature excludedFeature, Date date) {
		List<HyFeature> validFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, date);
		validFeatures.remove(excludedFeature);
		if (validFeatures.size() < 1) {
			return null;
		}
		Random rand = new Random();
		int index = rand.nextInt(validFeatures.size());
		if (validFeatures.get(index) == null) {
			System.out.println("???");
		}
		return validFeatures.get(index);
	}

	public static HyFeature getRandomNonRootFeature(HyFeatureModel featureModel, Date date) {
		return getRandomFeature(featureModel, HyFeatureEvolutionUtil.getRootFeature(featureModel, date), date);
	}
	
	public static List<HyVersion> getVersionsOfFeature(HyFeature feature, Date date) {
		List<HyVersion> versions = new ArrayList<HyVersion>(feature.getVersions().size());
		
		versions.addAll(HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date));
		
		return versions;
	}
	
	public static HyName getLastValidName(HyNamedElement namedElement) {
		
		Map<Date, HyName> nameDateMap = new HashMap<Date, HyName>();
		
		for(HyName hyName: namedElement.getNames()) {
			if(hyName.getValidUntil() == null) {
				return hyName;
			}
			else {
				nameDateMap.put(hyName.getValidUntil(), hyName);
			}
		}
		
		List<Date> dateList = new ArrayList<Date>(nameDateMap.keySet());
		Collections.sort(dateList);
		Date lastDate = dateList.get(dateList.size()-1);
		return nameDateMap.get(lastDate);
	}
	
	public static void removeFeatureFromGroup(HyFeature feature, Date date) {
		HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		
		if(groupComposition == null) {
			return;
		}
		
		if(groupComposition.getFeatures().size() <= 1) {
			// Complete Group has to be invalidated
			HyGroup group = groupComposition.getCompositionOf();
			group.setValidUntil(date);
			HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date).setValidUntil(date);
		}
		else {
			// remove feature from group and set validities of group compositions
			HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
			newGroupComposition.setValidSince(date);
			newGroupComposition.setCompositionOf(groupComposition.getCompositionOf());
			newGroupComposition.getFeatures().addAll(groupComposition.getFeatures());
			newGroupComposition.getFeatures().remove(feature);
		}
		groupComposition.setValidUntil(date);
	}
}
