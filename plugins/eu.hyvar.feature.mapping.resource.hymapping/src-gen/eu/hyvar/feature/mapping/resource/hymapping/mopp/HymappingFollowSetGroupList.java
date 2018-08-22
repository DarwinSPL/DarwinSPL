/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HymappingFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup>();
	
	public HymappingFollowSetGroupList(List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal expectedTerminal) {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup group;
		
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
	
	public List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup addNewGroup() {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup group = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
