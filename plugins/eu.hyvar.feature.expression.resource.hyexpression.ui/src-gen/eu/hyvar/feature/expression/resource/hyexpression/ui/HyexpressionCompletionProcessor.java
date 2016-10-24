/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

public class HyexpressionCompletionProcessor implements IContentAssistProcessor {
	
	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionResourceProvider resourceProvider;
	
	public HyexpressionCompletionProcessor(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		return computeCompletionProposals(textResource, content, offset);
	}
	
	public ICompletionProposal[] computeCompletionProposals(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource textResource, String text, int offset) {
		eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCodeCompletionHelper helper = new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCodeCompletionHelper();
		eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, text, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionProposalPostProcessor proposalPostProcessor = new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionProposalPostProcessor();
		List<eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal> finalProposalList = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal>();
		for (eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = (proposal.getDisplayString()==null)?proposalString:proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			Image image = proposal.getImage();
			IContextInformation info;
			info = new ContextInformation(image, displayString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			result[i++] = new CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		IPreferenceStore preferenceStore = eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionUIPlugin.getDefault().getPreferenceStore();
		boolean enabled = preferenceStore.getBoolean(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED);
		String triggerString = preferenceStore.getString(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS);
		if(enabled && triggerString != null && triggerString.length() > 0){
			char[] triggers = new char[triggerString.length()];
			for (int i = 0; i < triggerString.length(); i++) {
				triggers[i] = triggerString.charAt(i);
			}
			return triggers;
		}
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
