/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HyexpressionRule extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement {
	
	private final EClass metaclass;
	
	public HyexpressionRule(EClass metaclass, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice choice, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality) {
		super(cardinality, new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getDefinition() {
		return (eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice) getChildren()[0];
	}
	
	@Deprecated
	public String toString() {
		return metaclass == null ? "null" : metaclass.getName() + " ::= " + getDefinition().toString();
	}
	
}

