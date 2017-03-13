package eu.hyvar.feature.graphical.base.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwLabelFigure extends DwFeatureViewerReferencedFigure {

	public DwLabelFigure(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		setLayoutManager(new XYLayout());
		
		createChildFigures();
	}
	
	protected void createChildFigures(){
		
	}

	protected Label label;
	
	public Label getLabel(){
		return label;
	}
	
	public void setText(String text){
		label.setText(text);
	}
}
