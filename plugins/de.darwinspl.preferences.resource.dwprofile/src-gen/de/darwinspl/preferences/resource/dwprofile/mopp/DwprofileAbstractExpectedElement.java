/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class DwprofileAbstractExpectedElement implements de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]>> followers = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]>>();
	
	public DwprofileAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement follower, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] path) {
		followers.add(new de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]>(follower, path));
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
