/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.emf.ecore.EObject;

public class HymappingHoverTextProvider implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingHoverTextProvider {
	
	private eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDefaultHoverTextProvider defaultProvider = new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDefaultHoverTextProvider();
	
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
