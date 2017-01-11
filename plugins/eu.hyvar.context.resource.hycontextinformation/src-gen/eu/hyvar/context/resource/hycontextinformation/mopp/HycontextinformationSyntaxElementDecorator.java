/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.ArrayList;
import java.util.List;

public class HycontextinformationSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private HycontextinformationSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public HycontextinformationSyntaxElementDecorator(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement decoratedElement, HycontextinformationSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public HycontextinformationSyntaxElementDecorator[] getChildDecorators() {
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
