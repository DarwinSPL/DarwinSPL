/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HydatavalueRule extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement {
	
	private final EClass metaclass;
	
	public HydatavalueRule(EClass metaclass, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice choice, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality) {
		super(cardinality, new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getDefinition() {
		return (eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice) getChildren()[0];
	}
	
}

