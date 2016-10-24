/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;

import org.eclipse.emf.ecore.EObject;

public interface IHyexpressionHoverTextProvider {
	
	/**
	 * Returns the hover text that is shown when the mouse pointer rests over the
	 * given object. The hover text can contain HTML.
	 */
	public String getHoverText(EObject object);
	
	/**
	 * Returns the hover text that is shown when the mouse pointer rests over a
	 * reference to the given object. The hover text can contain HTML.
	 */
	public String getHoverText(EObject container, EObject referencedObject);
	
}
