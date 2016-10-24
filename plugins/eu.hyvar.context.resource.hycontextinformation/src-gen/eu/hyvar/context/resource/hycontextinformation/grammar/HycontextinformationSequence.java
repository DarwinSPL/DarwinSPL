/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;


public class HycontextinformationSequence extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement {
	
	public HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationStringUtil.explode(getChildren(), " ");
	}
	
}
