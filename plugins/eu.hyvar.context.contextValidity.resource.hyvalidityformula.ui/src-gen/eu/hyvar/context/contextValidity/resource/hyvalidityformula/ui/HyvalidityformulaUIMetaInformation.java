/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.core.resources.IResource;

public class HyvalidityformulaUIMetaInformation extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation {
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaHoverTextProvider();
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaImageProvider getImageProvider() {
		return eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaImageProvider.INSTANCE;
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaColorManager createColorManager() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.context.contextValidity.resource.hyvalidityformula.I
	 * HyvalidityformulaTextResource,
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.Hyvalidityformula
	 * ColorManager) instead.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaTokenScanner createTokenScanner(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaColorManager colorManager) {
		return (eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.IHyvalidityformulaTokenScanner createTokenScanner(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaColorManager colorManager) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.debug.HyvalidityformulaLineBreakpointAdapter();
	}
	
}
