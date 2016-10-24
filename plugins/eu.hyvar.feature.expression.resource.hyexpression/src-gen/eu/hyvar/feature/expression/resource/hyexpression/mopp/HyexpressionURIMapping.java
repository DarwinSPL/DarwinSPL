/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionURIMapping
 * interface that can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionURIMapping.
 */
public class HyexpressionURIMapping<ReferenceType> implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public HyexpressionURIMapping(String identifier, URI newIdentifier, String warning) {
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
