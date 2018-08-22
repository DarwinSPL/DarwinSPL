/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IDwprofileExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getSyntaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement follower, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public Collection<de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]>> getFollowers();
	
}
