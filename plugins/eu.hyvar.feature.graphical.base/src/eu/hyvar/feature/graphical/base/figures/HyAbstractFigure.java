package eu.hyvar.feature.graphical.base.figures;

import org.eclipse.draw2d.Figure;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;

public abstract class HyAbstractFigure extends Figure {
	protected HyGraphicalFeatureModelViewer editor;
	//XYLayout layout;
	
	
	public HyAbstractFigure(HyGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}


	public HyGraphicalFeatureModelViewer getEditor() {
		return editor;
	}


	public void setEditor(HyGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}	
}
