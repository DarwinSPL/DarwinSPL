/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;


public class HymappingLineBreak extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingFormattingElement {
	
	private final int tabs;
	
	public HymappingLineBreak(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality, int tabs) {
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
