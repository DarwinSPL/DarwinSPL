package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.Shape;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import eu.hyvar.feature.graphical.base.anchors.HyFeatureModelPositionAnchor;
import eu.hyvar.feature.graphical.base.anchors.HyParentChildConnectionAnchor;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyParentChildConnectionFigure extends PolylineConnection {
	Color color;
	protected HyParentChildConnectionAnchor anchor;

	private DwGraphicalFeatureModelViewer editor;
	private HyFeatureWrapped source;
		
	public HyParentChildConnectionFigure(DwGraphicalFeatureModelViewer editor, HyFeatureWrapped source){
		this.editor = editor;
		this.source = source;
		
		setTolerance(10);
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		color = theme.getLineColor();
		
		anchor = new HyParentChildConnectionAnchor(this, editor);
	}
			

	public HyFeatureModelPositionAnchor getAnchor() {
		return anchor;
	}
	
	public DwGraphicalFeatureModelViewer getEditor() {
		return editor;
	}

	public HyFeatureWrapped getSource() {
		return source;
	}

	public void setAnchor(HyParentChildConnectionAnchor anchor) {
		this.anchor = anchor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
	}
	
	/**
	 * @see Shape#outlineShape(Graphics)
	 */
	protected void outlineShape(Graphics graphics) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		graphics.setAntialias(SWT.ON);
		graphics.setForegroundColor(color);
		graphics.setLineWidth(theme.getLineWidth());
		graphics.drawPolyline(getPoints());
	}	
}
