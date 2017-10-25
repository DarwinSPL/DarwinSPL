/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class DwprofileParseResult implements de.darwinspl.preferences.resource.dwprofile.IDwprofileParseResult {
	
	private EObject root;
	
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap locationMap;
	
	private Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>> commands = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>>();
	
	public DwprofileParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
