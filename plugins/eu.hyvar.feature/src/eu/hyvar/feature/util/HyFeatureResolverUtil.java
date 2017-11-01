package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.christophseidl.util.ecore.EcoreResolverUtil;
import de.darwinspl.common.ecore.util.DwEcoreUtil;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;

public class HyFeatureResolverUtil {
//	public static final String[] FILE_EXTENSIONS = { "hyfeature", "hyfeaturemodel" };

	// TODO incorporate evolution

	public static HyFeatureModel getAccompanyingFeatureModel(EObject elementInOriginalResource) {
		
		EObject model = DwEcoreUtil.loadAccompanyingModelInSameProject(elementInOriginalResource, HyFeatureUtil.getFeatureModelFileExtensionForXmi());
		
		if(model != null && model instanceof HyFeatureModel) {
			return (HyFeatureModel)model;
		}
		
		return null;
		
		
//		HyFeatureModel featureModel = DEIOUtil.doLoadAccompanyingModel(elementInOriginalResource, new String[] {HyFeatureUtil.getFeatureModelFileExtensionForXmi()});
//		
//		if(featureModel == null) {
//			// search for first feature model in the same folder and then all the way up to the project
//			
//			 IFile fileOfOriginalResource = EcoreResolverUtil.resolveRelativeFileFromEObject(elementInOriginalResource);
//			 if(fileOfOriginalResource != null) {
//				 IContainer container = fileOfOriginalResource.getParent();
//				 
//				 while(container != null) {
//					 IFile featureModelFile = ResourceUtil.findFirstFileWithExtension(container, HyFeatureUtil.getFeatureModelFileExtensionForXmi());
//					 
//					 featureModel = EcoreIOUtil.loadModel(featureModelFile, elementInOriginalResource.eResource().getResourceSet());
//					 
//					 if(featureModel != null) {
//						 break;
//					 }
//					 
//					 // Repeat only if container is not a project
//					 if(container instanceof IProject) {
//						 break;
//					 }
//					 
//					 container = container.getParent();						 
//				 }
//			 }
//		}
//		
//		return featureModel;
	}

	public static HyFeature resolveFeature(String identifier, HyFeatureModel featureModel, Date date)
			throws HyFeatureModelWellFormednessException {
		
		if(identifier == null || featureModel == null) {
			return null;
		}
		
		List<HyFeature> validFeatures = new ArrayList<HyFeature>();
		
		// try if name is unique over time
		for (HyFeature feature : featureModel.getFeatures()) {
			for (HyName name : feature.getNames()) {
				String nameString = name.getName();
				if (nameString != null && nameString.equals(identifier)) {
					validFeatures.add(feature);
				}
			}
		}

		if(validFeatures.size() > 1) {
			// name is not unique
			List<HyFeature> validFeaturesWithEvolution = new ArrayList<HyFeature>(1);
			for(HyFeature feature: validFeatures) {
				
				if(HyEvolutionUtil.isValid(feature, date)) {
					HyName name = HyFeatureEvolutionUtil.getName(feature.getNames(), date);
					if((name != null) && name.getName().equals(identifier)) {
						validFeaturesWithEvolution.add(feature);
					}					
				}
			}
			validFeatures = validFeaturesWithEvolution;
		}

		if (validFeatures.size() > 1) {
			// More than one feature with that name at date date
			throw new HyFeatureModelWellFormednessException();
		} else if (validFeatures.size() == 1) {
			return validFeatures.get(0);
		}

		// Iterator<EObject> iterator = featureModel.eAllContents();
		//
		// while(iterator.hasNext()) {
		// EObject element = iterator.next();
		//
		// if (element instanceof HyFeature) {
		// HyFeature feature = (HyFeature) element;
		// String name =
		// HyFeatureEvolutionUtil.getMostRecentFeatureName(feature).getName();
		//
		// if (identifier.equals(name)) {
		// return feature;
		// }
		// }
		// }

		
		
		return null;
	}

	public static HyEnum resolveEnum(String identifier, HyFeatureModel featureModel, Date date)  {
		if (identifier == null || featureModel == null) {
			return null;
		}

		List<HyEnum> matchingEnums = new ArrayList<HyEnum>();
		// try if name is unique
		for (HyEnum hyEnum : featureModel.getEnums()) {
			if (hyEnum.getName().equals(identifier)) {
				matchingEnums.add(hyEnum);
			}
		}

		
		if(matchingEnums.size() > 1) {
			// name is not unique
			List<HyEnum> validEnumsWithEvolution = new ArrayList<HyEnum>(1);
			for(HyEnum hyEnum: matchingEnums) {
				if(HyEvolutionUtil.isValid(hyEnum, date)) {
					validEnumsWithEvolution.add(hyEnum);
				}				
			}
			matchingEnums = validEnumsWithEvolution;
		}

		if (matchingEnums.size() > 1) {
			// TODO error: more than one valid element
		} else if (matchingEnums.size() == 1) {
			return matchingEnums.get(0);
		}

		return null;
	}

