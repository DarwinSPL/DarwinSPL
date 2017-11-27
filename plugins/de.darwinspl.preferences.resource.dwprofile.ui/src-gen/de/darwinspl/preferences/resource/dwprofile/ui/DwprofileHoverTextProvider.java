/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.emf.ecore.EObject;

public class DwprofileHoverTextProvider implements de.darwinspl.preferences.resource.dwprofile.IDwprofileHoverTextProvider {
	
	private de.darwinspl.preferences.resource.dwprofile.ui.DwprofileDefaultHoverTextProvider defaultProvider = new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileDefaultHoverTextProvider();
	
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
