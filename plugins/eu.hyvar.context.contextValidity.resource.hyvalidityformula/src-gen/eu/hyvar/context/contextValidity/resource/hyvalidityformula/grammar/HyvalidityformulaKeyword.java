/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HyvalidityformulaKeyword extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement {
	
	private final String value;
	
	public HyvalidityformulaKeyword(String value, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return "\"" + value + "\"";
	}
	
}
