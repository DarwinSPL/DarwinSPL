package de.darwinspl.feature.graphical.base.editparts;

import org.eclipse.draw2d.IFigure;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwRootFeatureFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;


public class DwRootFeatureEditPart extends DwFeatureEditPart{

	public DwRootFeatureEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {	
		return new DwRootFeatureFigure(editor, (DwFeatureWrapped)getModel());
	}
	
	/**
	 * Make sure that root features don't have modifiers
	 */
	@Override
	protected boolean hasModifier(DwFeatureWrapped feature){
		return false;
	}
	
	@Override
	public void refresh(){
		super.refresh();
	}
}
