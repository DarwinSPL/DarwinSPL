/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class HyvalidityformulaFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup> followSetGroups = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup>();
	
	public HyvalidityformulaFollowSetGroupList(List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> expectedTerminals) {
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedTerminal) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup group;
		
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
	
	public List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup addNewGroup() {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup group = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
