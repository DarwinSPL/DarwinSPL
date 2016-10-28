/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

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
public class HydatavalueContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public HydatavalueContextDependentURIFragmentFactory(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
