/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.emf.ecore.EObject;

public class HyconstraintsHoverTextProvider implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsHoverTextProvider {
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsDefaultHoverTextProvider defaultProvider = new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsDefaultHoverTextProvider();
	
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
