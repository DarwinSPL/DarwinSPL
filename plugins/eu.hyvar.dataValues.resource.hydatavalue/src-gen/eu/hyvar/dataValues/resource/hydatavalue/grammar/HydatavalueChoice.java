/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;


public class HydatavalueChoice extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement {
	
	public HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueStringUtil.explode(getChildren(), "|");
	}
	
}
