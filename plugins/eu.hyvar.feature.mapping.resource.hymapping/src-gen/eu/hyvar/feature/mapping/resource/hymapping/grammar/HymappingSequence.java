/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;


public class HymappingSequence extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement {
	
	public HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return eu.hyvar.feature.mapping.resource.hymapping.util.HymappingStringUtil.explode(getChildren(), " ");
	}
	
}
