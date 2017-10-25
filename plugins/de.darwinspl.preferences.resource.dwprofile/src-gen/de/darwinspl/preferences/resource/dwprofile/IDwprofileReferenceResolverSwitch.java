/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A IDwprofileReferenceResolverSwitch holds references to multiple other
 * reference resolvers and delegates requests to the appropriate resolver.
 */
public interface IDwprofileReferenceResolverSwitch extends de.darwinspl.preferences.resource.dwprofile.IDwprofileConfigurable {
	
	/**
	 * <p>
	 * Attempts to resolve a reference string fuzzy (returning objects that do not
	 * match exactly). This is need during code completion.
	 * </p>
	 * 
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param result an object to store the result of the resolve operation.
	 */
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<EObject> result);
}
