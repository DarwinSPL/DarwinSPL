/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;


public class HycontextinformationWhiteSpace extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationFormattingElement {
	
	private final int amount;
	
	public HycontextinformationWhiteSpace(int amount, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality) {
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
