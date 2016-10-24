/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.emf.ecore.EObject;

public class HycontextinformationHoverTextProvider implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationHoverTextProvider {
	
	private eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationDefaultHoverTextProvider defaultProvider = new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationDefaultHoverTextProvider();
	
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
