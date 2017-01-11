/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

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
public class HycontextinformationContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public HycontextinformationContextDependentURIFragmentFactory(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
