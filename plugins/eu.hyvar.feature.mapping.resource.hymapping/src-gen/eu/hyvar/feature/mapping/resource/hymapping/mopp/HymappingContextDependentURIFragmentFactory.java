/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

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
public class HymappingContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public HymappingContextDependentURIFragmentFactory(eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
