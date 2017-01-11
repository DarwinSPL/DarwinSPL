/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationURIMapping
 * interface that can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationURIMapping.
 */
public class HycontextinformationURIMapping<ReferenceType> implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public HycontextinformationURIMapping(String identifier, URI newIdentifier, String warning) {
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
