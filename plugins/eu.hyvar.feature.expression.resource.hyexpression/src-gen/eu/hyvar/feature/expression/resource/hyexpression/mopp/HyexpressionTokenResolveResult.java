/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class HyexpressionTokenResolveResult implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public HyexpressionTokenResolveResult() {
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
