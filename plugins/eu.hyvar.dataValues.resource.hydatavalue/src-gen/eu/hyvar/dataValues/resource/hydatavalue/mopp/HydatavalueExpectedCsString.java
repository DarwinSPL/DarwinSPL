/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class HydatavalueExpectedCsString extends eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueAbstractExpectedElement {
	
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword keyword;
	
	public HydatavalueExpectedCsString(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof HydatavalueExpectedCsString) {
			return getValue().equals(((HydatavalueExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
