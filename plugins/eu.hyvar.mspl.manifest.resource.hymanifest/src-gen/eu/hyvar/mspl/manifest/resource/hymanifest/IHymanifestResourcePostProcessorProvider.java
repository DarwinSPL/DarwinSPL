/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IHymanifestResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestResourcePostProcessor getResourcePostProcessor();
	
}
