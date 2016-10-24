/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;


/**
 * <p>
 * A mapping from an identifier to an EObject.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IHymappingElementMapping<ReferenceType> extends eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
