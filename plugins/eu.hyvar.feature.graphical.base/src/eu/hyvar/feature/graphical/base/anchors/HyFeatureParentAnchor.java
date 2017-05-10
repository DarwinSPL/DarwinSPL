package eu.hyvar.feature.graphical.base.anchors;

import org.eclipse.draw2d.IFigure;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class HyFeatureParentAnchor extends HyFeatureModelPositionAnchor  {
	public HyFeatureParentAnchor(IFigure owner, DwGraphicalFeatureModelViewer editor) {
		super(owner, editor);	
	}
}
