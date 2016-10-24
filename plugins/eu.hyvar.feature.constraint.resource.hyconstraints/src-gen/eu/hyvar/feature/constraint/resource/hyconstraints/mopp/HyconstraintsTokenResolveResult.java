/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class HyconstraintsTokenResolveResult implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public HyconstraintsTokenResolveResult() {
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
