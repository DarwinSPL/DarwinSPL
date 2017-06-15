/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <p>
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * </p>
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class HymanifestContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public HymanifestContextDependentURIFragmentFactory(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
