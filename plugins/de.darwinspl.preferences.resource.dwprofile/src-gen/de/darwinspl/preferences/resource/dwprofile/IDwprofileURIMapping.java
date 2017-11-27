/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * Implementors of this interface map identifiers to URIs. This is sometimes
 * necessary when resolving references depends on the resolution of others.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping.
 */
public interface IDwprofileURIMapping<ReferenceType> extends de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<ReferenceType> {
	
	/**
	 * Returns an alternative proxy URI that should follow EMF's default naming scheme
	 * such that it can be resolved by the default resolution mechanism that will be
	 * called on this URI (see <code>Resource.getEObject()</code>).
	 */
	public URI getTargetIdentifier();
	
}
