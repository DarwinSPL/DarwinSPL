/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import org.eclipse.emf.ecore.EObject;

public class HydatavalueHoverTextProvider implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueHoverTextProvider {
	
	private eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueDefaultHoverTextProvider defaultProvider = new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueDefaultHoverTextProvider();
	
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
