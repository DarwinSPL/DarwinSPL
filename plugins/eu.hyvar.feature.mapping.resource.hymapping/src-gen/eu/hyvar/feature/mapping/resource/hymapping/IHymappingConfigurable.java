/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface IHymappingConfigurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(Map<?,?> options);
}
