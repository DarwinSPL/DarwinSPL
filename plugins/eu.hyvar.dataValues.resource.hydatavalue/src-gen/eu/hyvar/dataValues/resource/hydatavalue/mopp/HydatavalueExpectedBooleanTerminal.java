/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class HydatavalueExpectedBooleanTerminal extends eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueAbstractExpectedElement {
	
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal booleanTerminal;
	
	public HydatavalueExpectedBooleanTerminal(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement getSyntaxElement() {
		return booleanTerminal;
	}
	
	private EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof HydatavalueExpectedBooleanTerminal) {
			return getFeature().equals(((HydatavalueExpectedBooleanTerminal) o).getFeature());
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
