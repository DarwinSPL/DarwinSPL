/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.emf.ecore.EObject;

public class HyvalidityformulaHoverTextProvider implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaHoverTextProvider {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaDefaultHoverTextProvider defaultProvider = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaDefaultHoverTextProvider();
	
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
