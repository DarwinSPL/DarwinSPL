/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HyconstraintsKeyword extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement {
	
	private final String value;
	
	public HyconstraintsKeyword(String value, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality) {
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
