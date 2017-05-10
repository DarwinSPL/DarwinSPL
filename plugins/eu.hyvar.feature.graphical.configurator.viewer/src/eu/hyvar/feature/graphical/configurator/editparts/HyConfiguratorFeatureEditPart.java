package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.draw2d.IFigure;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.configurator.figures.HyConfiguratorFeatureFigure;

public class HyConfiguratorFeatureEditPart extends HyFeatureEditPart{

	public HyConfiguratorFeatureEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	protected IFigure createFigure() {	
		return new HyConfiguratorFeatureFigure(editor, (HyFeatureWrapped)getModel());
	}
}
