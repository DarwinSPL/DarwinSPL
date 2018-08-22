/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class HyconstraintsSyntaxElement {
	
	private HyconstraintsSyntaxElement[] children;
	private HyconstraintsSyntaxElement parent;
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality;
	
	public HyconstraintsSyntaxElement(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, HyconstraintsSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (HyconstraintsSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(HyconstraintsSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public HyconstraintsSyntaxElement getParent() {
		return parent;
	}
	
	/**
	 * Returns the rule of this syntax element. The rule is determined by the
	 * containment hierarchy in the CS model.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getRule() {
		if (this instanceof eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule) {
			return (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule) this;
		}
		return parent.getRule();
	}
	
	public HyconstraintsSyntaxElement[] getChildren() {
		if (children == null) {
			return new HyconstraintsSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality getCardinality() {
		return cardinality;
	}
	
	public boolean hasContainment(EClass metaclass) {
		eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement[] children = getChildren();
		for (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement child : children) {
			if (child.hasContainment(metaclass)) {
				return true;
			}
		}
		return false;
	}
	
}
