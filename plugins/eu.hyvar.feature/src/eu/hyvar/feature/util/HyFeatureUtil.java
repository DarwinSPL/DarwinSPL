package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyVersion;

public class HyFeatureUtil {
	
	
	private static final String FEATURE_MODEL_FILE_EXTENSION_FOR_XMI = "hyfeature";
	
	
	
	public static String getFeatureModelFileExtensionForXmi() {
		return FEATURE_MODEL_FILE_EXTENSION_FOR_XMI;
	}
	
	// TODO make suitable for evolution
	public static HyVersion getInitialVersion(HyFeature feature) {
		//TODO: Make sure that it is the initial version not just the one declared first in the model
		List<HyVersion> versions = feature.getVersions();
		
		if (!versions.isEmpty()) {
			return versions.get(0);
		}
		
		return null;
	}
	
	public static List<HyFeature> findFeaturesOnSameTreeLevel(HyFeature referenceFeature, Date date) {
		int referenceTreeLevel = getTreeLevelOfFeature(referenceFeature, date);
		
		HyFeatureModel featureModel = (HyFeatureModel) EcoreUtil.getRootContainer(referenceFeature);
		List<HyFeature> featuresOnSameTreeLevel = new ArrayList<HyFeature>();
		
		Iterator<EObject> iterator = featureModel.eAllContents();
		
		while(iterator.hasNext()) {
			EObject element = iterator.next();
			
			if (element instanceof HyFeature) {
				HyFeature feature = (HyFeature) element;
				
				if (feature != referenceFeature) {
					int featureTreeLevel = getTreeLevelOfFeature(feature, date);
					
					if (referenceTreeLevel == featureTreeLevel) {
						featuresOnSameTreeLevel.add(feature);
					}
				}
			}
		}
		
		return featuresOnSameTreeLevel;
	}
	
	private static int getTreeLevelOfFeature(HyFeature feature, Date date) {
		HyGroup parentGroup = HyFeatureEvolutionUtil.getParentGroupOfFeature(feature, date);
		
		if (parentGroup == null) {
			//Root feature is considered level 0.
			return 0;
		}
		
		HyFeature parentFeature = HyFeatureEvolutionUtil.getParentOfGroup(parentGroup, date);
		return getTreeLevelOfFeature(parentFeature,date) + 1;
	}
	
	public static int getNumberOfMandatoryFeatures(List<HyFeature> features, Date date) {
		int numberOfMandatoryFeatures = 0;
		
		for (HyFeature feature : features) {
			if (feature.isMandatory(date)) {
				numberOfMandatoryFeatures++;
			}
		}
		
		return numberOfMandatoryFeatures;
	}
	
	
	/**
	 * Only for FMs valid at one point in time!
	 * @param group
	 * @param cardinality
	 * @param groupChildren
	 * @return
	 */
	public static boolean isAnd(HyGroup group) throws HyFeatureModelWellFormednessException {
		if (group == null) {
			System.err.println("Something bad happened. Group was null during isAnd check");
			return false;
		}
		
		if(group.getTypes().size()!=1) {
			throw new HyFeatureModelWellFormednessException("Group", "Types", group.getTypes().size());
		}
		
		return (group.getTypes().get(0).getType().equals(HyGroupTypeEnum.AND));
	}
	
