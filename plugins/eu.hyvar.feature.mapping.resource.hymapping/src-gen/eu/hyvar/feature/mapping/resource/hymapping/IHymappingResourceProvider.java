/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IHymappingResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource getResource();
	
}
