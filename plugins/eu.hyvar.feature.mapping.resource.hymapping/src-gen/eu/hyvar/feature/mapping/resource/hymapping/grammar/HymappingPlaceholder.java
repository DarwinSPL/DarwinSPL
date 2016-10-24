/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class HymappingPlaceholder extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingTerminal {
	
	private final String tokenName;
	
	public HymappingPlaceholder(EStructuralFeature feature, String tokenName, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
