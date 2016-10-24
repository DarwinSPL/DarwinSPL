/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class HyexpressionSyntaxElement {
	
	private HyexpressionSyntaxElement[] children;
	private HyexpressionSyntaxElement parent;
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality;
	
	public HyexpressionSyntaxElement(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, HyexpressionSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (HyexpressionSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(HyexpressionSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public HyexpressionSyntaxElement getParent() {
		return parent;
	}
	
	public HyexpressionSyntaxElement[] getChildren() {
		if (children == null) {
			return new HyexpressionSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality getCardinality() {
		return cardinality;
	}
	
}
