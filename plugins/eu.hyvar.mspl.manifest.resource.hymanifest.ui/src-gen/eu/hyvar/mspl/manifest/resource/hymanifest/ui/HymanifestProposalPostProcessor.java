/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HymanifestProposalPostProcessor {
	
	public List<eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal> process(List<eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
