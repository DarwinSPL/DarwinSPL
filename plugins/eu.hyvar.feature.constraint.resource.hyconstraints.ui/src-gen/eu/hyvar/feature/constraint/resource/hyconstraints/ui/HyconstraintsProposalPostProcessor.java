/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HyconstraintsProposalPostProcessor {
	
	public List<eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsCompletionProposal> process(List<eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
