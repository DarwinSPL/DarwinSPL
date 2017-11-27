/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * de.darwinspl.preferences.resource.dwprofile.IDwprofileURIMapping interface that
 * can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * de.darwinspl.preferences.resource.dwprofile.IDwprofileURIMapping.
 */
public class DwprofileURIMapping<ReferenceType> implements de.darwinspl.preferences.resource.dwprofile.IDwprofileURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public DwprofileURIMapping(String identifier, URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