	/**
	 * Only for FMs valid at one point in time!
	 * @param group
	 * @param date
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	public static boolean isOr(HyGroup group) throws HyFeatureModelWellFormednessException {
		if (group == null) {
			System.err.println("Something bad happened. Group was null during isOr check");
			return false;
		}

		if(group.getTypes().size()!=1) {
			throw new HyFeatureModelWellFormednessException("Group", "Types", group.getTypes().size());
		}
		
		return (group.getTypes().get(0).getType().equals(HyGroupTypeEnum.OR));
	}
	
	public static boolean isAlternative(HyGroup group) throws HyFeatureModelWellFormednessException {
		if (group == null) {
			System.err.println("Something bad happened. Group was null during isAlternative check");
			return false;
		}

		if(group.getTypes().size()!=1) {
			throw new HyFeatureModelWellFormednessException("Group", "Types", group.getTypes().size());
		}
		
		return (group.getTypes().get(0).getType().equals(HyGroupTypeEnum.ALTERNATIVE));
	}
	
	/**
	 * Only for FMs valid at one point in time!
	 * @param feature
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	public static boolean isMandatory(HyFeature feature) throws HyFeatureModelWellFormednessException {
		if(feature == null) {
			System.err.println("Something bad happened. Feature was null during isMandatory check");
			return false;
		}
		
		if(feature.getTypes().size()!=1) {
			throw new HyFeatureModelWellFormednessException("Feature", "Types", feature.getTypes().size());
		}
		
		return (feature.getTypes().get(0).getType().equals(HyFeatureTypeEnum.MANDATORY));
	}
	
	/**
	 * Only for FMs valid at one point in time!
	 * @param feature
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	public static boolean isOptional(HyFeature feature) throws HyFeatureModelWellFormednessException {
		if(feature == null) {
			System.err.println("Something bad happened. Feature was null during isMandatory check");
			return false;
		}
		
		if(feature.getTypes().size()!=1) {
			throw new HyFeatureModelWellFormednessException("Feature", "Types", feature.getTypes().size());
		}
		
		return (feature.getTypes().get(0).getType().equals(HyFeatureTypeEnum.OPTIONAL));
	} 
	
	
	/**
	 * 
	 * @param group
	 * @param featureType null collects all features
	 * @return
	 */
	public static int getAmountOfFeaturesOfGroup(HyGroup group, HyFeatureTypeEnum featureType) {
		
		if(featureType == null) {
			return group.getParentOf().get(0).getFeatures().size();
		}
		
		int features = 0;
		
		for(HyFeature feature: group.getParentOf().get(0).getFeatures()) {
			if(feature.getTypes().get(0).equals(featureType)) {
				features++;
			}
		}
		
		return features;
	}
	
