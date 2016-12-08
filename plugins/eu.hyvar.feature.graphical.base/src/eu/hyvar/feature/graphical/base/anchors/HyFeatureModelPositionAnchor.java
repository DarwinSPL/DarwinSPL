package eu.hyvar.feature.graphical.base.anchors;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyFeatureModelPositionAnchor extends AbstractConnectionAnchor {
	protected HyGraphicalFeatureModelViewer editor;
	
	public HyFeatureModelPositionAnchor(IFigure owner, HyGraphicalFeatureModelViewer editor) {
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
		
		Point location = new Point(r.getLeft().x()+r.width() / 2, r.getTop().y());
		getOwner().translateToAbsolute(location);

		return location; 
	}

	
	/**
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
