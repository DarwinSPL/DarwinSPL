/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class HymanifestPlaceholder extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestTerminal {
	
	private final String tokenName;
	
	public HymanifestPlaceholder(EStructuralFeature feature, String tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
