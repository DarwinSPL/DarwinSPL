/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class HyvalidityformulaPlaceholder extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaTerminal {
	
	private final String tokenName;
	
	public HyvalidityformulaPlaceholder(EStructuralFeature feature, String tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
