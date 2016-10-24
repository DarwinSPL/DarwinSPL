package eu.hyvar.feature.graphical.base.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureChildFigure extends HyAbstractFigure{
	public HyFeatureChildFigure(GraphicalFeatureModelEditor editor) {
		super(editor);
		
		setForegroundColor(ColorConstants.black);
		setBorder(new LineBorder(5));		
	}

	public void setLayout(Rectangle rect) {
		this.getParent().setConstraint(this, rect);
	}
}