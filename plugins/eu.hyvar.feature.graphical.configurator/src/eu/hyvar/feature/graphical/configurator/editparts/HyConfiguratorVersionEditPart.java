package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyVersionEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;
import eu.hyvar.feature.graphical.configurator.predicates.HyConfiguratorElementHasVersionPredicate;
import eu.hyvar.feature.graphical.configurator.util.HyConfiguratorEditorUtil;

public class HyConfiguratorVersionEditPart extends HyVersionEditPart{

	public HyConfiguratorVersionEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	public void performRequest(Request request) {
		//React to double click
		if (request.getType() == RequestConstants.REQ_OPEN) {
			HyVersion version = (HyVersion)getModel();

			HyFeatureModelDeltaModuleConfiguratorEditor editor = (HyFeatureModelDeltaModuleConfiguratorEditor)getEditor();
			HyConfiguration selectedConfiguration = editor.getSelectedConfiguration();
			
			HyConfiguratorElementHasVersionPredicate<Object> predicate = new HyConfiguratorElementHasVersionPredicate<>();
			predicate.version = version;
			if(!selectedConfiguration.getElements().removeIf(predicate)){
				HyVersionSelected versionSelected = HyConfigurationFactory.eINSTANCE.createHyVersionSelected();
				versionSelected.setSelectedVersion(version);
				selectedConfiguration.getElements().add(versionSelected);
				
				if(!HyConfigurationUtil.configurationSelects(selectedConfiguration, version.getFeature())){
					HyConfiguratorEditorUtil.addFeatureToConfiguration(selectedConfiguration, version.getFeature(), editor.getCurrentSelectedDate());				
				}				
			}
			
			editor.refreshView();
		}
	}	
}
