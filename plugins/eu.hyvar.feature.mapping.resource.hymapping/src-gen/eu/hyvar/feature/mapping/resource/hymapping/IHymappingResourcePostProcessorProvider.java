/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHymappingResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingResourcePostProcessor getResourcePostProcessor();
	
}
