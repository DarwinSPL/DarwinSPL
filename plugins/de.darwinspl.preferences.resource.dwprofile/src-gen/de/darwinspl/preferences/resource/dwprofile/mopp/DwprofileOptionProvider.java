/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'de.darwinspl.preferences.resource.dwprofile.default_load_options' with the
 * difference that the options defined in this class are used even if no Eclipse
 * platform is running.
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collections;
import java.util.Map;

public class DwprofileOptionProvider implements de.darwinspl.preferences.resource.dwprofile.IDwprofileOptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
