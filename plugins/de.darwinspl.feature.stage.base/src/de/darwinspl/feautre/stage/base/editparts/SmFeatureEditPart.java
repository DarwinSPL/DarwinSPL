package de.darwinspl.feautre.stage.base.editparts;

import org.eclipse.draw2d.IFigure;

import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.base.figures.SmFeatureFigure;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class SmFeatureEditPart extends DwFeatureEditPart {
	
	protected Stage currentStage;

	public SmFeatureEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel, Stage stage) {
		super(editor, featureModel);
		// TODO Auto-generated constructor stub
		currentStage = stage;
	}
	
	
	@Override
	protected IFigure createFigure() {	
		return new SmFeatureFigure(editor, (DwFeatureWrapped)getModel(), currentStage);
	}

}
