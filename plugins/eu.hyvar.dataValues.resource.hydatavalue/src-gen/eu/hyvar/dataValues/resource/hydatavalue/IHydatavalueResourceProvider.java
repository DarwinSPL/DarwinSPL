/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IHydatavalueResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource getResource();
	
}
