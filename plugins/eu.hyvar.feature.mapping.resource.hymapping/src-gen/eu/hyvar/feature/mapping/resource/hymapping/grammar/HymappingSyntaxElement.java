/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class HymappingSyntaxElement {
	
	private HymappingSyntaxElement[] children;
	private HymappingSyntaxElement parent;
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality;
	
	public HymappingSyntaxElement(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality, HymappingSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (HymappingSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(HymappingSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public HymappingSyntaxElement getParent() {
		return parent;
	}
	
	/**
	 * Returns the rule of this syntax element. The rule is determined by the
	 * containment hierarchy in the CS model.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getRule() {
		if (this instanceof eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule) {
			return (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule) this;
		}
		return parent.getRule();
	}
	
	public HymappingSyntaxElement[] getChildren() {
		if (children == null) {
			return new HymappingSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality getCardinality() {
		return cardinality;
	}
	
	public boolean hasContainment(EClass metaclass) {
		eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement[] children = getChildren();
		for (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement child : children) {
			if (child.hasContainment(metaclass)) {
				return true;
			}
		}
		return false;
	}
	
}
