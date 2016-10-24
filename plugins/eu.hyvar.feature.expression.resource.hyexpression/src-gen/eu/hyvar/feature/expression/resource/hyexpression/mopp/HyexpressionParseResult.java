/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class HyexpressionParseResult implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionParseResult {
	
	private EObject root;
	
	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap;
	
	private Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>> commands = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>>();
	
	public HyexpressionParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
