/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;

import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IHycontextinformationParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>> getPostParseCommands();
	
	/**
	 * Returns a map that can be used to retrieve the position of objects in the
	 * parsed text.
	 */
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap getLocationMap();
	
}
