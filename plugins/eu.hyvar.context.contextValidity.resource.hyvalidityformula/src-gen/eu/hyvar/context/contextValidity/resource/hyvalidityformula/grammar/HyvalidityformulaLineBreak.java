/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;


public class HyvalidityformulaLineBreak extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaFormattingElement {
	
	private final int tabs;
	
	public HyvalidityformulaLineBreak(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality, int tabs) {
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
