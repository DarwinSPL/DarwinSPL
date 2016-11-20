package eu.hyvar.feature.graphical.base.anchors;

import org.eclipse.draw2d.IFigure;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;

public class HyFeatureParentAnchor extends HyFeatureModelPositionAnchor  {
	public HyFeatureParentAnchor(IFigure owner, HyGraphicalFeatureModelViewer editor) {
		super(owner, editor);	
	}
}
