package eu.hyvar.feature.graphical.base.figures;

import org.eclipse.draw2d.Figure;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public abstract class HyAbstractFigure extends Figure {
	protected GraphicalFeatureModelEditor editor;
	//XYLayout layout;
	
	
	public HyAbstractFigure(GraphicalFeatureModelEditor editor) {
		this.editor = editor;
	}


	public GraphicalFeatureModelEditor getEditor() {
		return editor;
	}


	public void setEditor(GraphicalFeatureModelEditor editor) {
		this.editor = editor;
	}	
}
