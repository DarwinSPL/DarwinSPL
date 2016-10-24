package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.draw2d.IFigure;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;
import eu.hyvar.feature.graphical.configurator.figures.HyConfiguratorFeatureModelFigure;

public class HyConfiguratorFeatureModelEditPart extends HyFeatureModelEditPart{
	public HyConfiguratorFeatureModelEditPart(GraphicalFeatureModelEditor editor) {
		super(editor);
	}

	@Override
	protected IFigure createFigure() {
	    return new HyConfiguratorFeatureModelFigure(editor.getModelWrapped(), (HyFeatureModelDeltaModuleConfiguratorEditor)editor);
	}
}
