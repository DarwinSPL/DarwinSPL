/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

public class HyconstraintsTerminal extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement {
	
	private final EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public HyconstraintsTerminal(EStructuralFeature feature, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, int mandatoryOccurencesAfter) {
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
