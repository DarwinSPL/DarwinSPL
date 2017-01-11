/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.jface.text.source.IAnnotationModel;

/**
 * A provider for annotation models.
 */
public interface IHycontextinformationAnnotationModelProvider {
	
	/**
	 * Returns the annotation model.
	 */
	public IAnnotationModel getAnnotationModel();
	
}
