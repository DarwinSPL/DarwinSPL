/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

public class HymanifestTerminal extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement {
	
	private final EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public HymanifestTerminal(EStructuralFeature feature, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality, int mandatoryOccurencesAfter) {
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
