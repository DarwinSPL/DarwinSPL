package de.darwinspl.feature.stage.editor.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
//import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyRootFeature;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureUtil;

public class SmFeatureFigure extends DwFeatureFigure  {
	protected SmStageModelEditor stageEditor;
	public SmFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature, SmStageModelEditor stageEditor) {
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
		
	//	if( currentStage != null && currentStage.getComposition() != null){
	//if(currentStage.getComposition().get(0).getFeatures().contains(feature)){){
			paintStageBorder(graphics);
			//}
	//	}

	}
	
	
	
	/**
	 * Paint Border around Features in current stage
	 */
	//TODO Alex: This function has to be implemented to show colored borders
	protected void paintStageBorder(Graphics graphics){
		
		Rectangle featureMarkRectangle = getFeatureMarkRectangle(feature);
		DEDrawingUtil.drawSelection(graphics, featureMarkRectangle, this, false);
	}
	
	/**
	 * Marking Function from the configurator to draw Stage Borders
	 * TODO Alex: Currently Coppy pasted
	 */
	protected Rectangle getFeatureMarkRectangle(DwFeatureWrapped feature) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Date date = editor.getCurrentSelectedDate();
		Rectangle featureMarkRectangle = new Rectangle(feature.getPosition(date).getPosition(), feature.getSize(date));

		for(HyRootFeature root : feature.getWrappedModelElement().getFeatureModel().getRootFeature()){
			if(EcoreUtil.equals(root.getFeature(), feature.getWrappedModelElement())){
				if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					featureMarkRectangle.y += theme.getLineWidth();
					featureMarkRectangle.height -= theme.getLineWidth();
				}				
			}else{
				if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					int increment = (theme.getFeatureVariationTypeExtent() - 1);
					featureMarkRectangle.y += increment;
					featureMarkRectangle.height -= increment;
				}				
			}
		}


		return featureMarkRectangle;
	}

}
