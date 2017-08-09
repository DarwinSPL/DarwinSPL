/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

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

public class HymanifestCompletionProcessor implements IContentAssistProcessor {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestResourceProvider resourceProvider;
	
	public HymanifestCompletionProcessor(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		return computeCompletionProposals(textResource, content, offset);
	}
	
	public ICompletionProposal[] computeCompletionProposals(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource textResource, String text, int offset) {
		eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCodeCompletionHelper helper = new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCodeCompletionHelper();
		eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, text, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestProposalPostProcessor proposalPostProcessor = new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestProposalPostProcessor();
		List<eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal> finalProposalList = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal>();
		for (eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCompletionProposal proposal : finalProposalList) {
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
		IPreferenceStore preferenceStore = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin.getDefault().getPreferenceStore();
		boolean enabled = preferenceStore.getBoolean(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED);
		String triggerString = preferenceStore.getString(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS);
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
