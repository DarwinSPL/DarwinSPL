/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class HycontextinformationPlaceholder extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationTerminal {
	
	private final String tokenName;
	
	public HycontextinformationPlaceholder(EStructuralFeature feature, String tokenName, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
