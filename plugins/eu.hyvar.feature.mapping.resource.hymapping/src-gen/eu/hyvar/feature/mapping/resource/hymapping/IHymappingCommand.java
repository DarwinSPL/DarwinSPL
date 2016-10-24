/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHymappingCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
