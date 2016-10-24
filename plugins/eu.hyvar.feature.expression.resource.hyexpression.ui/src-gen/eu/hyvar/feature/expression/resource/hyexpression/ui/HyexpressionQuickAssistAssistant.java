/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.widgets.Shell;

public class HyexpressionQuickAssistAssistant extends QuickAssistAssistant implements IQuickAssistAssistant {
	
	public HyexpressionQuickAssistAssistant(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionResourceProvider resourceProvider, eu.hyvar.feature.expression.resource.hyexpression.ui.IHyexpressionAnnotationModelProvider annotationModelProvider) {
		setQuickAssistProcessor(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionQuickAssistProcessor(resourceProvider, annotationModelProvider));
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
