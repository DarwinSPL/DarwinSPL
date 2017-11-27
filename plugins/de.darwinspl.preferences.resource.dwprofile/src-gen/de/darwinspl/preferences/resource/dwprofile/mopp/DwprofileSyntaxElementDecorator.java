/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.ArrayList;
import java.util.List;

public class DwprofileSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private DwprofileSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public DwprofileSyntaxElementDecorator(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement decoratedElement, DwprofileSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public DwprofileSyntaxElementDecorator[] getChildDecorators() {
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
