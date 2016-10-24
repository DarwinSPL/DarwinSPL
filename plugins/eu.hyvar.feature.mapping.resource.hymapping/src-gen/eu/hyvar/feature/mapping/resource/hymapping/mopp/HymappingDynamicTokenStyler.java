/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;


public class HymappingDynamicTokenStyler {
	
	/**
	 * The offset in the text where the lexer started.
	 */
	private int offset;
	
	/**
	 * <p>
	 * This method is called to dynamically style tokens.
	 * </p>
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle getDynamicTokenStyle(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken token, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
