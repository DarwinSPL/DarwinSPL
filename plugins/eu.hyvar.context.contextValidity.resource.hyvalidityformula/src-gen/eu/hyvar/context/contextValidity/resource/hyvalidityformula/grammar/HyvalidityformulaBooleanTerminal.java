/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class HyvalidityformulaBooleanTerminal extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public HyvalidityformulaBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality, int mandatoryOccurrencesAfter) {
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
