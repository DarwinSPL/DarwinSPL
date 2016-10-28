/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class HydatavalueSyntaxElement {
	
	private HydatavalueSyntaxElement[] children;
	private HydatavalueSyntaxElement parent;
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality;
	
	public HydatavalueSyntaxElement(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality, HydatavalueSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (HydatavalueSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(HydatavalueSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public HydatavalueSyntaxElement getParent() {
		return parent;
	}
	
	public HydatavalueSyntaxElement[] getChildren() {
		if (children == null) {
			return new HydatavalueSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality getCardinality() {
		return cardinality;
	}
	
}
