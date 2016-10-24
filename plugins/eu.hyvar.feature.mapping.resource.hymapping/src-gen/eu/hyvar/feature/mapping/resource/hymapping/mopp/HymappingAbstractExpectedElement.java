/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class HymappingAbstractExpectedElement implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<eu.hyvar.feature.mapping.resource.hymapping.util.HymappingPair<eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[]>> followers = new LinkedHashSet<eu.hyvar.feature.mapping.resource.hymapping.util.HymappingPair<eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[]>>();
	
	public HymappingAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement follower, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[] path) {
		followers.add(new eu.hyvar.feature.mapping.resource.hymapping.util.HymappingPair<eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[]>(follower, path));
	}
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.util.HymappingPair<eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
