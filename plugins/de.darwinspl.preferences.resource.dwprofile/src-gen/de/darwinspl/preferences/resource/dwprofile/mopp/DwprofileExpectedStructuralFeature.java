/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class DwprofileExpectedStructuralFeature extends de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAbstractExpectedElement {
	
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder placeholder;
	
	public DwprofileExpectedStructuralFeature(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getSyntaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof DwprofileExpectedStructuralFeature) {
			return getFeature().equals(((DwprofileExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
