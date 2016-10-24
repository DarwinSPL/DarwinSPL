/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;


public class HyexpressionSequence extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement {
	
	public HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionStringUtil.explode(getChildren(), " ");
	}
	
}
