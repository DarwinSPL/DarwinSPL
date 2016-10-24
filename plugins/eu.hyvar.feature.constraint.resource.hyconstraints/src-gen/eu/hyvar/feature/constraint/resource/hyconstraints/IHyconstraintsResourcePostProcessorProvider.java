/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHyconstraintsResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsResourcePostProcessor getResourcePostProcessor();
	
}
