/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HycontextinformationProposalPostProcessor {
	
	public List<eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationCompletionProposal> process(List<eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
