/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HyvalidityformulaBracketInformationProvider {
	
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBracketPair> getBracketPairs() {
		Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBracketPair> result = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBracketPair>();
		result.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaBracketPair("[", "]", true, false));
		result.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaBracketPair("(", ")", true, false));
		result.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
