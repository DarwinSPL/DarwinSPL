/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class HymappingParseResult implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingParseResult {
	
	private EObject root;
	
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap;
	
	private Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>> commands = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>>();
	
	public HymappingParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
