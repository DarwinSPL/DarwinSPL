package eu.hyvar.mspl.util;

import java.util.ArrayList;
import java.util.List;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.common.ecore.util.DwEcoreUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.information.util.ContextInformationResolverUtil;
import eu.hyvar.dataValues.HyEnum;

import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.util.HyFeatureResolverUtil;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.mspl.manifest.HyManifest;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedDependencies;

public class HyManifestResolverUtil {

	public static String MANIFEST_SEPARATOR = ":";
	
	private static final String MANIFEST_MODEL_FILE_EXTENSION_FOR_XMI = "hymanifest_xmi";
	private static final String MANIFEST_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX = "hymanifest";
	
	private static final String[] MANIFEST_MODEL_FILE_EXTENSIONS = {MANIFEST_MODEL_FILE_EXTENSION_FOR_XMI, MANIFEST_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX};
	
	public static String getManifestModelFileExtensionForXmi() {
		return MANIFEST_MODEL_FILE_EXTENSION_FOR_XMI;
	}
	public static String getManifestModelFileExtensionForConcreteSyntax() {
		return MANIFEST_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX;
	}
	public static String[] getManifestModelFileExtensions() {
		return MANIFEST_MODEL_FILE_EXTENSIONS;
	}

	public static HyManifest getAccompanyingManifestModel(EObject elementInOriginalResource) {
		//EObject model = DwEcoreUtil.loadAccompanyingModelInSameProject(elementInOriginalResource, HyFeatureUtil.getFeatureModelFileExtensionForXmi());
		EObject model = DwEcoreUtil.loadAccompanyingModelInSameProject(elementInOriginalResource, getManifestModelFileExtensions());
		
		if(model != null && model instanceof HyManifest) {
			return (HyManifest)model;
		}
		
		return null;
		// return DEIOUtil.doLoadAccompanyingModel(elementInOriginalResource, FILE_EXTENSIONS);
	}

	// From an identifier in the form "signatureName.signatureFeature" search in
	// all dependencies
	public static HyFeature resolveMsplFeature(String identifier, EObject container) {
		// Check of parameters:
		if ((identifier == null) || (container == null)
				|| (!identifier.contains(HyManifestResolverUtil.MANIFEST_SEPARATOR))) {
			return null;
		}

		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			identifier = identifier.substring(1, identifier.length() - 1);
		}
		String elements[] = identifier.split(HyManifestResolverUtil.MANIFEST_SEPARATOR, 2);
		String signatureName = elements[0];
		String signatureFeature = elements[1];

		if (signatureName.isEmpty() || signatureFeature.isEmpty()) {
			return null;
		}

		EList<HyFeature> features = new BasicEList<HyFeature>();

		HyManifest manifest = getAccompanyingManifestModel(container);
		if (manifest instanceof HySPLImplementation) {

			EList<HyTimedDependencies> list = ((HySPLImplementation) manifest).getDependencies();
			for (HyTimedDependencies dep : list) {
				if (signatureName.equals(dep.getAlias())) {
					HySPLSignature signature = dep.getSignature();
					EList<HyFeature> finds = resolveFeaturesOfSignature(signatureFeature, signature);
					features.addAll(finds);
				}
			}
		}

