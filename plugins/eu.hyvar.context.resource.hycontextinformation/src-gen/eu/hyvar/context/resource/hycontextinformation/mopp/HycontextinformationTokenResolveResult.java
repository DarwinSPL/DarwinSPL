/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class HycontextinformationTokenResolveResult implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public HycontextinformationTokenResolveResult() {
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
