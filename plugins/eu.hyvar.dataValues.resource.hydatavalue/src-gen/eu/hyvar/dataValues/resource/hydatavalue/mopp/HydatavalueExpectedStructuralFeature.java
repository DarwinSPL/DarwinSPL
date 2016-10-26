/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class HydatavalueExpectedStructuralFeature extends eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueAbstractExpectedElement {
	
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder placeholder;
	
	public HydatavalueExpectedStructuralFeature(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement getSyntaxElement() {
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
		if (o instanceof HydatavalueExpectedStructuralFeature) {
			return getFeature().equals(((HydatavalueExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
