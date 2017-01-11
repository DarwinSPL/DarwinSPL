/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

public class HycontextinformationTerminal extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement {
	
	private final EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public HycontextinformationTerminal(EStructuralFeature feature, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, int mandatoryOccurencesAfter) {
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
