/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class HydatavalueTokenResolveResult implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public HydatavalueTokenResolveResult() {
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
