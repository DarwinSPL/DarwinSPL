/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HymappingExpectedCsString extends eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingAbstractExpectedElement {
	
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword keyword;
	
	public HymappingExpectedCsString(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement getSyntaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HymappingExpectedCsString) {
			return getValue().equals(((HymappingExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
