/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HymappingProposalPostProcessor {
	
	public List<eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingCompletionProposal> process(List<eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
