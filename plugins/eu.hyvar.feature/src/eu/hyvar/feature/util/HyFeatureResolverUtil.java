package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.data.util.IdentifierWithDateUtil;

public class HyFeatureResolverUtil {
	public static final String[] FILE_EXTENSIONS = {"hyfeature", "hyfeaturemodel"};
	
	// TODO incorporate evolution
	
	public static HyFeatureModel getAccompanyingFeatureModel(EObject elementInOriginalResource) {
//		String[] models = new String[1];
//		models[0] = "hyfeature";
		return DEIOUtil.doLoadAccompanyingModel(elementInOriginalResource, FILE_EXTENSIONS);
	}
	
	public static HyFeature resolveFeature(String identifier, HyFeatureModel featureModel, Date date) throws HyFeatureModelWellFormednessException {
		
		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			identifier = identifier.substring(1, identifier.length() - 1);
		}
		
		
		
		List<HyFeature> validFeatures = new ArrayList<HyFeature>();
		for(HyFeature feature: featureModel.getFeatures()) {
			String name = HyFeatureEvolutionUtil.getValidName(feature.getNames(), date).getName();
			if(name.equals(identifier)) {
				validFeatures.add(feature);
			}
		}
		
		if(validFeatures.size() > 1) {
			// More than one feature with that name at date date
			throw new HyFeatureModelWellFormednessException();
		} 
		else if(validFeatures.size() == 1) {
			return validFeatures.get(0);
		}
		
		
		
		
//		Iterator<EObject> iterator = featureModel.eAllContents();
//		
//		while(iterator.hasNext()) {
//			EObject element = iterator.next();
//			
//			if (element instanceof HyFeature) {
//				HyFeature feature = (HyFeature) element;
//				String name = HyFeatureEvolutionUtil.getMostRecentFeatureName(feature).getName();
//				
//				if (identifier.equals(name)) {
//					return feature;
//				}
//			}
//		}
		
		return null;
	}
	
	
	public static HyEnum resolveEnum(String identifier, HyFeatureModel featureModel, Date date) {
		if(identifier == null || featureModel == null) {
			return null;
		}
		
		// TODO incorporate Evolution
		List<HyEnum> matchingEnums = new ArrayList<HyEnum>();
		for(HyEnum hyEnum: featureModel.getEnums()) {
			if(hyEnum.getName().equals(identifier)) {
				matchingEnums.add(hyEnum);
			}
		}
		
		if(matchingEnums.size() > 1) {
			// TODO error: more than one valid element
		} else if(matchingEnums.size() == 1) {
			return matchingEnums.get(0);
		}
		
		return null;
	}
	
	public static String deresolveFeature(HyFeature feature, Date date) {
		// TODO incorporate evolution! For every element!
		String identifier = HyFeatureEvolutionUtil.getValidName(feature.getNames(), date).getName();
		
		//Standard TEXT token regular expression
		String textTokenRegularExpression = "[A-Za-z_][A-Za-z0-9_]*";
		
		if (!identifier.matches(textTokenRegularExpression)) {
			identifier = "\"" + identifier + "\"";
		}
		
		return identifier;
	}

	// TODO versions and attributes
	public static HyVersion resolveVersion(String identifier, HyFeature feature) {
		if (identifier == null) {
			return null;
		}
		
		List<HyVersion> versions = feature.getVersions();
		
		for (HyVersion version : versions) {
			String number = version.getNumber();
			
			if (identifier.equals(number)) {
				return version;
			}
		}
		
		return null;
	}
	
	public static String deresolveVersion(HyVersion version, Date date) {
		return version.getNumber();
	}
	
	public static HyFeatureAttribute resolveFeatureAttribute(String identifier, HyFeature containingFeature, Date date) throws HyFeatureModelWellFormednessException {
		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			identifier = identifier.substring(1, identifier.length() - 1);
		}
		
		List<HyFeatureAttribute> validAttributes = new ArrayList<HyFeatureAttribute>();
		for(HyFeatureAttribute attribute: containingFeature.getAttributes()) {
			String name = HyFeatureEvolutionUtil.getValidName(attribute.getNames(), date).getName();
			if(name.equals(identifier)) {
				validAttributes.add(attribute);
			}
		}
		
		if(validAttributes.size() > 1) {
			// More than one attribute with that name at date date
			throw new HyFeatureModelWellFormednessException();
		} 
		else if(validAttributes.size() == 1) {
			return validAttributes.get(0);
		}
		
		
//		String featureString;
//		String attributeString;
//		
//		String[] splits = identifier.split(".");
//		if(splits.length > 2) {
//			System.out.println("Warning: in the feature attribute referenced by "+identifier+", there are some dots in the name of the feature or the attribute. Please fix this");
//			return null;
//		} else if(splits.length < 2) {
//			System.out.println("Warning: feature attributes are referenced as follows: featureName.attributeName");
//			return null;
//		}
//		
//		featureString = splits[0];
//		attributeString = splits[1];
//		
//		List<HyFeature> validFeatures = new ArrayList<HyFeature>();
//		HyFeature resolvedFeature;
//		for(HyFeature feature: featureModel.getFeatures()) {
//			String name = HyFeatureEvolutionUtil.getValidName(feature.getNames(), date).getName();
//			if(name.equals(featureString)) {
//				validFeatures.add(feature);
//			}
//		}
//		
//		if(validFeatures.size() > 1) {
//			// More than one feature with that name at date date
//			throw new HyFeatureModelWellFormednessException();
//		} 
//		else if(validFeatures.size() == 1) {
//			resolvedFeature = validFeatures.get(0);
//			
//			
//			for(HyFeatureAttribute attribute: resolvedFeature.getAttributes()) {
//				String name = HyFeatureEvolutionUtil.getValidName(attribute.getNames(), date).getName();
//				if(name.equals(attributeString)) {
//					validAttributes.add(attribute);
//				}
//			}
//			
//			if(validAttributes.size() > 1) {
//				// More than one attribute with that name at date date
//				throw new HyFeatureModelWellFormednessException();
//			} 
//			else if(validAttributes.size() == 1) {
//				return validAttributes.get(0);
//			}
//		}
		
		return null;
	}
	
	public static String deresolveFeatureAttribute(HyFeatureAttribute attribute, Date date) {
		String name = "";
		HyFeature feature = attribute.getFeature();
		name += HyFeatureEvolutionUtil.getValidName(feature.getNames(), date).getName();
		name += ".";
		name += HyFeatureEvolutionUtil.getValidName(attribute.getNames(), date).getName();
		return name;
	}
}
