/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HycontextinformationBracketInformationProvider {
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationBracketPair> getBracketPairs() {
		Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationBracketPair> result = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationBracketPair>();
		result.add(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationBracketPair("[", "]", true, false));
		return result;
	}
	
}
