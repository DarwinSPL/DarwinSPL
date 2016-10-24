/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.ArrayList;
import java.util.List;

public class HyconstraintsSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private HyconstraintsSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public HyconstraintsSyntaxElementDecorator(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement decoratedElement, HyconstraintsSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public HyconstraintsSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
