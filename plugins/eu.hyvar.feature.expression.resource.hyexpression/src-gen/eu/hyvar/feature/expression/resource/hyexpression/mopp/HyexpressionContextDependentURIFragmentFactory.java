/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

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
public class HyexpressionContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public HyexpressionContextDependentURIFragmentFactory(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
