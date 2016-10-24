/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HyexpressionKeyword extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement {
	
	private final String value;
	
	public HyexpressionKeyword(String value, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
