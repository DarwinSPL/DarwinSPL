package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyRootFeatureFigure extends HyFeatureFigure{

	public HyRootFeatureFigure(DwGraphicalFeatureModelViewer editor, HyFeatureWrapped feature) {
		super(editor, feature);
	}
	
	public Rectangle calculateVariationTypeCircleBounds() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Rectangle bounds = getBounds();

		int x = bounds.x + (bounds.width - theme.getFeatureVariationTypeExtent()) / 2;
		int y = bounds.y;

		return new Rectangle(x, y, 0, 0);
	}
}