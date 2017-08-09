/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;


public class HymanifestLineBreak extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestFormattingElement {
	
	private final int tabs;
	
	public HymanifestLineBreak(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