	public static String deresolveFeature(HyFeature feature, Date date) {
		// TODO incorporate evolution! For every element!
		String identifier = HyFeatureEvolutionUtil.getName(feature.getNames(), date).getName();

		// Standard TEXT token regular expression
		String textTokenRegularExpression = "[A-Za-z_][A-Za-z0-9_]*";

		if (!identifier.matches(textTokenRegularExpression)) {
			identifier = "\"" + identifier + "\"";
		}

		return identifier;
	}

	public static HyVersion resolveVersion(String identifier, HyFeature feature, Date date) throws HyFeatureModelWellFormednessException {
		if (identifier == null) {
			return null;
		}

		List<HyVersion> validVersions = HyFeatureEvolutionUtil.getVersionsOfFeature(feature, date);
		
		List<HyVersion> resolvedVersions = new ArrayList<HyVersion>(1);

		for (HyVersion version : validVersions) {
			String number = version.getNumber();

			if (identifier.equals(number)) {
				resolvedVersions.add(version);
			}
		}

		if(resolvedVersions.size()>1) {
			throw new HyFeatureModelWellFormednessException("Identifier "+identifier+" is ambiguous and lead to more than one resolved version.");
		}
		
		if(resolvedVersions.isEmpty()) {
			return null;
		} 
		else {
			return resolvedVersions.get(0);
		}
	}

	public static String deresolveVersion(HyVersion version, Date date) {
		return version.getNumber();
	}
	
	public static HyFeatureAttribute resolveFeatureAttribute(String identifier, HyFeature containingFeature, Date date) throws HyFeatureModelWellFormednessException {		
		List<HyFeatureAttribute> validAttributes = new ArrayList<HyFeatureAttribute>();
		// try if name is unique
		for (HyFeatureAttribute attribute : containingFeature.getAttributes()) {
			for(HyName name: attribute.getNames()) {
				String nameString = name.getName();
				if(nameString.equals(identifier)) {
					validAttributes.add(attribute);					
				}
			}
		}
		
		if(validAttributes.size() > 1) {
			// name is not unique -> incorporate evolution
			List<HyFeatureAttribute> validAttributesWithEvolution = new ArrayList<HyFeatureAttribute>(1);
			for(HyFeatureAttribute attribute: validAttributes) {
				if(HyEvolutionUtil.isValid(containingFeature, date) && HyEvolutionUtil.isValid(attribute, date)) {
					HyName name = HyFeatureEvolutionUtil.getName(attribute.getNames(), date);
					if((name != null) && name.getName().equals(identifier)) {
						validAttributesWithEvolution.add(attribute);
					}
				}
				
			}
			validAttributes = validAttributesWithEvolution;
		}

		if (validAttributes.size() > 1) {
			// More than one attribute with that name at date date
			throw new HyFeatureModelWellFormednessException();
		} else if (validAttributes.size() == 1) {
			return validAttributes.get(0);
		}

		// String featureString;
		// String attributeString;
		//
		// String[] splits = identifier.split(".");
		// if(splits.length > 2) {
		// System.out.println("Warning: in the feature attribute referenced by
		// "+identifier+", there are some dots in the name of the feature or the
		// attribute. Please fix this");
		// return null;
		// } else if(splits.length < 2) {
		// System.out.println("Warning: feature attributes are referenced as
		// follows: featureName.attributeName");
		// return null;
		// }
		//
		// featureString = splits[0];
		// attributeString = splits[1];
		//
		// List<HyFeature> validFeatures = new ArrayList<HyFeature>();
		// HyFeature resolvedFeature;
		// for(HyFeature feature: featureModel.getFeatures()) {
		// String name = HyFeatureEvolutionUtil.getValidName(feature.getNames(),
		// date).getName();
		// if(name.equals(featureString)) {
		// validFeatures.add(feature);
		// }
		// }
		//
		// if(validFeatures.size() > 1) {
		// // More than one feature with that name at date date
		// throw new HyFeatureModelWellFormednessException();
		// }
		// else if(validFeatures.size() == 1) {
		// resolvedFeature = validFeatures.get(0);
		//
		//
		// for(HyFeatureAttribute attribute: resolvedFeature.getAttributes()) {
		// String name =
		// HyFeatureEvolutionUtil.getValidName(attribute.getNames(),
		// date).getName();
		// if(name.equals(attributeString)) {
		// validAttributes.add(attribute);
		// }
		// }
		//
		// if(validAttributes.size() > 1) {
		// // More than one attribute with that name at date date
		// throw new HyFeatureModelWellFormednessException();
		// }
		// else if(validAttributes.size() == 1) {
		// return validAttributes.get(0);
		// }
		// }

		
		return null;
	}

	public static String deresolveFeatureAttribute(HyFeatureAttribute attribute, Date date) {
		String name = "";
		HyFeature feature = attribute.getFeature();
		name += HyFeatureEvolutionUtil.getName(feature.getNames(), date).getName();
		name += ".";
		name += HyFeatureEvolutionUtil.getName(attribute.getNames(), date).getName();
		return name;
	}
}
