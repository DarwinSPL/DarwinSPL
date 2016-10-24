/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHyconstraintsCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
