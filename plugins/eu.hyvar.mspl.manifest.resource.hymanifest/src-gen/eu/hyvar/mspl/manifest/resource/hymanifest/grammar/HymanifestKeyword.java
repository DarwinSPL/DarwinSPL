/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class HymanifestKeyword extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement {
	
	private final String value;
	
	public HymanifestKeyword(String value, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
