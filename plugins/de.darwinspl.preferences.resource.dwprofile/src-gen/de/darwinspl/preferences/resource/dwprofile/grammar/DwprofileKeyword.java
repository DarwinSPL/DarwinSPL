/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class DwprofileKeyword extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement {
	
	private final String value;
	
	public DwprofileKeyword(String value, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
