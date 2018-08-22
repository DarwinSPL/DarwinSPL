/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class DwprofileSyntaxElement {
	
	private DwprofileSyntaxElement[] children;
	private DwprofileSyntaxElement parent;
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality;
	
	public DwprofileSyntaxElement(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, DwprofileSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (DwprofileSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(DwprofileSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public DwprofileSyntaxElement getParent() {
		return parent;
	}
	
	/**
	 * Returns the rule of this syntax element. The rule is determined by the
	 * containment hierarchy in the CS model.
	 */
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getRule() {
		if (this instanceof de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule) {
			return (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule) this;
		}
		return parent.getRule();
	}
	
	public DwprofileSyntaxElement[] getChildren() {
		if (children == null) {
			return new DwprofileSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality getCardinality() {
		return cardinality;
	}
	
	public boolean hasContainment(EClass metaclass) {
		de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement[] children = getChildren();
		for (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement child : children) {
			if (child.hasContainment(metaclass)) {
				return true;
			}
		}
		return false;
	}
	
}
