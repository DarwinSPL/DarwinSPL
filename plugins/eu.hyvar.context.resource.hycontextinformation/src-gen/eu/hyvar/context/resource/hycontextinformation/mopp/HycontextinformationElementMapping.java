/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;


/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationElementMappi
 * ng interface.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class HycontextinformationElementMapping<ReferenceType> implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public HycontextinformationElementMapping(String identifier, ReferenceType target, String warning) {
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
