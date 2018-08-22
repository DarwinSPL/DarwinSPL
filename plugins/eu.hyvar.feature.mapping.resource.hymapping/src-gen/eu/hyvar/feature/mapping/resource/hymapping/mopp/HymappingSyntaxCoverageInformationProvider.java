/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.eclipse.emf.ecore.EClass;

public class HymappingSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(),
			org.deltaecore.core.decore.DEcorePackage.eINSTANCE.getDEDeltaInvokation(),
			eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(),
			eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(),
			eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(),
		};
	}
	
}
