/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class HydatavalueAbstractExpectedElement implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]>> followers = new LinkedHashSet<eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]>>();
	
	public HydatavalueAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement follower, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[] path) {
		followers.add(new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]>(follower, path));
	}
	
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
