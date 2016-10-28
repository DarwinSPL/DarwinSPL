/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

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

public class HydatavalueCompletionProcessor implements IContentAssistProcessor {
	
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueResourceProvider resourceProvider;
	
	public HydatavalueCompletionProcessor(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		return computeCompletionProposals(textResource, content, offset);
	}
	
	public ICompletionProposal[] computeCompletionProposals(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource textResource, String text, int offset) {
		eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCodeCompletionHelper helper = new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCodeCompletionHelper();
		eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, text, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueProposalPostProcessor proposalPostProcessor = new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueProposalPostProcessor();
		List<eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal> finalProposalList = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal>();
		for (eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCompletionProposal proposal : finalProposalList) {
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
		IPreferenceStore preferenceStore = eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueUIPlugin.getDefault().getPreferenceStore();
		boolean enabled = preferenceStore.getBoolean(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavaluePreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED);
		String triggerString = preferenceStore.getString(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavaluePreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS);
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
