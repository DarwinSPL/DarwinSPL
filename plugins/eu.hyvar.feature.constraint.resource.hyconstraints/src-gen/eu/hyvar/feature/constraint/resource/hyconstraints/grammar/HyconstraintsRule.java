/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HyconstraintsRule extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement {
	
	private final EClass metaclass;
	
	public HyconstraintsRule(EClass metaclass, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice choice, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality) {
		super(cardinality, new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getDefinition() {
		return (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice) getChildren()[0];
	}
	
	@Deprecated
	public String toString() {
		return metaclass == null ? "null" : metaclass.getName() + " ::= " + getDefinition().toString();
	}
	
}

