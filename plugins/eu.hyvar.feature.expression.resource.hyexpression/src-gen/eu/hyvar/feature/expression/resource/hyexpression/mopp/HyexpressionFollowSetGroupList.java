/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HyexpressionFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup>();
	
	public HyexpressionFollowSetGroupList(List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedTerminal) {
		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup group;
		
		int followSetID = expectedTerminal.getFollowSetID();
		if (followSetID == lastFollowSetID) {
			if (followSetGroups.isEmpty()) {
				group = addNewGroup();
			} else {
				group = followSetGroups.get(followSetGroups.size() - 1);
			}
		} else {
			group = addNewGroup();
			lastFollowSetID = followSetID;
		}
		
		group.add(expectedTerminal);
	}
	
	public List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup addNewGroup() {
		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup group = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
