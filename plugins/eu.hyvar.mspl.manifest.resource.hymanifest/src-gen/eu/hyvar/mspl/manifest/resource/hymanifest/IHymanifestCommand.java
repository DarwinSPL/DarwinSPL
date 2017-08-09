/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHymanifestCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
