/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;


public class DwprofileWhiteSpace extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileFormattingElement {
	
	private final int amount;
	
	public DwprofileWhiteSpace(int amount, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
