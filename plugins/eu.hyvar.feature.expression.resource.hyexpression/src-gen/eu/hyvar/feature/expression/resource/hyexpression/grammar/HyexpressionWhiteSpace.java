/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;


public class HyexpressionWhiteSpace extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionFormattingElement {
	
	private final int amount;
	
	public HyexpressionWhiteSpace(int amount, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
