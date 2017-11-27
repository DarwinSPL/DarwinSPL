/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class DwprofileExpectedCsString extends de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAbstractExpectedElement {
	
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword keyword;
	
	public DwprofileExpectedCsString(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof DwprofileExpectedCsString) {
			return getValue().equals(((DwprofileExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
