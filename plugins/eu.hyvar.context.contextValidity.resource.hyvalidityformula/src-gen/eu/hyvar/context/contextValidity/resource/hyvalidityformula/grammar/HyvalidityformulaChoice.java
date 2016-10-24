/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;


public class HyvalidityformulaChoice extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement {
	
	public HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaStringUtil.explode(getChildren(), "|");
	}
	
}
