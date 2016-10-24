/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class HymappingQuickAssistProcessor implements IQuickAssistProcessor {
	
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingResourceProvider resourceProvider;
	private eu.hyvar.feature.mapping.resource.hymapping.ui.IHymappingAnnotationModelProvider annotationModelProvider;
	
	public HymappingQuickAssistProcessor(eu.hyvar.feature.mapping.resource.hymapping.IHymappingResourceProvider resourceProvider, eu.hyvar.feature.mapping.resource.hymapping.ui.IHymappingAnnotationModelProvider annotationModelProvider) {
		super();
		this.resourceProvider = resourceProvider;
		this.annotationModelProvider = annotationModelProvider;
	}
	
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(Annotation annotation) {
		Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> quickFixes = getQuickFixes(annotation);
		return quickFixes.size() > 0;
	}
	
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
		ISourceViewer sourceViewer = invocationContext.getSourceViewer();
		int offset = -1;
		int length = 0;
		if (invocationContext instanceof TextInvocationContext) {
			TextInvocationContext textContext = (TextInvocationContext) invocationContext;
			offset = textContext.getOffset();
			length = textContext.getLength();
		}
		List<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> quickFixes = getQuickFixes(sourceViewer, offset, length);
		ICompletionProposal[] proposals = new ICompletionProposal[quickFixes.size()];
		for (int i = 0; i < proposals.length; i++) {
			proposals[i] = createCompletionProposal(sourceViewer, quickFixes.get(i));
		}
		return proposals;
	}
	
	private ICompletionProposal createCompletionProposal(final ISourceViewer sourceViewer, final eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix quickFix) {
		return new ICompletionProposal() {
			
			public Point getSelection(IDocument document) {
				return null;
			}
			
			public Image getImage() {
				return new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIMetaInformation().getImageProvider().getImage(quickFix.getImageKey());
			}
			
			public String getDisplayString() {
				return quickFix.getDisplayString();
			}
			
			public IContextInformation getContextInformation() {
				return null;
			}
			
			public String getAdditionalProposalInfo() {
				return null;
			}
			
			public void apply(IDocument document) {
				String currentContent = sourceViewer.getDocument().get();
				String newContent = quickFix.apply(currentContent);
				if (newContent != null) {
					sourceViewer.getDocument().set(newContent);
				}
			}
		};
	}
	
	private List<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> getQuickFixes(ISourceViewer sourceViewer, int offset, int length) {
		List<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> foundFixes = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix>();
		IAnnotationModel model = annotationModelProvider.getAnnotationModel();
		
		if (model == null) {
			return foundFixes;
		}
		
		Iterator<?> iter = model.getAnnotationIterator();
		while (iter.hasNext()) {
			Annotation annotation = (Annotation) iter.next();
			Position position = model.getPosition(annotation);
			if (offset >= 0) {
				if (!position.overlapsWith(offset, length)) {
					continue;
				}
			}
			Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> quickFixes = getQuickFixes(annotation);
			if (quickFixes != null) {
				foundFixes.addAll(quickFixes);
			}
		}
		return foundFixes;
	}
	
	private Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> getQuickFixes(Annotation annotation) {
		
		Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> foundQuickFixes = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix>();
		if (annotation.isMarkedDeleted()) {
			return foundQuickFixes;
		}
		
		if (annotation instanceof eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingMarkerAnnotation) {
			eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingMarkerAnnotation markerAnnotation = (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingMarkerAnnotation) annotation;
			IMarker marker = markerAnnotation.getMarker();
			foundQuickFixes.addAll(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingMarkerResolutionGenerator().getQuickFixes(resourceProvider.getResource(), marker));
		}
		return foundQuickFixes;
	}
	
	public String getErrorMessage() {
		return null;
	}
	
}
