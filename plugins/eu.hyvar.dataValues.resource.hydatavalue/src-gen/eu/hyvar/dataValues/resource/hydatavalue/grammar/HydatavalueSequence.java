/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;


public class HydatavalueSequence extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement {
	
	public HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueStringUtil.explode(getChildren(), " ");
	}
	
}
