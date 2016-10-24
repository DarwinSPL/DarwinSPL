package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyModelDiff;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;

public class HyFeatureEvolutionUtil {

	
	public static HyModelDiff getFeatureModelDiff(HyFeatureModel featureModel, Date originDate, Date evolvedDate) {
		return HyEvolutionUtil.getModelDiff(featureModel, originDate, evolvedDate);
	}
	
	public static boolean isRootFeature(HyFeatureModel featureModel, HyFeature feature, Date date) {
		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		if(rootFeature.getFeature() == feature) {
			return true;
		}
		return false;
	}
	
	public static List<HyGroup> getValidChildsOfFeature(HyFeature feature, Date date) {
		List<HyGroup> validGroups = new ArrayList<HyGroup>();

		@SuppressWarnings("unchecked")
		List<HyFeatureChild> validFeatureChilds = (List<HyFeatureChild>) (List<?>) HyEvolutionUtil.getValidTemporalElements(
				feature.getParentOf(), date);
		for (HyFeatureChild featureChild : validFeatureChilds) {
			// TODO Assumption: Group validity >= featureChild validity
			validGroups.add(featureChild.getChildGroup());
		}

		return validGroups;
	}

	public static List<HyFeature> getValidChildsOfGroup(HyGroup group, Date date) {
		// TODO Assumption: Feature validity >= GroupComposition validity
		return getValidGroupComposition(group, date).getFeatures();
	}

	public static HyName getValidName(EList<HyName> names, Date date) {
		return (HyName) HyEvolutionUtil.getValidTemporalElement(names, date);
	}

	@SuppressWarnings("unchecked")
	public static List<HyVersion> getValidFeatureVersions(HyFeature feature, Date date) {
		return (List<HyVersion>) (List<?>) HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date);
	}

	public static HyFeature getValidRootFeature(HyFeatureModel featureModel, Date date) {
		HyTemporalElement validTemporalElement = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		HyRootFeature rootFeature = (HyRootFeature) validTemporalElement;
		HyFeature rootFeatureFeature = rootFeature.getFeature();
		return rootFeatureFeature;
	}

	public static HyGroupComposition getValidGroupComposition(HyGroup group, Date date) {
		// TODO assumption: only one valid GroupComposition at a time
		return (HyGroupComposition) HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
	}

	public static HyFeatureChild getValidFeatureChild(HyGroup group, Date date) {
		// TODO assumption: only one valid FeatureChild of a group at a time
		return (HyFeatureChild) HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
	}

	@SuppressWarnings("unchecked")
	public static List<HyEnum> getValidEnums(HyFeatureModel featureModel, Date date) {
		return (List<HyEnum>) (List<?>) HyEvolutionUtil.getValidTemporalElements(featureModel.getEnums(), date);
	}

	@SuppressWarnings({ "unchecked" })
	public static List<HyFeatureAttribute> getValidAttributes(HyFeature feature, Date date) {
		return (List<HyFeatureAttribute>) (List<?>) HyEvolutionUtil.getValidTemporalElements(feature.getAttributes(), date);
	}

	@SuppressWarnings("unchecked")
	public static List<HyEnumValue> getValidEnumLiterals(HyEnum hyEnum, Date date) {
		return (List<HyEnumValue>) (List<?>) HyEvolutionUtil.getValidTemporalElements(hyEnum.getLiterals(), date);
	}



	public static boolean isDeprecated(HyFeature feature, Date date) {
		if (feature == null) {
			System.err.println(
					"Something bad happened. Could not determine deprecation status of feature as feature given to isDeprecated(...) was null");
			return false;
		}
		if (date == null) {
			System.err.println("Something bad happened. Could not determine deprecation status of feature " + feature
					+ ". Date given to isDeprecated(...) was null");
			return false;
		}

		if (feature.getDeprecatedSince() != null && (feature.getDeprecatedSince().compareTo(date) <= 0)) {
			return true;
		}

		return false;
	}


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
			return null;
		}

		HyTemporalElement validGroupCompositionTemporalElement = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);

		if (validGroupCompositionTemporalElement == null) {
			System.err
					.println("Something Bad Happened. Group: " + group + " has no valid composition at date: " + date);

			return null;
		}

		if (validGroupCompositionTemporalElement instanceof HyGroupComposition) {
			HyGroupComposition validGroupComposition = (HyGroupComposition) validGroupCompositionTemporalElement;
			return validGroupComposition.getFeatures();
		}

		return null;
	}

	public static boolean isAlternative(HyGroup group, Date date) {
		if (group == null) {
			System.err.println("Something bad happened. Group was null during isAlternative check");
			return false;
		}

		if (date == null) {
			System.err.println("Something bad happened. Date was null during isAlternative check");
			return false;
		}
		
		return group.isAlternative(date);
	}

	public static boolean isOr(HyGroup group, Date date) {
		if (group == null) {
			System.err.println("Something bad happened. Group was null during isOr check");
			return false;
		}

		if (date == null) {
			System.err.println("Something bad happened. Date was null during isOr check");
			return false;
		}


		return group.isOr(date);
	}

	public static boolean isAnd(HyGroup group, Date date) {
		if (group == null) {
			System.err.println("Something bad happened. Group was null during isAnd check");
			return false;
		}

		if (date == null) {
			System.err.println("Something bad happened. Date was null during isAnd check");
			return false;
		}


		return group.isAnd(date);
	}
	
	
	

	public static HyGroup getParentGroupOfFeature(HyFeature feature, Date date) {
		if (feature == null || date == null) {
			return null;
		}

		HyTemporalElement validGroupComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);

		if (validGroupComposition == null) {
			System.err.println(
					"Something bad happened. Feature " + feature + " is not member of any group at date " + date);
			return null;
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
		if (group == null || date == null) {
			return null;
		}

		HyTemporalElement validFeatureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);

		if (validFeatureChild == null) {
			System.err.println("Something bad happened. Group " + group + " has no parent at date " + date);
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

	
	public static HyFeatureType getValidType(HyFeature feature, Date date) {
		if (feature == null) {
			System.err.println("Something bad happened. Feature was null in getValidCardinality(...) of Class HyFeatureEvolutionUtil");
			return null;
		}

		if (date == null) {
			System.err.println("Something bad happened. Date was null in getValidCardinality(...) of Class HyFeatureEvolutionUtil");
			return null;
		}
		
		return HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
	}

	public static boolean isMandatory(HyFeature feature, Date date) {
		if (feature == null) {
			System.err.println("Something bad happened. Feature was null during isMandatory check");
			return false;
		}

		if (date == null) {
			System.err.println("Something bad happened. Date was null during isMandatory check");
			return false;
		}

		return feature.isMandatory(date);

	}

	public static boolean isOptional(HyFeature feature, Date date) {
		if (feature == null) {
			System.err.println("Something bad happened. Feature was null during isOptional check");
			return false;
		}

		if (date == null) {
			System.err.println("Something bad happened. Date was null during isOptional check");
			return false;
		}

		return feature.isOptional(date);
	}
}