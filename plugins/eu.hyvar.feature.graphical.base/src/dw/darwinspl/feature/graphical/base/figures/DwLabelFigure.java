package dw.darwinspl.feature.graphical.base.figures;

import org.eclipse.draw2d.Label;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

/**
 * Figure that contains a label to display text
 * 
 * @author Gil Engel
 *
 */
public abstract class DwLabelFigure extends DwFeatureViewerReferencedFigure {
	protected Label label;
	
	public DwLabelFigure(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		createChildFigures();
	}
	
	protected abstract void createChildFigures();

	
	
	public Label getLabel(){
		return label;
	}
	
	/**
	 * Set the text of the label to the value of the passed variable
	 * @param text
	 */
	public void setText(String text){
		label.setText(text);
	}
}
