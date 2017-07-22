package de.darwinspl.feature.stage.editor.figures;

import java.util.Date;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.draw2d.geometry.Point;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageComposition;
import de.darwinspl.feature.stage.base.util.SmDrawingUtil;
import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
//import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwRootFeatureFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class SmRootFeatureFigure extends DwRootFeatureFigure  {
	protected SmStageModelEditor stageEditor;
	public SmRootFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature, SmStageModelEditor stageEditor) {
		super(editor, feature);		
		this.stageEditor = stageEditor;
	}	



	
	/**
	 * Override paint Function to add own Borders depending on current Stage
	 */
	@Override 
	protected void paintFigure(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();
		Stage currentStage = stageEditor.getCurrentSelectedStage();
		
		if (feature.hasVersionsAtDate(date)) {
			paintVersionAreaBackground(graphics);
			
			paintConnection(graphics, HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getVersions(), date).get(0));
		}
				
		if (feature.hasAttributesAtDate(date)) {
			paintAttributeAreaBackground(graphics);
		}		
		
		paintNameAreaBackground(graphics);
		
		if( currentStage != null && currentStage.getComposition() != null){
			StageComposition currentComposition = HyEvolutionUtil.getValidTemporalElement(currentStage.getComposition(), editor.getCurrentSelectedDate());
			if(currentComposition != null){
				if(currentComposition.getFeatures().contains(feature.getWrappedModelElement())){
							paintStageRepresenation(graphics);
				}
			}
		}
	}

	
	
	
	/**
	 * Paint Border around Features in current stage
	 */
	//TODO Alex: This function has to be implemented to show colored borders
	protected void paintStageRepresenation(Graphics graphics){
		
		Rectangle stageMarkRectangle = getStageMarkRectangle(feature);
		SmDrawingUtil.drawGreenRectangle(graphics, stageMarkRectangle, this, false);
	}
	
	/**
	 * Marking Function from the configurator to draw Stage Borders
	 * TODO Alex: Currently Coppy pasted
	 */
	protected Rectangle getStageMarkRectangle(DwFeatureWrapped feature) {

		Rectangle stageMarkRectangle = new Rectangle(new Point(5,5), new Point(5,5));


		return stageMarkRectangle;
	}

}
