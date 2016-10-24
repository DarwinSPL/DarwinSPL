/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class HyexpressionBooleanTerminal extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public HyexpressionBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, int mandatoryOccurrencesAfter) {
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
