/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'eu.hyvar.context.contextValidity.resource.hyvalidityformula.default_load_option
 * s' with the difference that the options defined in this class are used even if
 * no Eclipse platform is running.
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.Collections;
import java.util.Map;

public class HyvalidityformulaOptionProvider implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
