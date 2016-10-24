/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHyexpressionCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
