/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;


public class HyexpressionLineBreak extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionFormattingElement {
	
	private final int tabs;
	
	public HyexpressionLineBreak(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
