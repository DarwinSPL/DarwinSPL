package eu.hyvar.mspl.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedDependencies;
import eu.hyvar.mspl.manifest.HyTimedImplementationLink;
import eu.hyvar.mspl.manifest.HyTimedImplementations;

public class HyManifestVisitorUtil {
	private final static boolean PrintDebug = true;

	
	public static void visitRelativeImplementationModel (String identifier, EObject elementInOriginalResource) {
		HySPLImplementation model = HyManifestResolverUtil.resolveRelativeImplementationModel(identifier, elementInOriginalResource);
		visitRelativeImplementationModel(model);
	}	
	
	
//	public static void visitRelativeImplementationModel (String identifier, EObject elementInOriginalResource) {
	public static void visitRelativeImplementationModel (HySPLImplementation model) {
		//HySPLImplementation model = HyManifestResolverUtil.resolveRelativeImplementationModel(identifier, elementInOriginalResource);

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
	
	public static void visitHySPLSignature (String prefix, HySPLSignature signature) {
		visitHyName(prefix+"  ", signature.getNames());
	}

	public static void visitHyFeature (String prefix, HyFeature feature) {
		visitHyName(prefix+"  ", feature.getNames());
		print(prefix+"    ", "id="+feature.getId());
		print(prefix+"    ", "since="+feature.getValidSince());
		print(prefix+"    ", "until="+feature.getValidUntil());
	}

	public static void visitHyName (String prefix, EList<HyName> names) {
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

	
	public static void print(String prefix, String str) {
		if (PrintDebug) {
			System.out.println(prefix+str);
		}
	}

}
