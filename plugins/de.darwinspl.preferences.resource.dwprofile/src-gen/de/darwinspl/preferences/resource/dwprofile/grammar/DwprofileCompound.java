/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;


public class DwprofileCompound extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement {
	
	public DwprofileCompound(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice choice, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality) {
		super(cardinality, new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
