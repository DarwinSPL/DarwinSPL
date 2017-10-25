/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class DwprofileProposalPostProcessor {
	
	public List<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> process(List<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
