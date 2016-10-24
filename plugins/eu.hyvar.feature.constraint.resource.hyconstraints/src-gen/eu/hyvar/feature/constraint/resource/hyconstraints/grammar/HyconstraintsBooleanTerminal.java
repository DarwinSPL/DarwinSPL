/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class HyconstraintsBooleanTerminal extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public HyconstraintsBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public EAttribute getAttribute() {
		return (EAttribute) getFeature();
	}
	
}
