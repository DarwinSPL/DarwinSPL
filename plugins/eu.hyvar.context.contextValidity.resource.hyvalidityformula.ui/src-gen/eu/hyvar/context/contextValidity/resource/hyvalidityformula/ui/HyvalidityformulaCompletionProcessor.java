/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

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

public class HyvalidityformulaCompletionProcessor implements IContentAssistProcessor {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaResourceProvider resourceProvider;
	
	public HyvalidityformulaCompletionProcessor(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		return computeCompletionProposals(textResource, content, offset);
	}
	
	public ICompletionProposal[] computeCompletionProposals(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource textResource, String text, int offset) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCodeCompletionHelper helper = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCodeCompletionHelper();
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, text, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaProposalPostProcessor proposalPostProcessor = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaProposalPostProcessor();
		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal> finalProposalList = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal>();
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCompletionProposal proposal : finalProposalList) {
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
		IPreferenceStore preferenceStore = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin.getDefault().getPreferenceStore();
		boolean enabled = preferenceStore.getBoolean(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED);
		String triggerString = preferenceStore.getString(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS);
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
