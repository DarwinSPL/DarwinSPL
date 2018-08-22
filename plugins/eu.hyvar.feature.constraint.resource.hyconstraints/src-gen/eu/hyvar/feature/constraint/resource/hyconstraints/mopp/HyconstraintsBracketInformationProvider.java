/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HyconstraintsBracketInformationProvider {
	
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsBracketPair> getBracketPairs() {
		Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsBracketPair> result = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsBracketPair>();
		result.add(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsBracketPair("[", "]", true, false));
		result.add(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsBracketPair("(", ")", true, false));
		result.add(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsBracketPair("{", "}", true, true));
		result.add(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
