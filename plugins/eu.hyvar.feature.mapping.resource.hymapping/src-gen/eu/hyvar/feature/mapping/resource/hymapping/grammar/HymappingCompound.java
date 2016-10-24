/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;


public class HymappingCompound extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement {
	
	public HymappingCompound(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice choice, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality) {
		super(cardinality, new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
