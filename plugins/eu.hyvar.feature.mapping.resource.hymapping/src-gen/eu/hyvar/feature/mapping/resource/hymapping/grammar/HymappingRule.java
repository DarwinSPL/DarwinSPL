/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HymappingRule extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement {
	
	private final EClass metaclass;
	
	public HymappingRule(EClass metaclass, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice choice, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality) {
		super(cardinality, new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getDefinition() {
		return (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice) getChildren()[0];
	}
	
}

