/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HyconstraintsFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup>();
	
	public HyconstraintsFollowSetGroupList(List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedTerminal) {
		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup group;
		
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
	
	public List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup addNewGroup() {
		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup group = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
