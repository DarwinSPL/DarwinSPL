/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsURIMapping
 * interface that can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsURIMapping.
 */
public class HyconstraintsURIMapping<ReferenceType> implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public HyconstraintsURIMapping(String identifier, URI newIdentifier, String warning) {
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
