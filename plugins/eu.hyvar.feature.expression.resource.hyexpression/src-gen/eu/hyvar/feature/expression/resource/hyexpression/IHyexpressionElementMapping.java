/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;


/**
 * <p>
 * A mapping from an identifier to an EObject.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IHyexpressionElementMapping<ReferenceType> extends eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
