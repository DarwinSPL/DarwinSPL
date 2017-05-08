/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IHymanifestResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource getResource();
	
}
