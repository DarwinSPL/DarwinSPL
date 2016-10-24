/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;


public class HyconstraintsChoice extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement {
	
	public HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsStringUtil.explode(getChildren(), "|");
	}
	
}
