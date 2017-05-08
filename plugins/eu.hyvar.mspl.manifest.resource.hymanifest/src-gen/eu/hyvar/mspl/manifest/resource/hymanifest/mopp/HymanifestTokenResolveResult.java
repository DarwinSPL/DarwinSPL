/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class HymanifestTokenResolveResult implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public HymanifestTokenResolveResult() {
		super();
		clear();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getResolvedToken() {
		return resolvedToken;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
	
}
