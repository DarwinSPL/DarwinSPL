/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;


public class HydatavalueLineBreak extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueFormattingElement {
	
	private final int tabs;
	
	public HydatavalueLineBreak(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality, int tabs) {
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
