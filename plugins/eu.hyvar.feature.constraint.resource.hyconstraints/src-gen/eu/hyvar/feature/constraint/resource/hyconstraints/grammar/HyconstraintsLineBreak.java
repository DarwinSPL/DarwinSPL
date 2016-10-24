/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;


public class HyconstraintsLineBreak extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsFormattingElement {
	
	private final int tabs;
	
	public HyconstraintsLineBreak(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, int tabs) {
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
