/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HymappingKeyword extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement {
	
	private final String value;
	
	public HymappingKeyword(String value, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality) {
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
