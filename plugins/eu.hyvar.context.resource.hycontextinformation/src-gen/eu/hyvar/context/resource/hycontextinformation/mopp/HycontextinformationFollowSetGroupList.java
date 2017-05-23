/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HycontextinformationFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup>();
	
	public HycontextinformationFollowSetGroupList(List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal expectedTerminal) {
		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup group;
		
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
	
	public List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup addNewGroup() {
		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup group = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
