/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHycontextinformationCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
