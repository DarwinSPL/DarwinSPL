package de.darwinspl.feature.stage.configurator.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasFeaturePredicate;
import de.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageComposition;
import de.darwinspl.feature.stage.configurator.configurator.SmStageModelConfigurator;
import de.darwinspl.feature.stage.configurator.figures.SmConfiguratorFeatureFigure;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;

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
				
				StageComposition currentComposition = HyEvolutionUtil.getValidTemporalElement(currentStage.getComposition(), editor.getCurrentSelectedDate());
				
				if(currentComposition.getFeatures().contains(wrappedFeature.getWrappedModelElement())){
					DwFeatureModelConfiguratorEditor editor = (DwFeatureModelConfiguratorEditor)getEditor();
					HyConfiguration configuration = editor.getSelectedConfiguration();
					
					boolean available = false;
					boolean inSelection = false;
					boolean inStage = false;
//					HyFeature currentFeature = DwConfiguratorEditorUtil.getParentFeature(wrappedFeature.getWrappedModelElement(), editor.getCurrentSelectedDate());
					HyFeature currentFeature = wrappedFeature.getWrappedModelElement();
					//Root Feature Handling
					if(HyEvolutionUtil.getValidTemporalElement(currentFeature.getGroupMembership(), editor.getCurrentSelectedDate()) == null){
						available = true;
					}				
					
					
					// Get all currently selected features in the configuration
					List<HyFeatureSelected> currentSelectionList = new ArrayList<HyFeatureSelected>();					
					for(HyConfigurationElement configurationElement: configuration.getElements()){
						if(configurationElement != null){
							currentSelectionList.add((HyFeatureSelected) configurationElement);
						}
					}				

					// Check if all parents are either in Stage Composition, or selected
					while(currentFeature != null  && (HyEvolutionUtil.getValidTemporalElement(currentFeature.getGroupMembership(),editor.getCurrentSelectedDate()) != null)){
						currentFeature = DwConfiguratorEditorUtil.getParentFeature(currentFeature, editor.getCurrentSelectedDate());
						inSelection = false;
						inStage = false;
						if(! currentSelectionList.isEmpty() ){
							for(HyFeatureSelected selectedFeature : currentSelectionList){	
								if( selectedFeature.getSelectedFeature().equals(currentFeature)){
									inSelection = true;
								}
							}
							if(currentComposition.getFeatures().contains(currentFeature)){
								inStage = true;
							}
							if(inStage || inSelection){
								available = true;
							} else {
								available = false;
							}
					
						} else {
							if(currentComposition.getFeatures().contains(currentFeature)){
								available = true;
							}
						}						
						//Cancel selection when not allowed
						if(available == false){
							return;
						}
						
					}					
					// Select when available
					if(available){
						DwConfiguratorElementHasFeaturePredicate<Object> predicate = new DwConfiguratorElementHasFeaturePredicate<>();
						predicate.feature = wrappedFeature.getWrappedModelElement();
						
						if(!configuration.getElements().removeIf(predicate)){
							DwConfiguratorEditorUtil.addFeatureToConfiguration(configuration, wrappedFeature.getWrappedModelElement(), editor.getCurrentSelectedDate());
						}else{
							DwConfiguratorEditorUtil.removeChildrenFeaturesFromConfiguration(configuration, wrappedFeature.getWrappedModelElement(), editor.getCurrentSelectedDate());
						}
					}
				}
			}			
			//TODO Alex: Reaction to Right click to "unselect" a feature and make it unavailable for following stages : Currently not available, requires model changes.

		}
		
		editor.refreshView();
	}	

}
