/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class HyconstraintsExpectedStructuralFeature extends eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsAbstractExpectedElement {
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder placeholder;
	
	public HyconstraintsExpectedStructuralFeature(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement getSyntaxElement() {
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
		if (o instanceof HyconstraintsExpectedStructuralFeature) {
			return getFeature().equals(((HyconstraintsExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
