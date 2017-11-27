/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <p>
 * A basic interface to convert parsed tokens to the attribute type in the meta
 * model. All generated TokenResolvers per default delegate requests to an
 * instance of DwprofileDefaultTokenResolver which performs a standard conversion
 * based on the EMF type conversion. This includes conversion of registered
 * EDataTypes.
 * </p>
 * 
 * @see
 * de.darwinspl.preferences.resource.dwprofile.analysis.DwprofileDefaultTokenResolv
 * er
 */
public interface IDwprofileTokenResolver extends de.darwinspl.preferences.resource.dwprofile.IDwprofileConfigurable {
	
	/**
	 * <p>
	 * Converts a token into an Object (the value of the attribute).
	 * </p>
	 * 
	 * @param lexem the text of the parsed token
	 * @param feature the corresponding feature in the meta model
	 * @param result the result of resolving the lexem, can be used to add processing
	 * errors
	 */
	public void resolve(String lexem, EStructuralFeature feature, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result);
	
	/**
	 * <p>
	 * Converts an Object (the value of an attribute) to a string which can be
	 * printed. This is the inverse of resolving a token with a call to resolve().
	 * </p>
	 * 
	 * @param value the Object to be printed as String
	 * @param feature the corresponding feature (EAttribute)
	 * @param container the container of the object
	 * 
	 * @return the String representation or null if a problem occurred
	 */
	public String deResolve(Object value, EStructuralFeature feature, EObject container);
	
}
