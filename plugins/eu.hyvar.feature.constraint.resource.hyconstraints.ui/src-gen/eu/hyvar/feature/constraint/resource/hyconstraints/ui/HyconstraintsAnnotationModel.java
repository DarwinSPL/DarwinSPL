/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class HyconstraintsAnnotationModel extends ResourceMarkerAnnotationModel {
	
	public HyconstraintsAnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsMarkerAnnotation(marker);
	}
	
}
