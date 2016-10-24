/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <p>
 * An interface for factories to create instances of
 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationContextDepen
 * dentURIFragment.
 * </p>
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IHycontextinformationContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {
	
	/**
	 * <p>
	 * Create a new instance of the
	 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationContextDepen
	 * dentURIFragment interface.
	 * </p>
	 * 
	 * @param identifier the identifier that references an Object
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is
	 * multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * 
	 * @return the new instance of
	 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationContextDepen
	 * dentURIFragment
	 */
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy);
}
