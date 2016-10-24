/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

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
public class HyconstraintsContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public HyconstraintsContextDependentURIFragmentFactory(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