	/**
	 * This does not take constraints into account.
	 */
//	public static int calculateNumberOfPossibleConfigurations(DEFeatureModel featureModel) {
//		DEFeature rootFeature = featureModel.getRootFeature();
//		
//		return doCalculateNumberOfPossibleConfigurations(rootFeature);
//	}
//	
//	private static int doCalculateNumberOfPossibleConfigurations(DECardinalityBasedElement cardinalityBasedElement) {
//		boolean includeVersions = true;
//		
//		if (cardinalityBasedElement instanceof DEGroup) {
//			DEGroup group = (DEGroup) cardinalityBasedElement;
//			
//			int minCardinality = group.getMaxCardinality();
//			int maxCardinality = group.getMaxCardinality();
//			
//			List<DEFeature> features = group.getFeatures();
//			int numberOfFeatures = features.size();
//			int numberOfMandatoryFeatures = getNumberOfMandatoryFeatures(features);
//			
//			int effectiveMinCardinality = Math.min(minCardinality, numberOfMandatoryFeatures);
//			int effectiveMaxCardinality = Math.min(maxCardinality, numberOfFeatures);
//			
//			if (effectiveMinCardinality > effectiveMaxCardinality) {
//				return 0;
//			}
//			
//			if (effectiveMinCardinality == effectiveMaxCardinality) {
//				return effectiveMinCardinality;
//			}
//			
//			
//			int k = numberOfFeatures - numberOfMandatoryFeatures;
//			int numberOfPossibilities = 0;
//			
//			for (int n = effectiveMinCardinality; n <= effectiveMaxCardinality; n++) {
//				int subBranchPossibilities = 1;
//				//TODO: The concrete combination has to consider how many options the sub branch has
//				numberOfPossibilities += binomialCoefficient(n, k);
//			}
//			
//			return numberOfPossibilities;
//		}
//		
//		
//		if (cardinalityBasedElement instanceof DEFeature) {
//			DEFeature feature = (DEFeature) cardinalityBasedElement;
//			
//			int numberOfPossibilities = 1;
//			
//			if (includeVersions) {
//				List<DEVersion> versions = feature.getVersions();
//				
//				if (!versions.isEmpty()) {
//					//Add one less than all versions as selecting the plain
//					//feature (without any version) is no longer possible.
//					numberOfPossibilities += versions.size() - 1;
//				}
//			}
//			
//			List<DEGroup> groups = feature.getGroups();
//			
//			for (DEGroup group : groups) {
//				numberOfPossibilities *= doCalculateNumberOfPossibleConfigurations(group);
//			}
//
//			//Has to be last as deselecting the feature does not
//			//entail any selection of child groups/features.
//			if (feature.isOptional()) {
//				numberOfPossibilities += 1;
//			}
//			
//			return numberOfPossibilities;
//		}
//		
//		throw new UnsupportedOperationException();
//	}
//	
//	private static long binomialCoefficient(int n, int k) {
//		long coefficient = 1;
//		
//		for (int i = n - k + 1; i <= n; i++) {
//			coefficient *= i;
//		}
//		
//		for (int i = 1; i <= k; i++) {
//			coefficient /= i;
//		}
//		
//		return coefficient;
//	}
	
	
	
//	public static void printConfiguration(List<? extends DEConfigurationArtifact> configuration) {
//		System.out.println(formatConfiguration(configuration));
//	}
//	
//	public static String formatConfiguration(List<? extends DEConfigurationArtifact> configuration) {
//		String output = "";
//		boolean isFirst = true;
//		
//		for (DEConfigurationArtifact configurationArtifact : configuration) {
//			if (!isFirst) {
//				output += ", ";
//			}
//			
//			if (configurationArtifact instanceof DEFeature) {
//				DEFeature feature = (DEFeature) configurationArtifact;
//				
//				output += feature.getName();
//			}
//			
//			if (configurationArtifact instanceof DEVersion) {
//				
//				DEVersion version = (DEVersion) configurationArtifact;
//				DEFeature feature = version.getFeature();
//				
//				output += feature.getName() + " @ " + version.getNumber();
//			}
//			
//			isFirst = false;
//		}
//		
//		return output;
//	}
	
//	//DEBUG
//	public static void checkConfigurationValidity(List<? extends DEConfigurationArtifact> configuration) {
//		//All features have to have exactly one version.
//		Map<DEFeature, DEVersion> featureToVersionMap =  new HashMap<DEFeature, DEVersion>();
//		List<DEFeature> features = new ArrayList<DEFeature>();
//		
//		for (DEConfigurationArtifact artifact : configuration) {
//			if (artifact instanceof DEFeature) {
//				DEFeature feature = (DEFeature) artifact;
//				features.add(feature);
//			}
//			
//			if (artifact instanceof DEVersion) {
//				DEVersion version = (DEVersion) artifact;
//				DEFeature feature = version.getFeature();
//				
//				if (featureToVersionMap.containsKey(feature)) {
//					DEVersion existingVersion = featureToVersionMap.get(feature);
//					System.err.println("Configuration " + formatConfiguration(configuration) + " is invalid!");
//					System.err.println("Configuration already contains a version (" + existingVersion.getNumber() + " for feature " + feature.getName() + " besides version " + version.getNumber());
//				} else {
//					featureToVersionMap.put(feature, version);
//				}
//			}
//		}
//		
//		for (DEFeature feature : features) {
//			if (!featureToVersionMap.containsKey(feature)) {
//				System.err.println("Configuration " + formatConfiguration(configuration) + " is invalid!");
//				System.err.println("Configuration does not contain a version for " + feature.getName());
//			}
//		}
//	}
}
