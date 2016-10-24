/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IHydatavalueCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
