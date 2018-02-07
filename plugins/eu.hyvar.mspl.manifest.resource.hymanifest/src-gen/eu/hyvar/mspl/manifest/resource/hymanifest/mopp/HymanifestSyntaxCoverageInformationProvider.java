/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import org.eclipse.emf.ecore.EClass;

public class HymanifestSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(),
		};
	}
	
}
