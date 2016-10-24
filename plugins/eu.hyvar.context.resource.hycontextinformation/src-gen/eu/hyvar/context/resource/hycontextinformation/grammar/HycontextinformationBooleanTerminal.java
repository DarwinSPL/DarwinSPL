/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class HycontextinformationBooleanTerminal extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public HycontextinformationBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, int mandatoryOccurrencesAfter) {
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
