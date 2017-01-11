/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;


public class HycontextinformationChoice extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement {
	
	public HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationStringUtil.explode(getChildren(), "|");
	}
	
}
