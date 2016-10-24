/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IHyexpressionResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource getResource();
	
}
