/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class HyconstraintsParseResult implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsParseResult {
	
	private EObject root;
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap;
	
	private Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>> commands = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>>();
	
	public HyconstraintsParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
