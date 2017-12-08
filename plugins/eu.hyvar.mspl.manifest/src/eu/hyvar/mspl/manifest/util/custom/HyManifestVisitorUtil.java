package eu.hyvar.mspl.manifest.util.custom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedDependencies;
import eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink;
import eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink;
import eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink;
import eu.hyvar.mspl.manifest.HyTimedImplementationFeatureLink;
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
		//visitHyName("", model.getNames());

		
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

				if( assoc instanceof HyTimedImplementationFeatureLink ) {
					HyTimedImplementationFeatureLink assocFeature = (HyTimedImplementationFeatureLink) assoc;
					print("        ", "local=");
					HyFeature feature = assocFeature.getLocal();
					visitHyFeature("        ", feature);
					print("        ", "signature=");
					feature = assocFeature.getSignature();
					visitHyFeature("        ", feature);
					print("        ", "since="+assocFeature.getValidSince());
					print("        ", "until="+assocFeature.getValidUntil());
					
					print("        ", "Attribute associations:");
					EList<HyTimedImplementationFeatureAttributeLink> attrAssociations = assocFeature.getAssociations();
					int countAttrAssoc=0;
					for( HyTimedImplementationFeatureAttributeLink attrAssoc: attrAssociations) {
						countAttrAssoc++;
						print("          ", countAttrAssoc+") ");
						print("            ", "local=");
						HyFeatureAttribute attribute = attrAssoc.getLocal();
						visitHyAttributeFeature("            ", attribute);
						print("            ", "signature=");
						attribute = attrAssoc.getSignature();
						visitHyAttributeFeature("            ", attribute);
						print("            ", "since="+attrAssoc.getValidSince());
						print("            ", "until="+attrAssoc.getValidUntil());
					}
					print("        ", "end attribute associations.");
				}
				
				if( assoc instanceof HyTimedImplementationEnumLink ) {
					HyTimedImplementationEnumLink assocEnum = (HyTimedImplementationEnumLink) assoc;
					print("        ", "local=");
					HyEnum _enum = assocEnum.getLocal();
					visitHyEnum("        ", _enum);
					print("        ", "signature=");
					_enum = assocEnum.getSignature();
					visitHyEnum("        ", _enum);
					print("        ", "since="+assocEnum.getValidSince());
					print("        ", "until="+assocEnum.getValidUntil());

					print("        ", "Enum associations:");
					EList<HyTimedImplementationEnumLiteralLink> enumAssociations = assocEnum.getAssociations();
					int countEnumAssoc=0;
					for( HyTimedImplementationEnumLiteralLink enumAssoc: enumAssociations) {
						countEnumAssoc++;
						print("          ", countEnumAssoc+") ");
						print("            ", "local=");
						HyEnumLiteral enumLiteral = enumAssoc.getLocal();
						visitHyEnumLiteral("            ", enumLiteral);
						print("            ", "signature=");
						enumLiteral = enumAssoc.getSignature();
						visitHyEnumLiteral("            ", enumLiteral);
						print("            ", "since="+enumAssoc.getValidSince());
						print("            ", "until="+enumAssoc.getValidUntil());
					}
					print("        ", "end enum associations.");
				}
			}
			print("    ", "end associations.");

		}
		print("", "end implementations.");
		print("", "End visit HySPLImplementation\n\n");

	}	
	
	public static void visitHySPLSignature (String prefix, HySPLSignature signature) {
		print(prefix+"  ", "PRINT Signature");
		//visitHyName(prefix+"  ", signature.getNames());
	}

	public static void visitHyFeature (String prefix, HyFeature feature) {
		visitHyName(prefix+"  ", feature.getNames());
		print(prefix+"    ", "id="+feature.getId());
		print(prefix+"    ", "since="+feature.getValidSince());
		print(prefix+"    ", "until="+feature.getValidUntil());
	}
	
	public static void visitHyAttributeFeature (String prefix, HyFeatureAttribute attribute) {
		visitHyName(prefix+"  ", attribute.getNames());
		print(prefix+"    ", "id="+attribute.getId());
		print(prefix+"    ", "since="+attribute.getValidSince());
		print(prefix+"    ", "until="+attribute.getValidUntil());
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

	public static void visitHyEnum (String prefix, HyEnum _enum) {
		print(prefix+"    ", "name="+_enum.getName());
		print(prefix+"    ", "id="+_enum.getId());
		print(prefix+"    ", "since="+_enum.getValidSince());
		print(prefix+"    ", "until="+_enum.getValidUntil());
	}

	public static void visitHyEnumLiteral (String prefix, HyEnumLiteral enumLiteral) {
		print(prefix+"    ", "name="+enumLiteral.getName());
		print(prefix+"    ", "value="+enumLiteral.getValue());
		print(prefix+"    ", "id="+enumLiteral.getId());
		print(prefix+"    ", "since="+enumLiteral.getValidSince());
		print(prefix+"    ", "until="+enumLiteral.getValidUntil());
	}

	
	
	public static void print(String prefix, String str) {
		if (PrintDebug) {
			System.out.println(prefix+str);
		}
	}

}
