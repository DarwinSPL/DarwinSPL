/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;


public class HymappingChoice extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement {
	
	public HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.feature.mapping.resource.hymapping.util.HymappingStringUtil.explode(getChildren(), "|");
	}
	
}
