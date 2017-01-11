/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HycontextinformationRule extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement {
	
	private final EClass metaclass;
	
	public HycontextinformationRule(EClass metaclass, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice choice, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality) {
		super(cardinality, new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getDefinition() {
		return (eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice) getChildren()[0];
	}
	
}

