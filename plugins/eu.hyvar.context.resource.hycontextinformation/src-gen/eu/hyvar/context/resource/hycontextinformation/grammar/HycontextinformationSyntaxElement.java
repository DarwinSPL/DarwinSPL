/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class HycontextinformationSyntaxElement {
	
	private HycontextinformationSyntaxElement[] children;
	private HycontextinformationSyntaxElement parent;
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality;
	
	public HycontextinformationSyntaxElement(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, HycontextinformationSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (HycontextinformationSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(HycontextinformationSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public HycontextinformationSyntaxElement getParent() {
		return parent;
	}
	
	public HycontextinformationSyntaxElement[] getChildren() {
		if (children == null) {
			return new HycontextinformationSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality getCardinality() {
		return cardinality;
	}
	
}
