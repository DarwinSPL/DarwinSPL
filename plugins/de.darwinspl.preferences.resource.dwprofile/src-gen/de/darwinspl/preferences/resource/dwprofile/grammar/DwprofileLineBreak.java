/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;


public class DwprofileLineBreak extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileFormattingElement {
	
	private final int tabs;
	
	public DwprofileLineBreak(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, int tabs) {
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
