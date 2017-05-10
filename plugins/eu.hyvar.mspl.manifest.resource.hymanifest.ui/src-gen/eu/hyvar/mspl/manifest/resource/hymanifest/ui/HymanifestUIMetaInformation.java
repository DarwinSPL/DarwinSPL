/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import org.eclipse.core.resources.IResource;

public class HymanifestUIMetaInformation extends eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation {
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestHoverTextProvider();
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestImageProvider getImageProvider() {
		return eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestImageProvider.INSTANCE;
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager createColorManager() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextRes
	 * ource, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager)
	 * instead.
	 */
	public eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestTokenScanner createTokenScanner(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager colorManager) {
		return (eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.ui.IHymanifestTokenScanner createTokenScanner(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager colorManager) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.ui.debug.HymanifestLineBreakpointAdapter();
	}
	
}
