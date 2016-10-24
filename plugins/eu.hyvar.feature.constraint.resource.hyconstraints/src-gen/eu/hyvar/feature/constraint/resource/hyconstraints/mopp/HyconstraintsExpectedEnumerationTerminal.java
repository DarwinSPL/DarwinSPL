/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class HyconstraintsExpectedEnumerationTerminal extends eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsAbstractExpectedElement {
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal enumerationTerminal;
	
	public HyconstraintsExpectedEnumerationTerminal(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		Set<String> tokenNames = new LinkedHashSet<String>();
		Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}
