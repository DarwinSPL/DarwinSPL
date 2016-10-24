/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class HydatavaluePlaceholder extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueTerminal {
	
	private final String tokenName;
	
	public HydatavaluePlaceholder(EStructuralFeature feature, String tokenName, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