		// DEBUG: in first implementation return only one element
		if (!features.isEmpty()) {
			return features.get(0);
		}
		return null;
	}

	public static EList<HyFeature> resolveFeaturesOfSignature(String featureName, HySPLSignature signature) {
		EList<HyFeature> features = new BasicEList<HyFeature>();

		HyFeatureModel featureModel = HyFeatureResolverUtil.getAccompanyingFeatureModel(signature);
		// load all feature with the same name
		for (HyFeature feature : featureModel.getFeatures()) {
			for (HyName name : feature.getNames()) {
				String nameString = name.getName();
				if (nameString != null && nameString.equals(featureName)) {
					features.add(feature);
				}
			}
		}
		return features;
	}

	public static HySPLSignature resolveRelativeSignatureModel(String identifier, EObject elementInOriginalResource) {

		boolean checkExtension = false;
		for(String ext: HyManifestResolverUtil.getManifestModelFileExtensions()) {
			if(identifier.endsWith(ext)){
				checkExtension=true;
			}
		}
		if (!checkExtension)
			return null;

		URI uri = elementInOriginalResource.eResource().getURI();
		uri = uri.trimSegments(1);
		for (String s : identifier.split("/")) {
			uri = uri.appendSegment(s);
		}
		org.eclipse.core.resources.IFile file = EcoreIOUtil.getFile(uri);
		if (file.exists()) {
			HyManifest manifest = EcoreIOUtil.loadModel(file);

			if (manifest instanceof HySPLSignature) {
				return (HySPLSignature) manifest;
			}
		}

		return null;
	}

	public static HySPLImplementation resolveRelativeImplementationModel(String identifier,
			EObject elementInOriginalResource) {

		boolean checkExtension = false;
		for(String ext: HyManifestResolverUtil.getManifestModelFileExtensions()) {
			if(identifier.endsWith(ext)){
				checkExtension=true;
			}
		}
		if (!checkExtension)
			return null;

		URI uri = elementInOriginalResource.eResource().getURI();
		uri = uri.trimSegments(1);
		for (String s : identifier.split("/")) {
			uri = uri.appendSegment(s);
		}
		org.eclipse.core.resources.IFile file = EcoreIOUtil.getFile(uri);
		if (file.exists()) {
			HyManifest manifest = EcoreIOUtil.loadModel(file);

			if (manifest instanceof HySPLImplementation) {
				return (HySPLImplementation) manifest;
			}
		}

		return null;
	}

	public static HyEnum resolveMsplEnum(String identifier, EObject container) {
		// Check of parameters:
		if ((identifier == null) || (container == null)
				|| (!identifier.contains(HyManifestResolverUtil.MANIFEST_SEPARATOR))) {
			return null;
		}

		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			identifier = identifier.substring(1, identifier.length() - 1);
		}
		String elements[] = identifier.split(HyManifestResolverUtil.MANIFEST_SEPARATOR, 2);
		String signatureName = elements[0];
		String enumName = elements[1];

		if (signatureName.isEmpty() || enumName.isEmpty()) {
			return null;
		}

		List<HyEnum> enums = new ArrayList<HyEnum>();

		HyManifest manifest = getAccompanyingManifestModel(container);
		if (manifest instanceof HySPLImplementation) {
			// HyFeatureModel featureModel =
			// HyFeatureResolverUtil.getAccompanyingFeatureModel(manifest);
			// HyContextModel contextModel =
			// ContextInformationResolverUtil.getAccompanyingContextModel(manifest);
			//
			// if(featureModel != null) {
			// for(HyEnum _enum: featureModel.getEnums()) {
			// if(_enum.getName().equals(enumName)) {
			// enums.add(_enum);
			// }
			// }
			// }
			//
			// if(contextModel != null) {
			// for(HyEnum _enum: contextModel.getEnums()) {
			// if(_enum.getName().equals(enumName)) {
			// enums.add(_enum);
			// }
			// }
			// }

			for (HyTimedDependencies dependency : ((HySPLImplementation) manifest).getDependencies()) {
				if (dependency.getAlias().equals(signatureName)) {

					HySPLSignature signature = dependency.getSignature();
					HyFeatureModel signatureFeatureModel = HyFeatureResolverUtil.getAccompanyingFeatureModel(signature);
					HyContextModel signatureContextModel = ContextInformationResolverUtil
							.getAccompanyingContextModel(signature);

					if (signatureFeatureModel != null) {
						for (HyEnum _enum : signatureFeatureModel.getEnums()) {
							if (_enum.getName().equals(enumName)) {
								enums.add(_enum);
							}
						}
					}

					if (signatureContextModel != null) {
						for (HyEnum _enum : signatureContextModel.getEnums()) {
							if (_enum.getName().equals(enumName)) {
								enums.add(_enum);
							}
						}
					}
				}

			}
		}
		// DEBUG: in first implementation return only one element
		if (!enums.isEmpty()) {
			return enums.get(0);
		}
		return null;
	}

}
