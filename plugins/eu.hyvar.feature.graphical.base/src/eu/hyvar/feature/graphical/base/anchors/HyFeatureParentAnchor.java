package eu.hyvar.feature.graphical.base.anchors;

import org.eclipse.draw2d.IFigure;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureParentAnchor extends HyFeatureModelPositionAnchor  {
	public HyFeatureParentAnchor(IFigure owner, GraphicalFeatureModelEditor editor) {
		super(owner, editor);	
	}
}
