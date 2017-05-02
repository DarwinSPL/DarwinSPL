package dw.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.draw2d.IFigure;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.configurator.figures.DwConfiguratorFeatureFigure;

public class DwConfiguratorFeatureEditPart extends DwFeatureEditPart{

	public DwConfiguratorFeatureEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	protected IFigure createFigure() {	
		return new DwConfiguratorFeatureFigure(editor, (DwFeatureWrapped)getModel());
	}
}
