/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class DwprofileFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup> followSetGroups = new ArrayList<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup>();
	
	public DwprofileFollowSetGroupList(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedTerminals) {
		for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal) {
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup group;
		
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
	
	public List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup addNewGroup() {
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup group = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
