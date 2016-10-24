/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;


/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueElementMapping interface.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class HydatavalueElementMapping<ReferenceType> implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public HydatavalueElementMapping(String identifier, ReferenceType target, String warning) {
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
