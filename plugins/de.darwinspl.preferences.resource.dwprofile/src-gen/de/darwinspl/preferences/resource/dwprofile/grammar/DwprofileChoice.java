/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;


public class DwprofileChoice extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement {
	
	public DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return de.darwinspl.preferences.resource.dwprofile.util.DwprofileStringUtil.explode(getChildren(), "|");
	}
	
}
