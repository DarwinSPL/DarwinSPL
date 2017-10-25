/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

public class DwprofileTerminal extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement {
	
	private final EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public DwprofileTerminal(EStructuralFeature feature, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
