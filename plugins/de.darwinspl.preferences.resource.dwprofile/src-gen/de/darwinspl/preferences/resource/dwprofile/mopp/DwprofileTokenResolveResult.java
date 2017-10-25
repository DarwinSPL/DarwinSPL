/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class DwprofileTokenResolveResult implements de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public DwprofileTokenResolveResult() {
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
