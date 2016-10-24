/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.emf.ecore.EObject;

public class HyexpressionHoverTextProvider implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionHoverTextProvider {
	
	private eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionDefaultHoverTextProvider defaultProvider = new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionDefaultHoverTextProvider();
	
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
