/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.core.resources.IResource;

public class DwprofileUIMetaInformation extends de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation {
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileHoverTextProvider getHoverTextProvider() {
		return new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileHoverTextProvider();
	}
	
	public de.darwinspl.preferences.resource.dwprofile.ui.DwprofileImageProvider getImageProvider() {
		return de.darwinspl.preferences.resource.dwprofile.ui.DwprofileImageProvider.INSTANCE;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager createColorManager() {
		return new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextRes
	 * ource, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager)
	 * instead.
	 */
	public de.darwinspl.preferences.resource.dwprofile.ui.DwprofileTokenScanner createTokenScanner(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager colorManager) {
		return (de.darwinspl.preferences.resource.dwprofile.ui.DwprofileTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.ui.IDwprofileTokenScanner createTokenScanner(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager colorManager) {
		return new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileTokenScanner(resource, colorManager);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCodeCompletionHelper createCodeCompletionHelper() {
		return new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new de.darwinspl.preferences.resource.dwprofile.ui.debug.DwprofileLineBreakpointAdapter();
	}
	
}
