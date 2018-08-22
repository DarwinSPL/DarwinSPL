/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class HyvalidityformulaSyntaxElement {
	
	private HyvalidityformulaSyntaxElement[] children;
	private HyvalidityformulaSyntaxElement parent;
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality;
	
	public HyvalidityformulaSyntaxElement(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality, HyvalidityformulaSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (HyvalidityformulaSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(HyvalidityformulaSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public HyvalidityformulaSyntaxElement getParent() {
		return parent;
	}
	
	/**
	 * Returns the rule of this syntax element. The rule is determined by the
	 * containment hierarchy in the CS model.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getRule() {
		if (this instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule) {
			return (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule) this;
		}
		return parent.getRule();
	}
	
	public HyvalidityformulaSyntaxElement[] getChildren() {
		if (children == null) {
			return new HyvalidityformulaSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality getCardinality() {
		return cardinality;
	}
	
	public boolean hasContainment(EClass metaclass) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement[] children = getChildren();
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement child : children) {
			if (child.hasContainment(metaclass)) {
				return true;
			}
		}
		return false;
	}
	
}
