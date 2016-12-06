package eu.hyvar.feature.graphical.editor.template.svg;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;

/**
 * This data container is used for drawing the arc from a group on the svg output file.
 * @author Gil Engel
 *
 */
public class HyFeatureModelSVGGroupArcDataObject {
	double startX;
	
	double startY;

	double centerX;
	
	double centerY;
	
	double endX;
	
	double endY;
	
	double angle1;
	
	double angle2;

	public double getStartX() {
		return startX;
	}

	public double getStartY() {
		return startY;
	}

	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public double getEndX() {
		return endX;
	}

	public double getEndY() {
		return endY;
	}

	public double getAngle1() {
		return angle1;
	}

	public double getAngle2() {
		return angle2;
	}

	public HyFeatureModelSVGGroupArcDataObject(double startX, double startY, double centerX, double centerY, double endX, double endY) {
		super();
		
		this.startX = startX;
		this.startY = startY;
		this.centerX = centerX;
		this.centerY = centerY;
		this.endX = endX;
		this.endY = endY;		

		
		double a = Math.abs(this.centerX-this.startX);
		double b = Math.abs(this.centerY-this.startY);
		this.angle1 = Math.atan(a / b) + Math.toRadians(90);
		
		a = Math.abs(this.endX-this.centerX);
		b = Math.abs(this.endY-this.centerY);
		this.angle2 = Math.toRadians(90) - Math.atan(a / b);
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		double radius = theme.getGroupSymbolRadius();
		
		this.startX = this.centerX + radius * Math.cos(this.angle2);
		this.startY = this.centerY + radius * Math.sin(this.angle2);
		
		this.endX = this.centerX + radius * Math.cos(this.angle1);
		this.endY = this.centerY + radius * Math.sin(this.angle1);
	}
}
