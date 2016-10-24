/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue;


/**
 * <p>
 * A mapping from an identifier to an EObject.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IHydatavalueElementMapping<ReferenceType> extends eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
