/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;


public class HyexpressionChoice extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement {
	
	public HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionStringUtil.explode(getChildren(), "|");
	}
	
}
