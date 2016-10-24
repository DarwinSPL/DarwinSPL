/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;


/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaEl
 * ementMapping interface.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class HyvalidityformulaElementMapping<ReferenceType> implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public HyvalidityformulaElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
