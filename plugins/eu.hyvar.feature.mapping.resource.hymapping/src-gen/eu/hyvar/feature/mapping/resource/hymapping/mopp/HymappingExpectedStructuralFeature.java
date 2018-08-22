/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class HymappingExpectedStructuralFeature extends eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingAbstractExpectedElement {
	
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder placeholder;
	
	public HymappingExpectedStructuralFeature(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement getSyntaxElement() {
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
		if (o instanceof HymappingExpectedStructuralFeature) {
			return getFeature().equals(((HymappingExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
