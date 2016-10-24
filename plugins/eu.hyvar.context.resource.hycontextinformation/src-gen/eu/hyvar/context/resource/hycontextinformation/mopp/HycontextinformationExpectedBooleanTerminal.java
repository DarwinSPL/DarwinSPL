/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class HycontextinformationExpectedBooleanTerminal extends eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationAbstractExpectedElement {
	
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal booleanTerminal;
	
	public HycontextinformationExpectedBooleanTerminal(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof HycontextinformationExpectedBooleanTerminal) {
			return getFeature().equals(((HycontextinformationExpectedBooleanTerminal) o).getFeature());
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
