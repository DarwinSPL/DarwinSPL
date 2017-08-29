package de.darwinspl.feature.graphical.base.figures;


import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public abstract class DwErrorMarkerFigure extends DwLabelFigure{
	/**
	 * Tooltip to display error in the feature model
	 */
	private DwTooltipFigure tooltipFigure;
	
	public DwErrorMarkerFigure(DwGraphicalFeatureModelViewer editor) {
		super(editor);
	}

	protected ImageFigure iconFigure;
	
	/**
	 * Creates a figure to display a small icon on the left side of the name of a feature
	 */
	protected void createIconFigure(){
		ImageDescriptor descriptor = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK);
		iconFigure = new ImageFigure(descriptor.createImage(true));
		
		iconFigure.setBounds(new Rectangle(0, 0, descriptor.getImageData().width, descriptor.getImageData().height));

		iconFigure.setVisible(calculateIconVisibility());
			
		add(iconFigure);
		
		createTooltipFigure();
	}
	
	protected void updateIconFigure(){
		iconFigure.setVisible(calculateIconVisibility());
		iconFigure.setLocation(calculateLocation());
	}
	
	protected abstract boolean calculateIconVisibility();
	protected abstract Point calculateLocation();
	
	
	/**
	 * Creates the tooltip figure to show errors or warnings
	 */
	protected void createTooltipFigure() {
		tooltipFigure = new DwTooltipFigure();
		
		if(calculateIconVisibility()){
			iconFigure.setToolTip(tooltipFigure);
		}
	}
	
	/**
	 * Sets the text displayed by the figure tooltip
	 * @param tooltipText
	 */
	public void setTooltipText(String tooltipText) {
        tooltipFigure.setMessage(tooltipText);
    }
	public void setTooltipVisible(boolean visible){
		if(visible)
			iconFigure.setToolTip(tooltipFigure);
		else
			iconFigure.setToolTip(null);
		
		updateIconFigure();
	}
}
