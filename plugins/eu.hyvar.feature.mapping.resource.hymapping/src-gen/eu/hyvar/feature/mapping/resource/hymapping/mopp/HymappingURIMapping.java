/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.feature.mapping.resource.hymapping.IHymappingURIMapping interface that
 * can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.feature.mapping.resource.hymapping.IHymappingURIMapping.
 */
public class HymappingURIMapping<ReferenceType> implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public HymappingURIMapping(String identifier, URI newIdentifier, String warning) {
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
