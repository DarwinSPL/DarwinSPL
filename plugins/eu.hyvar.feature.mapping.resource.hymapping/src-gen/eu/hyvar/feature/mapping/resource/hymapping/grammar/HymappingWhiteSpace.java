/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;


public class HymappingWhiteSpace extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingFormattingElement {
	
	private final int amount;
	
	public HymappingWhiteSpace(int amount, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality) {
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
