/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HyvalidityformulaRule extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement {
	
	private final EClass metaclass;
	
	public HyvalidityformulaRule(EClass metaclass, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice choice, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality) {
		super(cardinality, new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getDefinition() {
		return (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice) getChildren()[0];
	}
	
	@Deprecated
	public String toString() {
		return metaclass == null ? "null" : metaclass.getName() + " ::= " + getDefinition().toString();
	}
	
}

