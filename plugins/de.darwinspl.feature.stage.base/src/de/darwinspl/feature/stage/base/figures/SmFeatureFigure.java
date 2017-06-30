package de.darwinspl.feature.stage.base.figures;

import java.util.Date;

import org.eclipse.draw2d.Graphics;

import de.darwinspl.feature.stage.Stage;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class SmFeatureFigure extends DwFeatureFigure  {
	
	protected Stage currentStage;

	public SmFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature, Stage stage) {
		super(editor, feature);		
		currentStage = stage;
	}
	
	
	/**
	 * Paint Border around Features in current stage
	 */
	//TODO Alex: This function has to be implemented to show colored borders
	protected void paintStageBorder(Graphics graphics){
		
	}

	
	/**
	 * Override paint Function to add own Borders depending on current Stage
	 */
	@Override 
	protected void paintFigure(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();

		if (feature.hasVersionsAtDate(date)) {
			paintVersionAreaBackground(graphics);
			
			paintConnection(graphics, HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getVersions(), date).get(0));
		}
		
		
		if (feature.hasAttributesAtDate(date)) {
			paintAttributeAreaBackground(graphics);
		}		
		
		paintNameAreaBackground(graphics);

	}

}
