/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class HycontextinformationAnnotationModel extends ResourceMarkerAnnotationModel {
	
	public HycontextinformationAnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationMarkerAnnotation(marker);
	}
	
}
