/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;


/**
 * <p>
 * A mapping from an identifier to an EObject.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IHyvalidityformulaElementMapping<ReferenceType> extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
