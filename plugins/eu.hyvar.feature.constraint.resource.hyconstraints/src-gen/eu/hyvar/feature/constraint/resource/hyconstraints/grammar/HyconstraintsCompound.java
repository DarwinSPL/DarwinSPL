/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;


public class HyconstraintsCompound extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement {
	
	public HyconstraintsCompound(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice choice, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality) {
		super(cardinality, new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
