/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHydatavalueResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueResourcePostProcessor getResourcePostProcessor();
	
}
