/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHyvalidityformulaCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
