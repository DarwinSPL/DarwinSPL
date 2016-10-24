/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class HyvalidityformulaParseResult implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaParseResult {
	
	private EObject root;
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap;
	
	private Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>> commands = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>>();
	
	public HyvalidityformulaParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
