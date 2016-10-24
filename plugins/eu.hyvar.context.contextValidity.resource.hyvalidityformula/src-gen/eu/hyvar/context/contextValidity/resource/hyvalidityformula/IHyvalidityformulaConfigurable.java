/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface IHyvalidityformulaConfigurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(Map<?,?> options);
}
