package eu.hyvar.feature.graphical.base.anchors;


import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyFeatureModelPositionAnchor extends AbstractConnectionAnchor {
	protected GraphicalFeatureModelEditor editor;
	
	public HyFeatureModelPositionAnchor(IFigure owner, GraphicalFeatureModelEditor editor) {
		super(owner);
		
		this.editor = editor;
	}
	
	protected boolean checkForModifier(HyFeatureWrapped feature){
		return false;
	}
	@Override
	public Point getLocation(Point reference) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getOwner().getBounds());
		getOwner().translateToAbsolute(r);
		Point location = new Point(r.getLeft().x()+r.width() / 2, r.getTop().y());
		if(getOwner() instanceof HyFeatureFigure){
			HyFeatureFigure figure = (HyFeatureFigure)getOwner();
			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
			
			GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)figure.getEditor();
			
			if(figure.getFeature().isWithoutModifier(editor.getCurrentSelectedDate())){
				location.y += theme.getFeatureVariationTypeExtent() - theme.getLineWidth();
			}
		}
		
		return location; 
	}

	
	/**
	 * COPIED from ChopboxAnchor
	 * 
	 * The owning figure's hashcode is used since equality is approximately
	 * based on the owner.
	 * 
	 * @return the hash code.
	 */
	public int hashCode() {
		if (getOwner() != null)
			return getOwner().hashCode();
		else
			return super.hashCode();
	}
}
