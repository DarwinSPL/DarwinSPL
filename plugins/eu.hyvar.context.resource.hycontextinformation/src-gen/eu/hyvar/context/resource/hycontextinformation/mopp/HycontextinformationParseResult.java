/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class HycontextinformationParseResult implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationParseResult {
	
	private EObject root;
	
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap locationMap;
	
	private Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>> commands = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>>();
	
	public HycontextinformationParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
