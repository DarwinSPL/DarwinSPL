/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;

import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IHycontextinformationExpectedElement {
	
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
	public eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement follower, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public Collection<eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]>> getFollowers();
	
}
