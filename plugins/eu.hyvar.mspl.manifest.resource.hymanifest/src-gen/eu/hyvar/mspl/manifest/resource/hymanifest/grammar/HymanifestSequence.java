/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;


public class HymanifestSequence extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement {
	
	public HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestStringUtil.explode(getChildren(), " ");
	}
	
}
