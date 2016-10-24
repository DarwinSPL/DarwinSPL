/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;


public class HyconstraintsWhiteSpace extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsFormattingElement {
	
	private final int amount;
	
	public HyconstraintsWhiteSpace(int amount, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality) {
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
