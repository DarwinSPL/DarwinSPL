/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;


public class HymanifestWhiteSpace extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestFormattingElement {
	
	private final int amount;
	
	public HymanifestWhiteSpace(int amount, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality) {
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
