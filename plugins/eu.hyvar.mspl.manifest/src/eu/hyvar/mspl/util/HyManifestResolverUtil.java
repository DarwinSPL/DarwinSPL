package eu.hyvar.mspl.util;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.util.HyFeatureResolverUtil;
import eu.hyvar.mspl.manifest.HyManifest;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedDependencies;

public class HyManifestResolverUtil {

	private final static boolean PrintDebug = false;
	public static String MANIFEST_SEPARATOR = ":";
	
	public static final String[] FILE_EXTENSIONS = { "hymanifest" };
	

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
			
			java.util.HashSet<HySPLSignature> signatures = new java.util.HashSet<HySPLSignature>(); 
			
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

/*	
	public static void visitRelativeImplementationModel (String identifier, EObject elementInOriginalResource) {
		HySPLImplementation model = HyManifestResolverUtil.getRelativeImplementationModel(identifier, elementInOriginalResource);

		if(model==null) {
			print("UNITO VISIT: ", "ERROR! Model not found.");
			return;
		}

		int count=0;

		print("\n\nUNITO VISIT: ", "Start visit HySPLImplementation");
		visitHyName("", model.getNames());

		
		print("", "Dependencies:");
		EList<HyTimedDependencies> dependent = model.getDependencies();
		count=0;
		for (HyTimedDependencies dep: dependent) {
			count++;
			print("  ", count+") ");
			print("    ", "signature=");
			visitHySPLSignature("    ", dep.getSignature());
			print("    ", "since="+dep.getValidSince());
			print("    ", "until="+dep.getValidUntil());
		}
		print("", "end dependencies.");
		
		
		print("", "Implementations:");
		EList<HyTimedImplementations> implementation = model.getImplementations();
		count=0;
		for (HyTimedImplementations impl: implementation) {
			count++;
			print("  ", count+") ");
			print("    ", "signature=");
			visitHySPLSignature("    ", impl.getSignature());
			print("    ", "since="+impl.getValidSince());
			print("    ", "until="+impl.getValidUntil());


			print("    ", "Associations:");
			EList<HyTimedImplementationLink> associations = impl.getAssociations();
			int countAssoc=0;
			for (HyTimedImplementationLink assoc: associations) {
				countAssoc++;
				print("      ", countAssoc+") ");
				print("        ", "local=");

				EList<HyFeature> features = assoc.getLocal();
				int countFeature=0;
				for (HyFeature feature: features) {
					countFeature++;
					print("        ", countFeature+") ");
					visitHyFeature("        ", feature);
				}
				print("        ", "signature=");
				features = assoc.getSignature();
				countFeature=0;
				for (HyFeature feature: features) {
					countFeature++;
					print("        ", countFeature+") ");
					visitHyFeature("        ", feature);
				}
				print("        ", "since="+assoc.getValidSince());
				print("        ", "until="+assoc.getValidUntil());
			}
			print("    ", "end associations.");

		}
		print("", "end implementations.");
		print("", "End visit HySPLImplementation\n\n");

	}	
	
	static void visitHySPLSignature (String prefix, HySPLSignature signature) {
		visitHyName(prefix+"  ", signature.getNames());
	}

	static void visitHyFeature (String prefix, HyFeature feature) {
		visitHyName(prefix+"  ", feature.getNames());
		print(prefix+"    ", "id="+feature.getId());
		print(prefix+"    ", "since="+feature.getValidSince());
		print(prefix+"    ", "until="+feature.getValidUntil());
	}

	static void visitHyName (String prefix, EList<HyName> names) {
		print(prefix+"  ", "Names:");
		for(HyName name: names) {
			print(prefix+"      ", "-- name="+name.getName());
			print(prefix+"         ", "id="+name.getId());
			print(prefix+"         ", "since="+name.getValidSince());
			print(prefix+"         ", "until="+name.getValidUntil());
			print(prefix+"         ", "superseded="+name.getSupersededElement());
			print(prefix+"         ", "superseding="+name.getSupersedingElement());
		}
		print(prefix+"  ", "end names.");

	}
*/
	
	static void print(String prefix, String str) {
		if (PrintDebug) {
			System.out.println(prefix+str);
		}
	}
	
	
}
