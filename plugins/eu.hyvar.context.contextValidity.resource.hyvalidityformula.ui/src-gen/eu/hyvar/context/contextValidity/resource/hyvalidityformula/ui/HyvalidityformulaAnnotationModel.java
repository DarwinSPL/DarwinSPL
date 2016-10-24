/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class HyvalidityformulaAnnotationModel extends ResourceMarkerAnnotationModel {
	
	public HyvalidityformulaAnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaMarkerAnnotation(marker);
	}
	
}
