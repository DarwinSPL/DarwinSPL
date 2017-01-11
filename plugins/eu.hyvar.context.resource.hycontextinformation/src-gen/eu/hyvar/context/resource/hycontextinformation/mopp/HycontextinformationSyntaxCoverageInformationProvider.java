/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import org.eclipse.emf.ecore.EClass;

public class HycontextinformationSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(),
			eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber(),
			eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean(),
			eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(),
		};
	}
	
}
