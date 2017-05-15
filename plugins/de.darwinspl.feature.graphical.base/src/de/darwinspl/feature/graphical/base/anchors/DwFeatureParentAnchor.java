package de.darwinspl.feature.graphical.base.anchors;

import org.eclipse.draw2d.IFigure;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwFeatureParentAnchor extends DwFeatureModelPositionAnchor  {
	public DwFeatureParentAnchor(IFigure owner, DwGraphicalFeatureModelViewer editor) {
		super(owner, editor);	
	}
}
