/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class HymanifestRule extends eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement {
	
	private final EClass metaclass;
	
	public HymanifestRule(EClass metaclass, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice choice, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality cardinality) {
		super(cardinality, new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getDefinition() {
		return (eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice) getChildren()[0];
	}
	
	@Deprecated
	public String toString() {
		return metaclass == null ? "null" : metaclass.getName() + " ::= " + getDefinition().toString();
	}
	
}

