/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * A listener interface for classes that need notification when a background
 * parsing pass has completed.
 */
public interface IHymappingBackgroundParsingListener {
	
	/**
	 * <p>
	 * Signals that the given resource has been changed and the background parsing is
	 * completed.
	 * </p>
	 * 
	 * @param resource the resource that has changed
	 */
	public void parsingCompleted(Resource resource);
}
