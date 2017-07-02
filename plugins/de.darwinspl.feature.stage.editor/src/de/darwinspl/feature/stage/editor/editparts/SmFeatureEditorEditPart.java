package de.darwinspl.feature.stage.editor.editparts;

import org.eclipse.draw2d.IFigure;

import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.editparts.DwFeatureEditorEditPart;
import de.darwinspl.feature.stage.editor.figures.SmFeatureFigure;

public class SmFeatureEditorEditPart extends DwFeatureEditorEditPart {
	protected SmStageModelEditor stageEditor;
	
	public SmFeatureEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel, SmStageModelEditor stageEditor) {
		super(editor, featureModel);
		this.stageEditor = stageEditor;

	}	
	
	@Override
	protected IFigure createFigure() {	
		return new SmFeatureFigure(editor, (DwFeatureWrapped)getModel(), stageEditor);
	}

}
