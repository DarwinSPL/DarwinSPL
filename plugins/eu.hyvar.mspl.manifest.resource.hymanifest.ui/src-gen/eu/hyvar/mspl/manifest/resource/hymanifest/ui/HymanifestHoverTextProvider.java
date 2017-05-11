/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import org.eclipse.emf.ecore.EObject;

public class HymanifestHoverTextProvider implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestHoverTextProvider {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestDefaultHoverTextProvider defaultProvider = new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestDefaultHoverTextProvider();
	
	public String getHoverText(EObject container, EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
