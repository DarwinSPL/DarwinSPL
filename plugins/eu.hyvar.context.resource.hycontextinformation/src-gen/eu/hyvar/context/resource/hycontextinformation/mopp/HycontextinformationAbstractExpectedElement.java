/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class HycontextinformationAbstractExpectedElement implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]>> followers = new LinkedHashSet<eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]>>();
	
	public HycontextinformationAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement follower, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[] path) {
		followers.add(new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]>(follower, path));
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
