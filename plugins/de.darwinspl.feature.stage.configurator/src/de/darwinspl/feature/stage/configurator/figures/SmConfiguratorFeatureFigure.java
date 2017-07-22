package de.darwinspl.feature.stage.configurator.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.draw2d.geometry.Point;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageComposition;
import de.darwinspl.feature.stage.base.util.SmDrawingUtil;
import de.darwinspl.feature.stage.configurator.configurator.SmStageModelConfigurator;

//import de.darwinspl.feature.stage.editor.editor.SmStageModelEditor;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyRootFeature;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureUtil;

public class SmConfiguratorFeatureFigure extends DwFeatureFigure  {
	protected SmStageModelConfigurator stageConfigurator;
	public SmConfiguratorFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature, SmStageModelConfigurator stageConfigurator) {
		super(editor, feature);		
		this.stageConfigurator= stageConfigurator;

	}	


	/**
	 * Override paint Function to add own Borders depending on current Stage
	 */
	@Override 
	protected void paintFigure(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();
		Stage currentStage = stageConfigurator.getCurrentSelectedStage();


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
			if(currentComposition!= null){
				if(currentComposition.getFeatures().contains(feature.getWrappedModelElement())){
							paintStageRepresentation(graphics);
				}
			}
		}

	}
	
	
	
	/**
	 * Paint a representation for Stages
	 */
	//TODO Alex: This function has to be implemented to show colored borders
	protected void paintStageRepresentation(Graphics graphics){
		
		Rectangle featureMarkRectangle = getFeatureMarkRectangle(feature);
		SmDrawingUtil.drawGreenRectangle(graphics, featureMarkRectangle, this, false);
	}
	
	/**
	 * Marking Function from the configurator to draw Stage Representation
	 */
	protected Rectangle getStageMarkRectangle(DwFeatureWrapped feature) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = editor.getCurrentSelectedDate();
		Rectangle stageMarkRectangle = new Rectangle(new Point(5,5), new Point(5,5));

		if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
			int increment = theme.getFeatureVariationTypeExtent();
			stageMarkRectangle.y += increment;
		}
		return stageMarkRectangle;
	}
	
	
	/**
	 * Copied Function from original configurator
	 * @param feature
	 * @return
	 */
	protected Rectangle getFeatureMarkRectangle(DwFeatureWrapped feature) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Date date = editor.getCurrentSelectedDate();
		Rectangle featureMarkRectangle = new Rectangle(new Point(0,0), feature.getSize(date));

		for(HyRootFeature root : feature.getWrappedModelElement().getFeatureModel().getRootFeature()){
			if(EcoreUtil.equals(root.getFeature(), feature.getWrappedModelElement())){
				if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					featureMarkRectangle.y += theme.getLineWidth();
					featureMarkRectangle.height -= theme.getLineWidth();
				}				
			}else{
				if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					int increment = (theme.getFeatureVariationTypeExtent());
					featureMarkRectangle.y += increment + theme.getLineWidth();
					featureMarkRectangle.height -= theme.getLineWidth();;
				}				
			}
		}
		return featureMarkRectangle;
	}

}
