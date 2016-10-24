/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHycontextinformationResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationResourcePostProcessor getResourcePostProcessor();
	
}
