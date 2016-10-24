/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HymappingBracketInformationProvider {
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingBracketPair> getBracketPairs() {
		Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingBracketPair> result = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingBracketPair>();
		result.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingBracketPair("[", "]", true, false));
		result.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingBracketPair("(", ")", true, false));
		result.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingBracketPair("<", ">", false, false));
		result.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
