/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.analysis;

import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceMapping;
import eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestElementMapping;

public class HyTimedDependenciesSignatureReferenceResolver implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedDependencies, eu.hyvar.mspl.manifest.HySPLSignature> {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedDependencies, eu.hyvar.mspl.manifest.HySPLSignature> delegate = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedDependencies, eu.hyvar.mspl.manifest.HySPLSignature>();
	
	public void resolve(String identifier, eu.hyvar.mspl.manifest.HyTimedDependencies container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<eu.hyvar.mspl.manifest.HySPLSignature> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		
		if(result.wasResolved()) {
			Iterator<IHymanifestReferenceMapping<HySPLSignature>> map = result.getMappings().iterator();
			while(map.hasNext()) {
				IHymanifestReferenceMapping<HySPLSignature> referenceElement = map.next();
				if(referenceElement instanceof eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestElementMapping) {
					HymanifestElementMapping<HySPLSignature> resolved = (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestElementMapping<HySPLSignature>) referenceElement;
					resolved.getTargetElement().setName(identifier);
				}
			}
		}
	}
	
	public String deResolve(eu.hyvar.mspl.manifest.HySPLSignature element, eu.hyvar.mspl.manifest.HyTimedDependencies container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
