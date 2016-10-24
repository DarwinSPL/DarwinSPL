/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HyexpressionProposalPostProcessor {
	
	public List<eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal> process(List<eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
