/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class HyvalidityformulaTokenResolveResult implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public HyvalidityformulaTokenResolveResult() {
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
