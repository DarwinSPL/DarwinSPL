/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import java.util.Map;

/**
 * Implementors of this interface can provide options that are used when resources
 * are loaded.
 */
public interface IDwprofileOptionProvider {
	
	/**
	 * Returns a map of options. The keys are the names of the options, the values are
	 * arbitrary objects that provide additional information or logic for the option.
	 */
	public Map<?,?> getOptions();
	
}
