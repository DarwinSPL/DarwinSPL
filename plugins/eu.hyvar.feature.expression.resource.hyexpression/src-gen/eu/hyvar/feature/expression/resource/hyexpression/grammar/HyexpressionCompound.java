/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;


public class HyexpressionCompound extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement {
	
	public HyexpressionCompound(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice choice, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality) {
		super(cardinality, new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
