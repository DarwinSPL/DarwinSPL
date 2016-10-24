/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HyvalidityformulaProposalPostProcessor {
	
	public List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal> process(List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
