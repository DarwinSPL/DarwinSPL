/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HymanifestExpectedCsString extends eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestAbstractExpectedElement {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword keyword;
	
	public HymanifestExpectedCsString(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HymanifestExpectedCsString) {
			return getValue().equals(((HymanifestExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
