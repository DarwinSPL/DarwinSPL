/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.ArrayList;
import java.util.List;

public class HymappingSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private HymappingSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public HymappingSyntaxElementDecorator(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement decoratedElement, HymappingSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public HymappingSyntaxElementDecorator[] getChildDecorators() {
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
