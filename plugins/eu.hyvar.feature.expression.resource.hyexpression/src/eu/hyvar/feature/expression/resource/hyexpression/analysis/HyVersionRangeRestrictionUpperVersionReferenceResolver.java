/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EReference;

public class HyVersionRangeRestrictionUpperVersionReferenceResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion> {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultResolverDelegate<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion> delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultResolverDelegate<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>();
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyVersionRangeRestriction container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.feature.HyVersion> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(eu.hyvar.feature.HyVersion element, eu.hyvar.feature.expression.HyVersionRangeRestriction container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
