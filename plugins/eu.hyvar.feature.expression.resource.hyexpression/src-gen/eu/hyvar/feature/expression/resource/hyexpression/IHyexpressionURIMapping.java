/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * Implementors of this interface map identifiers to URIs. This is sometimes
 * necessary when resolving references depends on the resolution of others.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping.
 */
public interface IHyexpressionURIMapping<ReferenceType> extends eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping<ReferenceType> {
	
	/**
	 * Returns an alternative proxy URI that should follow EMF's default naming scheme
	 * such that it can be resolved by the default resolution mechanism that will be
	 * called on this URI (see <code>Resource.getEObject()</code>).
	 */
	public URI getTargetIdentifier();
	
}
