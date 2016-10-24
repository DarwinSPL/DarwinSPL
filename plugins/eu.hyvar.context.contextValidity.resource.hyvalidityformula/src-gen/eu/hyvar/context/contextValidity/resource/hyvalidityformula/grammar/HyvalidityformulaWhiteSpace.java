/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;


public class HyvalidityformulaWhiteSpace extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaFormattingElement {
	
	private final int amount;
	
	public HyvalidityformulaWhiteSpace(int amount, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality) {
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
