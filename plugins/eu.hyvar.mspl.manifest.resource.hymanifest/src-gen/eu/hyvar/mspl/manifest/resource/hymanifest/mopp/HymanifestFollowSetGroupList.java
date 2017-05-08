/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HymanifestFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup>();
	
	public HymanifestFollowSetGroupList(List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal expectedTerminal) {
		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup group;
		
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
	
	public List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup addNewGroup() {
		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup group = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
