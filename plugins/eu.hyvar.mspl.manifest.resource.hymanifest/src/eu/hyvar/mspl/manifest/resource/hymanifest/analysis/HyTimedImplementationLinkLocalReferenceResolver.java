/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.expression.util.HyExpressionResolverUtil;

public class HyTimedImplementationLinkLocalReferenceResolver implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature> {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature> delegate = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>();
	
	public void resolve(String identifier, eu.hyvar.mspl.manifest.HyTimedImplementationLink container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<eu.hyvar.feature.HyFeature> result) {
		HyFeature feature = HyExpressionResolverUtil.resolveFeature(identifier, container);
		if(feature!=null) {
			result.addMapping(identifier, feature);
		}

		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(eu.hyvar.feature.HyFeature element, eu.hyvar.mspl.manifest.HyTimedImplementationLink container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
