package de.darwinspl.feature.graphical.base.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;

/**
 * Renders a circle with dashed outline that is used to display the number of collapsed child features
 * of a parent feature.
 * 
 * @author Gil Engel
 *
 */
public class DwHiddenChildrenIndicatorFigure extends DwGradientFillCircleFigure {
	public final static int HIDDEN_CHILDREN_INDICATOR_SIZE = 30;
	
	/**
	 * Used to display the number of collapsed features
	 */
	private Label label;
	
	/**
	 * The related feature
	 */
	private DwFeatureWrapped feature;
	
	/**
	 * Reference to the feature model is needed to get the currently selected date
	 */
	private DwFeatureModelWrapped featureModel;
	
	public DwHiddenChildrenIndicatorFigure(DwFeatureWrapped feature, DwFeatureModelWrapped featureModel) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		outlineWidth = theme.getLineWidth();
		outlineColor = theme.getLineColor();
		primaryColor = theme.getFeatureNameAreaSecondaryColor();
		secondaryColor = theme.getFeatureNameAreaPrimaryColor();
		
		this.feature = feature;
		this.featureModel = featureModel;
		
		setLayoutManager(new XYLayout());
		
		label = new Label();
		label.setForegroundColor(theme.getLineColor());
		label.setFont(theme.getFeatureFont());
		label.setLocation(new Point(0, (int)(HIDDEN_CHILDREN_INDICATOR_SIZE * 0.5)));
		label.setSize(new Dimension(HIDDEN_CHILDREN_INDICATOR_SIZE, HIDDEN_CHILDREN_INDICATOR_SIZE));
		add(label);
	}
	
	/**
	 * Override to render the circle without background and with dotted outline
	 */
	@Override 
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		Rectangle realBounds = bounds.getCopy();
		
		int offset = (int)(HIDDEN_CHILDREN_INDICATOR_SIZE * 0.5);
		bounds.setY(bounds.y + offset);
		bounds.setHeight(bounds.width);
		
		//Compensate for line width
		int lineWidth = outlineWidth / 2;
		bounds.expand(-lineWidth, -lineWidth);

		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
				
		graphics.setLineStyle(SWT.LINE_CUSTOM);
		graphics.setLineDash(new int[] {4});
		graphics.setLineWidth(theme.getLineWidth());
		graphics.setForegroundColor(theme.getLineColor());

		Point topLeft = realBounds.getTopLeft();
		Point bottomLeft = realBounds.getBottomLeft();
		graphics.drawLine(new Point(topLeft.x+offset-theme.getLineWidth() / 2, topLeft.y), 
						  new Point(bottomLeft.x+offset-theme.getLineWidth() / 2, bottomLeft.y-HIDDEN_CHILDREN_INDICATOR_SIZE));


		DEDrawingUtil.outlineEllipsis(graphics, bounds, outlineColor);		
	}
	
	/**
	 * Recursively calculates the number of feature children
	 *  
	 * @param feature indicates the parent feature
	 * @param date 
	 * @return
	 */
	private int getFeatureChildrenCount(DwFeatureWrapped feature, Date date){
		int count = 0;
		
		for(DwParentChildConnection connection : feature.getChildrenConnections(date)){
			count += getFeatureChildrenCount(connection.getTarget(), date);
			count ++;
		}
		
		return count;
	}
	
	@Override
	protected boolean useLocalCoordinates() {
		return true;
	};
	
	@Override
	public boolean isVisible() {
		return feature.isHideChildren();
	};
	
	public void update(){
		label.setText(String.valueOf(getFeatureChildrenCount(feature, featureModel.getSelectedDate())));
	}
	/**
	 * Sets position and size of the figure. The figure is rendered centered at the bottom of the parent feature
	 */
	@Override
	public Rectangle getBounds(){
		Rectangle parentBound = getParent().getBounds();
		Dimension parentSize = parentBound.getSize();
		
		int height = (int)(HIDDEN_CHILDREN_INDICATOR_SIZE * 1.5);
		return new Rectangle(parentSize.width / 2 - HIDDEN_CHILDREN_INDICATOR_SIZE / 2, parentSize.height - height, HIDDEN_CHILDREN_INDICATOR_SIZE, height);
	}
}
