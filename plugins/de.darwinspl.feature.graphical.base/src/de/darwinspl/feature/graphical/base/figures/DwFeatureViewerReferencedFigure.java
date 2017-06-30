package de.darwinspl.feature.graphical.base.figures;

import org.eclipse.draw2d.Figure;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public abstract class DwFeatureViewerReferencedFigure extends Figure {
	protected DwGraphicalFeatureModelViewer editor;
	
	
	public DwFeatureViewerReferencedFigure(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}


	public DwGraphicalFeatureModelViewer getEditor() {
		return editor;
	}


	public void setEditor(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}	
}
