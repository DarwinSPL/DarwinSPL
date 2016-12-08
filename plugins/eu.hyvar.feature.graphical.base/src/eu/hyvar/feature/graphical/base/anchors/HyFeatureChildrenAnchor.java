package eu.hyvar.feature.graphical.base.anchors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;

public class HyFeatureChildrenAnchor extends HyFeatureModelPositionAnchor {
	
	public HyFeatureChildrenAnchor(IFigure owner, HyGraphicalFeatureModelViewer editor) {
		super(owner, editor);

	}
	
	@Override
	public Point getLocation(Point reference) {
		HyFeatureFigure figure = ((HyFeatureFigure)getOwner());
		
		Rectangle parentBounds = figure.getBounds();
		Point location = new Point(parentBounds.getTopLeft().x+parentBounds.width() / 2, parentBounds.getBottom().y);
		
		getOwner().translateToAbsolute(location);
		
		return location;
	}	
}
