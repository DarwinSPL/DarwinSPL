/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class DwprofileBracketInformationProvider {
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileBracketPair> getBracketPairs() {
		Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileBracketPair> result = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileBracketPair>();
		result.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileBracketPair("[", "]", true, false));
		result.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileBracketPair("(", ")", true, false));
		result.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
