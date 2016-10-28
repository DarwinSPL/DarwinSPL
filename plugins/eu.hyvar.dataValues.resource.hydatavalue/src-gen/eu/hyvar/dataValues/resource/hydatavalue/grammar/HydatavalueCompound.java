/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;


public class HydatavalueCompound extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement {
	
	public HydatavalueCompound(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice choice, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality) {
		super(cardinality, new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
