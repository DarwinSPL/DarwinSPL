/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.core.resources.IResource;

public class HymappingUIMetaInformation extends eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMetaInformation {
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHoverTextProvider();
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingImageProvider getImageProvider() {
		return eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingImageProvider.INSTANCE;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager createColorManager() {
		return new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextRes
	 * ource, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager)
	 * instead.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingTokenScanner createTokenScanner(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager colorManager) {
		return (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.ui.IHymappingTokenScanner createTokenScanner(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager colorManager) {
		return new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.feature.mapping.resource.hymapping.ui.debug.HymappingLineBreakpointAdapter();
	}
	
}
