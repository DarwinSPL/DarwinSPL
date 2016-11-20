package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.Shape;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import eu.hyvar.feature.graphical.base.anchors.HyFeatureModelPositionAnchor;
import eu.hyvar.feature.graphical.base.anchors.HyFeatureParentAnchor;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;

public class HyParentChildConnectionFigure extends PolylineConnection {
	Color color;
	protected HyFeatureParentAnchor anchor;

	private HyGraphicalFeatureModelViewer editor;
	
	public HyParentChildConnectionFigure(HyGraphicalFeatureModelViewer editor){
		this.editor = editor;
	}

	public HyFeatureModelPositionAnchor getAnchor() {
		return anchor;
	}
	

	public void setAnchor(HyFeatureParentAnchor anchor) {
		this.anchor = anchor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public HyParentChildConnectionFigure(){
		setTolerance(10);
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		color = theme.getLineColor();
		
		anchor = new HyFeatureParentAnchor(this, editor);
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
