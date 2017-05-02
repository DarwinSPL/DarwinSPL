package dw.darwinspl.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.Shape;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import dw.darwinspl.feature.graphical.base.anchors.DwFeatureModelPositionAnchor;
import dw.darwinspl.feature.graphical.base.anchors.DwParentChildConnectionAnchor;
import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class DwParentChildConnectionFigure extends PolylineConnection {
	Color color;
	protected DwParentChildConnectionAnchor anchor;

	private DwGraphicalFeatureModelViewer editor;
	private DwFeatureWrapped source;
		
	public DwParentChildConnectionFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped source){
		this.editor = editor;
		this.source = source;
		
		setTolerance(10);
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		color = theme.getLineColor();
		
		anchor = new DwParentChildConnectionAnchor(this, editor);
	}
			

	public DwFeatureModelPositionAnchor getAnchor() {
		return anchor;
	}
	
	public DwGraphicalFeatureModelViewer getEditor() {
		return editor;
	}

	public DwFeatureWrapped getSource() {
		return source;
	}

	public void setAnchor(DwParentChildConnectionAnchor anchor) {
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
