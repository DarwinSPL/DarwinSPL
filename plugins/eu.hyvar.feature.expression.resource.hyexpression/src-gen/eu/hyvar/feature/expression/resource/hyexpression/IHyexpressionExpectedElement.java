/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;

import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IHyexpressionExpectedElement {
	
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
	public eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement getSyntaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement follower, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionPair<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[]>> getFollowers();
	
}
