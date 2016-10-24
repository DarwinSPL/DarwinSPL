/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HyconstraintsExpectedCsString extends eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsAbstractExpectedElement {
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword keyword;
	
	public HyconstraintsExpectedCsString(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HyconstraintsExpectedCsString) {
			return getValue().equals(((HyconstraintsExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
