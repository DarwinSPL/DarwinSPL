/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class HydatavalueBooleanTerminal extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public HydatavalueBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality, int mandatoryOccurrencesAfter) {
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
