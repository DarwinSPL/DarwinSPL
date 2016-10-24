/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;


/**
 * A single pair of brackets.
 */
public class HyexpressionBracketPair implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionBracketPair {
	
	private String openingBracket;
	
	private String closingBracket;
	
	private boolean closingEnabledInside;
	
	private boolean closeAfterEnter;
	
	public String getOpeningBracket() {
		return openingBracket;
	}
	
	public String getClosingBracket() {
		return closingBracket;
	}
	
	public boolean isClosingEnabledInside() {
		return closingEnabledInside;
	}
	
	public boolean isCloseAfterEnter() {
		return closeAfterEnter;
	}
	
	public void setOpeningBracket(String openingBracket) {
		this.openingBracket = openingBracket;
	}
	
	public void setClosingBracket(String closingBracket) {
		this.closingBracket = closingBracket;
	}
	
	public void setClosingEnabledInside(boolean closingEnabledInside) {
		this.closingEnabledInside = closingEnabledInside;
	}
	
	public void setCloseAfterEnter(boolean closeAfterEnter) {
		this.closeAfterEnter = closeAfterEnter;
	}
	
	public HyexpressionBracketPair(String openingBracket, String closingBracket, boolean closingEnabledInside, boolean closeAfterEnter) {
		super();
		this.openingBracket = openingBracket;
		this.closingBracket = closingBracket;
		this.closingEnabledInside = closingEnabledInside;
		this.closeAfterEnter = closeAfterEnter;
	}
	
}
