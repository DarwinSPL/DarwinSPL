package de.darwinspl.feature.stage.base.util;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;

/**
 * Drawing Utilities for Stage Highlighting, using DeltaEcore DrawingUtils
 *
 */
public class SmDrawingUtil extends DEDrawingUtil  {
	
	public static void drawRedRectangle(Graphics graphics, Rectangle markArea, IFigure parentFigure, boolean previouslySelected) {
		Device device = Display.getCurrent ();
		Color lightColor = new Color(device,200,0,0);
		Color darkColor = new Color(device, 150,0,0);
		Color lineColor = new Color(device, 180,0,0);
		
		Rectangle drawingBounds = transformMarkRectangleToDrawingBounds(markArea, parentFigure);
		
		DEDrawingUtil.gradientFillRectangle(graphics, drawingBounds, lightColor, darkColor);
		DEDrawingUtil.outlineRectangle(graphics, drawingBounds, lineColor);
	}
	
	public static void drawGreenRectangle(Graphics graphics, Rectangle markArea, IFigure parentFigure, boolean previouslySelected) {
		Device device = Display.getCurrent ();
		Color lightColor = new Color(device,0,200,0);
		Color darkColor = new Color(device, 0,100,0);
		Color lineColor = new Color(device, 0,200,0);
		
		Rectangle drawingBounds = transformMarkRectangleToDrawingBounds(markArea, parentFigure);
		
		DEDrawingUtil.gradientFillRectangle(graphics, drawingBounds, lightColor, darkColor);
		DEDrawingUtil.outlineRectangle(graphics, drawingBounds, lineColor);
	}
	
	
	private static Rectangle transformMarkRectangleToDrawingBounds(Rectangle markArea, IFigure parentFigure) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle drawingBounds = markArea.getCopy();
		
		Rectangle parentBounds = parentFigure.getBounds();
		drawingBounds.translate(parentBounds.x, parentBounds.y);
		
		drawingBounds.expand(theme.getSecondaryMargin(), theme.getSecondaryMargin());

		return drawingBounds;
	}
	
}
