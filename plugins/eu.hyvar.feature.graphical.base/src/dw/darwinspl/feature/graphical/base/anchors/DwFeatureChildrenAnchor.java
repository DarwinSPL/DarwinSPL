package dw.darwinspl.feature.graphical.base.anchors;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.figures.DwFeatureFigure;

public class DwFeatureChildrenAnchor extends DwFeatureModelPositionAnchor {
	
	public DwFeatureChildrenAnchor(IFigure owner, DwGraphicalFeatureModelViewer editor) {
		super(owner, editor);

	}
	
	@Override
	public Point getLocation(Point reference) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		DwFeatureFigure figure = ((DwFeatureFigure)getOwner());
		
		Rectangle parentBounds = figure.getBounds();
		Point location = new Point(parentBounds.getTopLeft().x+parentBounds.width() / 2, parentBounds.getBottom().y-theme.getLineWidth() / 2);
		
		getOwner().translateToAbsolute(location);
		
		return location;
	}	
}
