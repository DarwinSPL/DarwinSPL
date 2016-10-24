/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHyvalidityformulaResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaResourcePostProcessor getResourcePostProcessor();
	
}
