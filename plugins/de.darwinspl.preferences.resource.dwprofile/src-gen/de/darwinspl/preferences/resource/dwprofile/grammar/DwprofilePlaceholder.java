/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class DwprofilePlaceholder extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileTerminal {
	
	private final String tokenName;
	
	public DwprofilePlaceholder(EStructuralFeature feature, String tokenName, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
