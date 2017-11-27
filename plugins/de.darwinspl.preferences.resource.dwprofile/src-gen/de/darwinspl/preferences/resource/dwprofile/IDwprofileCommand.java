/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IDwprofileCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
