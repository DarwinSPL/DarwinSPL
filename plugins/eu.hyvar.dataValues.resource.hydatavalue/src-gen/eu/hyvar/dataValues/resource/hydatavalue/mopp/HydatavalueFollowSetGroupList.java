/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HydatavalueFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup>();
	
	public HydatavalueFollowSetGroupList(List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedTerminal) {
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup group;
		
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
	
	public List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup addNewGroup() {
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup group = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
