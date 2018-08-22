/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HyexpressionBracketInformationProvider {
	
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionBracketPair> getBracketPairs() {
		Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionBracketPair> result = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionBracketPair>();
		result.add(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionBracketPair("(", ")", true, false));
		result.add(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionBracketPair("{", "}", true, true));
		result.add(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionBracketPair("[", "]", true, false));
		result.add(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
