/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class HydatavalueProposalPostProcessor {
	
	public List<eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal> process(List<eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
