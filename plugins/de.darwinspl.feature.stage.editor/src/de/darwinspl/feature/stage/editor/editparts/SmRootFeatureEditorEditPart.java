package de.darwinspl.feature.stage.editor.editparts;

import org.eclipse.draw2d.IFigure;

import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.editparts.DwRootFeatureEditorEditPart;
import de.darwinspl.feature.stage.editor.figures.SmRootFeatureFigure;

public class SmRootFeatureEditorEditPart extends DwRootFeatureEditorEditPart {
	protected SmStageModelEditor stageEditor;
	
	public SmRootFeatureEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel, SmStageModelEditor stageEditor) {
		super(editor, featureModel);
		this.stageEditor = stageEditor;

	}	
	
	@Override
	protected IFigure createFigure() {	
		return new SmRootFeatureFigure(editor, (DwFeatureWrapped)getModel(), stageEditor);
	}
	


}
