/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EReference;

public class HyTimedImplementationsSignatureReferenceResolver implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementations, eu.hyvar.mspl.manifest.HySPLSignature> {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementations, eu.hyvar.mspl.manifest.HySPLSignature> delegate = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementations, eu.hyvar.mspl.manifest.HySPLSignature>();
	
	public void resolve(String identifier, eu.hyvar.mspl.manifest.HyTimedImplementations container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<eu.hyvar.mspl.manifest.HySPLSignature> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(eu.hyvar.mspl.manifest.HySPLSignature element, eu.hyvar.mspl.manifest.HyTimedImplementations container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
