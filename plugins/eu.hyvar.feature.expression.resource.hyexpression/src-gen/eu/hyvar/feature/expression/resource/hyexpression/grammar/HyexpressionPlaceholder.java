/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class HyexpressionPlaceholder extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionTerminal {
	
	private final String tokenName;
	
	public HyexpressionPlaceholder(EStructuralFeature feature, String tokenName, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
