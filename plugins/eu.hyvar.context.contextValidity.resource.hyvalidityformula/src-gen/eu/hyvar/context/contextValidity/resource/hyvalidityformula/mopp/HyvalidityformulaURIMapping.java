/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaUR
 * IMapping interface that can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaUR
 * IMapping.
 */
public class HyvalidityformulaURIMapping<ReferenceType> implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public HyvalidityformulaURIMapping(String identifier, URI newIdentifier, String warning) {
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
