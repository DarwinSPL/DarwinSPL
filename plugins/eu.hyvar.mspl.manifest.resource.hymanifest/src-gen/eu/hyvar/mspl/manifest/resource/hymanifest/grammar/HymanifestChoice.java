/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;


public class HymanifestChoice extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement {
	
	public HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestStringUtil.explode(getChildren(), "|");
	}
	
}
