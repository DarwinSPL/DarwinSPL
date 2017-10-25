/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class DwprofileBooleanTerminal extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public DwprofileBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, int mandatoryOccurrencesAfter) {
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
