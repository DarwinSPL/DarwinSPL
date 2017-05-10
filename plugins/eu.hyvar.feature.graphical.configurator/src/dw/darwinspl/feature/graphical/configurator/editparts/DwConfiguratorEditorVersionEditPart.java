package dw.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import dw.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasVersionPredicate;
import dw.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;

public class DwConfiguratorEditorVersionEditPart extends DwVersionEditPart{

	public DwConfiguratorEditorVersionEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	public void performRequest(Request request) {
		//React to double click
		if (request.getType() == RequestConstants.REQ_OPEN) {
			HyVersion version = (HyVersion)getModel();

			DwFeatureModelConfiguratorEditor editor = (DwFeatureModelConfiguratorEditor)getEditor();
			HyConfiguration selectedConfiguration = editor.getSelectedConfiguration();
			
			DwConfiguratorElementHasVersionPredicate<Object> predicate = new DwConfiguratorElementHasVersionPredicate<>();
			predicate.version = version;
			if(!selectedConfiguration.getElements().removeIf(predicate)){
				HyVersionSelected versionSelected = HyConfigurationFactory.eINSTANCE.createHyVersionSelected();
				versionSelected.setSelectedVersion(version);
				selectedConfiguration.getElements().add(versionSelected);
				
				if(!HyConfigurationUtil.configurationSelects(selectedConfiguration, version.getFeature())){
					DwConfiguratorEditorUtil.addFeatureToConfiguration(selectedConfiguration, version.getFeature(), editor.getCurrentSelectedDate());				
				}				
			}
			
			editor.refreshView();
		}
	}	
}
