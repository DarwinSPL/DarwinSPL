package de.darwinspl.feature.stage.configurator.editparts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.feature.graphical.configurator.figures.DwConfiguratorFeatureFigure;
import de.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasFeaturePredicate;
import de.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.configurator.configurator.SmStageModelConfigurator;
import de.darwinspl.feature.stage.configurator.figures.SmConfiguratorFeatureFigure;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.configuration.HyConfiguration;

public class SmConfiguratorFeatureEditPart extends DwFeatureEditPart {
	protected SmStageModelConfigurator stageConfigurator;
	
	public SmConfiguratorFeatureEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel, SmStageModelConfigurator configurator) {
		super(editor, featureModel);		
		this.stageConfigurator = configurator;
	}
	
	
	@Override
	protected IFigure createFigure() {	
		return new SmConfiguratorFeatureFigure(editor, (DwFeatureWrapped)getModel(), stageConfigurator);
	}


	@Override
	public void performRequest(Request request) {
		 // Get currently active stage and check for
		Stage currentStage = stageConfigurator.getCurrentSelectedStage();
		
		if(currentStage != null){
			//React to double click
			
			if (request.getType() == RequestConstants.REQ_OPEN) {
				DwFeatureWrapped wrappedFeature = (DwFeatureWrapped)getModel();
				if(currentStage.getComposition().get(0).getFeatures().contains(wrappedFeature.getWrappedModelElement())){
					DwFeatureModelConfiguratorEditor editor = (DwFeatureModelConfiguratorEditor)getEditor();
					HyConfiguration configuration = editor.getSelectedConfiguration();
					
					DwConfiguratorElementHasFeaturePredicate<Object> predicate = new DwConfiguratorElementHasFeaturePredicate<>();
					predicate.feature = wrappedFeature.getWrappedModelElement();
					
					if(!configuration.getElements().removeIf(predicate)){
						DwConfiguratorEditorUtil.addFeatureToConfiguration(configuration, wrappedFeature.getWrappedModelElement(), editor.getCurrentSelectedDate());
					}else{
						DwConfiguratorEditorUtil.removeChildrenFeaturesFromConfiguration(configuration, wrappedFeature.getWrappedModelElement(), editor.getCurrentSelectedDate());
					}
				}
			}
			
			//TODO Alex: Reaction to Right click to "unselect" a feature and make it unavailable for following stages
			//TODO Alex: Features Selectable only when parent is already selected, or the stage has rights for the previous features.
		}
		
		editor.refreshView();
	}	

}
