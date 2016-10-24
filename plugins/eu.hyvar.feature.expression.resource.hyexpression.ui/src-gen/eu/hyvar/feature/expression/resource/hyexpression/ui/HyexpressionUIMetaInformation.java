/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.core.resources.IResource;

public class HyexpressionUIMetaInformation extends eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionMetaInformation {
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionHoverTextProvider();
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionImageProvider getImageProvider() {
		return eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionImageProvider.INSTANCE;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionColorManager createColorManager() {
		return new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressi
	 * onTextResource,
	 * eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionColorManager)
	 * instead.
	 */
	public eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionTokenScanner createTokenScanner(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionColorManager colorManager) {
		return (eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.ui.IHyexpressionTokenScanner createTokenScanner(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource, eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionColorManager colorManager) {
		return new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.feature.expression.resource.hyexpression.ui.debug.HyexpressionLineBreakpointAdapter();
	}
	
}
