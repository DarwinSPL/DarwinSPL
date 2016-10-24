/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHyexpressionResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionResourcePostProcessor getResourcePostProcessor();
	
}
