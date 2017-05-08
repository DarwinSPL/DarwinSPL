/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'eu.hyvar.mspl.manifest.resource.hymanifest.default_load_options' with the
 * difference that the options defined in this class are used even if no Eclipse
 * platform is running.
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.Collections;
import java.util.Map;

public class HymanifestOptionProvider implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestOptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
