package eu.hyvar.feature.graphical.base.anchors;


import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;

public class HyFeatureChildrenAnchor extends HyFeatureModelPositionAnchor {
	
	public HyFeatureChildrenAnchor(IFigure owner, GraphicalFeatureModelEditor editor) {
		super(owner, editor);

	}
	
	@Override
	public Point getLocation(Point reference) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();	
		Date date = ((GraphicalFeatureModelEditor)editor).getCurrentSelectedDate();
		Point position = super.getLocation(reference);
		HyFeatureFigure figure = ((HyFeatureFigure)getOwner());
		Rectangle bounds = figure.calculateNameAreaBounds();
		Rectangle variantBounds = figure.calculateVariationTypeCircleBounds();
		Rectangle versionBounds = figure.calculateVersionAreaBounds();
		
		int attributeHeight = HyEvolutionUtil.getValidTemporalElements(figure.getFeature().getWrappedModelElement().getAttributes(), date).size() * theme.getFeatureNameAreaHeight();
		

		boolean hasVersions = figure.getFeature().getWrappedModelElement().getVersions().size() > 0;
		position.y = getOwner().getBounds().y + variantBounds.height + bounds.height + attributeHeight - theme.getLineWidth();		
		
		if(hasVersions)
			position.y += versionBounds.height;
		
		return position;
	}	
}
