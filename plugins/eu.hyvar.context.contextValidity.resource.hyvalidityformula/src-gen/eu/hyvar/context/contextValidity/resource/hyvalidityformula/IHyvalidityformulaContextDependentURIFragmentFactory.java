/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <p>
 * An interface for factories to create instances of
 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCo
 * ntextDependentURIFragment.
 * </p>
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IHyvalidityformulaContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {
	
	/**
	 * <p>
	 * Create a new instance of the
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCo
	 * ntextDependentURIFragment interface.
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
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCo
	 * ntextDependentURIFragment
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy);
}
