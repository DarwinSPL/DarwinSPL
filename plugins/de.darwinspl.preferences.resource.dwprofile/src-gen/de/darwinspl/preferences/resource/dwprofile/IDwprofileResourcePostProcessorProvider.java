/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IDwprofileResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileResourcePostProcessor getResourcePostProcessor();
	
}
