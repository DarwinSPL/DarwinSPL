/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IHycontextinformationResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource getResource();
	
}
