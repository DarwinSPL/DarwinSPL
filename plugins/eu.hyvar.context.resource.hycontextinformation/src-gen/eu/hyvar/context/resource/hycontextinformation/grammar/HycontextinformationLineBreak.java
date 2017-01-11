/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;


public class HycontextinformationLineBreak extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationFormattingElement {
	
	private final int tabs;
	
	public HycontextinformationLineBreak(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, int tabs) {
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
