/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HyexpressionExpectedCsString extends eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionAbstractExpectedElement {
	
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword keyword;
	
	public HyexpressionExpectedCsString(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HyexpressionExpectedCsString) {
			return getValue().equals(((HyexpressionExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
