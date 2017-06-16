package eu.hyvar.mspl.util;

import java.util.List;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.util.HyFeatureResolverUtil;
import eu.hyvar.mspl.manifest.HyInterval;
import eu.hyvar.mspl.manifest.HyManifest;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedDependencies;
import eu.hyvar.mspl.manifest.ManifestFactory;
import eu.hyvar.mspl.manifest.impl.ManifestFactoryImpl;

public class HyManifestResolverUtil {

	public static String MANIFEST_SEPARATOR = ":";
	
	public static final String[] FILE_EXTENSIONS = { "hymanifest" };
	
	public static final String FILE_EXTENSION_FOR_XMI = "hymanifest";
	

	public static HyManifest getAccompanyingManifestModel(EObject elementInOriginalResource) {
		return DEIOUtil.doLoadAccompanyingModel(elementInOriginalResource, FILE_EXTENSIONS);
	}

	// From an identifier in the form "signatureName.signatureFeature" search in all dependencies
	public static HyFeature resolveMsplFeature(String identifier, EObject container) {
		// Check of parameters:
		if( (identifier==null)||(container==null)||(!identifier.contains(HyManifestResolverUtil.MANIFEST_SEPARATOR)) ) {
			return null;
		}
		
		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			identifier = identifier.substring(1, identifier.length() - 1);
		}
		String elements[] = identifier.split(HyManifestResolverUtil.MANIFEST_SEPARATOR, 2);
		String signatureName = elements[0];
		String signatureFeature = elements[1];

		if(signatureName.isEmpty() || signatureFeature.isEmpty()) {
			return null;
		}
		 
		EList<HyFeature> features = new BasicEList<HyFeature>();

		HyManifest manifest = getAccompanyingManifestModel(container);
		if(manifest instanceof HySPLImplementation) {
			
			EList<HyTimedDependencies> list = ((HySPLImplementation) manifest).getDependencies();
			for (HyTimedDependencies dep: list) {
				if( signatureName.equals(dep.getAlias()) ) {
					HySPLSignature signature = dep.getSignature();
					EList<HyFeature> finds = resolveFeaturesOfSignature(signatureFeature, signature);
					features.addAll(finds);
				}
			}
		}

		// DEBUG: in first implementation return only one element
		if(!features.isEmpty()) {
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
	

	
	
	
	public static HySPLSignature resolveRelativeSignatureModel (String identifier, EObject elementInOriginalResource) {

		boolean checkExtension = false;
		for(String ext: FILE_EXTENSIONS) {
			if(identifier.endsWith(ext)){
				checkExtension=true;
			}
		}
		if(!checkExtension) return null;
			
		URI uri = elementInOriginalResource.eResource().getURI();
		uri = uri.trimSegments(1);
		for(String s: identifier.split("/")) {
			uri = uri.appendSegment(s);
		}
		org.eclipse.core.resources.IFile file = EcoreIOUtil.getFile(uri);
		if(file.exists()) {
			HyManifest manifest = EcoreIOUtil.loadModel(file);
			
			if(manifest instanceof HySPLSignature) {
				return (HySPLSignature) manifest;
			}
		}
		
		return null;
	}

	
	
	public static HySPLImplementation resolveRelativeImplementationModel (String identifier, EObject elementInOriginalResource) {

		boolean checkExtension = false;
		for(String ext: FILE_EXTENSIONS) {
			if(identifier.endsWith(ext)){
				checkExtension=true;
			}
		}
		if(!checkExtension) return null;
			
		URI uri = elementInOriginalResource.eResource().getURI();
		uri = uri.trimSegments(1);
		for(String s: identifier.split("/")) {
			uri = uri.appendSegment(s);
		}
		org.eclipse.core.resources.IFile file = EcoreIOUtil.getFile(uri);
		if(file.exists()) {
			HyManifest manifest = EcoreIOUtil.loadModel(file);
			
			if(manifest instanceof HySPLImplementation) {
				return (HySPLImplementation) manifest;
			}
		}
		
		return null;
	}



	
	public static HyInterval temporalIntersection(List<HyTemporalElement> elementsToIntersect) {
		ManifestFactory factory = ManifestFactoryImpl.init();
		HyInterval interval = factory.createHyInterval();
		
		for(HyTemporalElement element: elementsToIntersect) {

			if(element.getValidSince()!=null && interval.getValidSince()!=null && element.getValidSince().after(interval.getValidSince()) ) {
				interval.setValidSince(element.getValidSince());
			}
			if(element.getValidSince()!=null && interval.getValidSince()==null) {
				interval.setValidSince(element.getValidSince());
			}

			if(element.getValidUntil()!=null && interval.getValidUntil()!=null && element.getValidUntil().before(interval.getValidUntil()) ) {
				interval.setValidSince(element.getValidSince());
			}
			if(element.getValidUntil()!=null && interval.getValidUntil()==null) {
				interval.setValidUntil(element.getValidUntil());
			}
		}
		return interval;
	}
	
}
