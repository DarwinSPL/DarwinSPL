/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HycontextinformationKeyword extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement {
	
	private final String value;
	
	public HycontextinformationKeyword(String value, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality) {
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
