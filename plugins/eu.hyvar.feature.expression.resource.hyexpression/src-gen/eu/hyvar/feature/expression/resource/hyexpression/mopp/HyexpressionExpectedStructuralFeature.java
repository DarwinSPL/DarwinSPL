/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class HyexpressionExpectedStructuralFeature extends eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionAbstractExpectedElement {
	
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder placeholder;
	
	public HyexpressionExpectedStructuralFeature(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement getSymtaxElement() {
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
		if (o instanceof HyexpressionExpectedStructuralFeature) {
			return getFeature().equals(((HyexpressionExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
