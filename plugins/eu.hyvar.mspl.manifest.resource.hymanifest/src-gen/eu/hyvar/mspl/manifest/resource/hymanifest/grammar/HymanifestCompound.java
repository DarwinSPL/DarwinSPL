/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;


public class HymanifestCompound extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement {
	
	public HymanifestCompound(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice choice, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality) {
		super(cardinality, new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
