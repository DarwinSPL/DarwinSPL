/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class DwprofileRule extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement {
	
	private final EClass metaclass;
	
	public DwprofileRule(EClass metaclass, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice choice, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality) {
		super(cardinality, new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getDefinition() {
		return (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice) getChildren()[0];
	}
	
}

