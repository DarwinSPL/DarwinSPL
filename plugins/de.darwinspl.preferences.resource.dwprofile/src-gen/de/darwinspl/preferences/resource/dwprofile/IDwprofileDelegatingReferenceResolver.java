/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * </p>
 * 
 * @see de.darwinspl.preferences.resource.dwprofile.IDwprofileOptions
 */
public interface IDwprofileDelegatingReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> extends de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
