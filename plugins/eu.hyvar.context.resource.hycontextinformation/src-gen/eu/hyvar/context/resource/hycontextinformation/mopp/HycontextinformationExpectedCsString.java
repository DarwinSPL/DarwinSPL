/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HycontextinformationExpectedCsString extends eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationAbstractExpectedElement {
	
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword keyword;
	
	public HycontextinformationExpectedCsString(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HycontextinformationExpectedCsString) {
			return getValue().equals(((HycontextinformationExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
