/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HydatavalueBracketInformationProvider {
	
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueBracketPair> getBracketPairs() {
		Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueBracketPair> result = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueBracketPair>();
		result.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueBracketPair("[", "]", true, false));
		result.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
