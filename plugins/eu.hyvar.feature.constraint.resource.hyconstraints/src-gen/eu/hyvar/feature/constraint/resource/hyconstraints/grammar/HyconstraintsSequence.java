/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;


public class HyconstraintsSequence extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement {
	
	public HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsStringUtil.explode(getChildren(), " ");
	}
	
}
