/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

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
public class DwprofileContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements de.darwinspl.preferences.resource.dwprofile.IDwprofileContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public DwprofileContextDependentURIFragmentFactory(de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
