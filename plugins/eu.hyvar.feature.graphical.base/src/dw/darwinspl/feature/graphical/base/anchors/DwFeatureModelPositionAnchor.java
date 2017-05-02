package dw.darwinspl.feature.graphical.base.anchors;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class DwFeatureModelPositionAnchor extends AbstractConnectionAnchor {
	protected DwGraphicalFeatureModelViewer editor;
	
	public DwFeatureModelPositionAnchor(IFigure owner, DwGraphicalFeatureModelViewer editor) {
		super(owner);
		
		this.editor = editor;
	}
	
	protected boolean checkForModifier(DwFeatureWrapped feature){
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
