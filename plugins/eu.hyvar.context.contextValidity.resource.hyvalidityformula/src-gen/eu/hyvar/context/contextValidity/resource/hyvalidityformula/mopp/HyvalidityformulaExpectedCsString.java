/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HyvalidityformulaExpectedCsString extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaAbstractExpectedElement {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword keyword;
	
	public HyvalidityformulaExpectedCsString(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement getSyntaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HyvalidityformulaExpectedCsString) {
			return getValue().equals(((HyvalidityformulaExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
