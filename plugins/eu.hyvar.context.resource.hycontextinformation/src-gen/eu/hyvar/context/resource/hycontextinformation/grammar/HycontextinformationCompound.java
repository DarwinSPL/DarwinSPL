/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;


public class HycontextinformationCompound extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement {
	
	public HycontextinformationCompound(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice choice, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality) {
		super(cardinality, new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
