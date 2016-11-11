package eu.hyvar.feature.graphical.base.figures;

import org.eclipse.draw2d.Graphics;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyRootFeatureFigure extends HyFeatureFigure{

	public HyRootFeatureFigure(GraphicalFeatureModelEditor editor, HyFeatureWrapped feature) {
		super(editor, feature);
	}
	/*
	@Override 
	protected void paintFigure(Graphics graphics) {
		paintNameAreaBackground( graphics);
		
		Rectangle r = getBounds().getCopy();
		setConstraint(label, new Rectangle(0, 0, r.width, r.height));

		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle nameAreaBounds = calculateNameAreaBounds();
		Dimension preferredLabelSize = label.getPreferredSize();

		int labelWidth = nameAreaBounds.width;
		int labelHeight = preferredLabelSize.height;
		int labelX = 0;
		int labelY = theme.getFeatureVariationTypeExtent() + (theme.getFeatureNameAreaHeight() - labelHeight) / 2;

		Rectangle labelBounds = new Rectangle(labelX, labelY, labelWidth, labelHeight);
		label.setBounds(labelBounds);

		if(isOpaque()){
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.fillRectangle(getBounds());
		}

	    setConstraint(label, new Rectangle(0, 0, r.width, r.height));

		HyFeatureWrapped feature = getFeature();
		if (versionAreaIsVisible(feature.getWrappedModelElement())) {
			paintFigureAreaBackground(graphics);
			//paintVersionConnections(graphics);
			paintConnection(graphics, feature.getWrappedModelElement().getVersions().get(0));
		}
	}
	*/
}