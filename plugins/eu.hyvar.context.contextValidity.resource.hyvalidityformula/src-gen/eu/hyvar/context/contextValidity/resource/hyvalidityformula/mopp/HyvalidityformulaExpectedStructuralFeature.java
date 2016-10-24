/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class HyvalidityformulaExpectedStructuralFeature extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaAbstractExpectedElement {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder placeholder;
	
	public HyvalidityformulaExpectedStructuralFeature(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement getSymtaxElement() {
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
		if (o instanceof HyvalidityformulaExpectedStructuralFeature) {
			return getFeature().equals(((HyvalidityformulaExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
