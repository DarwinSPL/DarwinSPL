/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HydatavalueKeyword extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement {
	
	private final String value;
	
	public HydatavalueKeyword(String value, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality) {
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
