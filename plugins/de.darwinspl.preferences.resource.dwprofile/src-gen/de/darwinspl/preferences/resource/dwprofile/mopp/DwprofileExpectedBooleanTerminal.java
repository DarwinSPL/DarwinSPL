/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class DwprofileExpectedBooleanTerminal extends de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAbstractExpectedElement {
	
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal booleanTerminal;
	
	public DwprofileExpectedBooleanTerminal(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getSyntaxElement() {
		return booleanTerminal;
	}
	
	private EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof DwprofileExpectedBooleanTerminal) {
			return getFeature().equals(((DwprofileExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
	public Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		Set<String> tokenNames = new LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
