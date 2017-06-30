package de.darwinspl.feature.graphical.base.borders;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;

/**
 * Represents a border that adds a visible line as a border as well as a margin for the element.
 * This class is the combination of @see MarginBorder and @see LineBorder
 * 
 * @author Gil Engel
 *
 */
public class DwMarginLineBorder extends LineBorder{
	/**
	 * This border's insets.
	 */
	protected Insets insets;

	/**
	 * Constructs a MarginBorder with dimensions specified by <i>insets</i>.
	 * 
	 * @param insets
	 *            The Insets for the border
	 */
	public DwMarginLineBorder(Insets insets, Color color, int thickness) {
		super(color, thickness);
		
		this.insets = insets;
	}


	/**
	 * @see org.eclipse.draw2d.Border#getInsets(IFigure)
	 */
	@Override
	public Insets getInsets(IFigure figure) {
		return insets;
	}
}
