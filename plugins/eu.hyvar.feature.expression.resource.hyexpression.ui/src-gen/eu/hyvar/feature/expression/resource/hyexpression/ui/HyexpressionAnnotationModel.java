/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class HyexpressionAnnotationModel extends ResourceMarkerAnnotationModel {
	
	public HyexpressionAnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionMarkerAnnotation(marker);
	}
	
}
