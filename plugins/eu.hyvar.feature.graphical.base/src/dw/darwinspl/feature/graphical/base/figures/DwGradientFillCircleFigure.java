package dw.darwinspl.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class DwGradientFillCircleFigure extends Figure{
	protected Color primaryColor;
	protected Color secondaryColor;
	protected Color outlineColor;
	protected int outlineWidth;
	
	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Override 
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();
		
		//Compensate for line width
		int lineWidth = outlineWidth / 2;
		bounds.expand(-lineWidth, -lineWidth);

		DEDrawingUtil.gradientFillEllipsis(graphics, bounds, primaryColor, secondaryColor);
		DEDrawingUtil.outlineEllipsis(graphics, bounds, outlineColor);		
	}

	public DwGradientFillCircleFigure(Color primaryColor, Color secondaryColor, Color outlineColor, int outlineWidth) {
		super();
		
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.outlineColor = outlineColor;
		this.outlineWidth = outlineWidth;
	}
	
	public DwGradientFillCircleFigure(){
		
	}
}
