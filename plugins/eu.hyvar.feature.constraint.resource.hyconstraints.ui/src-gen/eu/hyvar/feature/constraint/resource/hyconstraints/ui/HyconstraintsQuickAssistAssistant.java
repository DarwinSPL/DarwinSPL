/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.widgets.Shell;

public class HyconstraintsQuickAssistAssistant extends QuickAssistAssistant implements IQuickAssistAssistant {
	
	public HyconstraintsQuickAssistAssistant(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsResourceProvider resourceProvider, eu.hyvar.feature.constraint.resource.hyconstraints.ui.IHyconstraintsAnnotationModelProvider annotationModelProvider) {
		setQuickAssistProcessor(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsQuickAssistProcessor(resourceProvider, annotationModelProvider));
		setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		});
	}
	
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(Annotation annotation) {
		return true;
	}
	
}
