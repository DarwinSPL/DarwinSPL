/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.ArrayList;
import java.util.List;

public class HydatavalueSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private HydatavalueSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public HydatavalueSyntaxElementDecorator(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement decoratedElement, HydatavalueSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public HydatavalueSyntaxElementDecorator[] getChildDecorators() {
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
