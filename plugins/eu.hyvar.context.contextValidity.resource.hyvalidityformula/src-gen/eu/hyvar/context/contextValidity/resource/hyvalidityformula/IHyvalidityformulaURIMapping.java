/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * Implementors of this interface map identifiers to URIs. This is sometimes
 * necessary when resolving references depends on the resolution of others.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaRe
 * ferenceMapping.
 */
public interface IHyvalidityformulaURIMapping<ReferenceType> extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceMapping<ReferenceType> {
	
	/**
	 * Returns an alternative proxy URI that should follow EMF's default naming scheme
	 * such that it can be resolved by the default resolution mechanism that will be
	 * called on this URI (see <code>Resource.getEObject()</code>).
	 */
	public URI getTargetIdentifier();
	
}
