/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class HymanifestBracketInformationProvider {
	
	public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestBracketPair> getBracketPairs() {
		Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestBracketPair> result = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestBracketPair>();
		result.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestBracketPair("(", ")", true, false));
		result.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestBracketPair("[", "]", true, false));
		result.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestBracketPair("{", "}", true, true));
		result.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestBracketPair("\"", "\"", false, false));
		result.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestBracketPair("<", ">", false, false));
		return result;
	}
	
}
