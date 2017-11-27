/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;


public class DwprofileSequence extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement {
	
	public DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return de.darwinspl.preferences.resource.dwprofile.util.DwprofileStringUtil.explode(getChildren(), " ");
	}
	
}
