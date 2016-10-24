/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.core.resources.IResource;

public class HycontextinformationUIMetaInformation extends eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation {
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationHoverTextProvider();
	}
	
	public eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationImageProvider getImageProvider() {
		return eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationImageProvider.INSTANCE;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManager createColorManager() {
		return new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.context.resource.hycontextinformation.IHycontextinfo
	 * rmationTextResource,
	 * eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManag
	 * er) instead.
	 */
	public eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationTokenScanner createTokenScanner(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManager colorManager) {
		return (eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.ui.IHycontextinformationTokenScanner createTokenScanner(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManager colorManager) {
		return new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.context.resource.hycontextinformation.ui.debug.HycontextinformationLineBreakpointAdapter();
	}
	
}
