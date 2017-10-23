package de.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasVersionPredicate;
import de.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
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
				
				selectedConfiguration = checkIfConfigurationContainsOtherVersion(selectedConfiguration, version);
				
				selectedConfiguration.getElements().add(versionSelected);
				
				if(!HyConfigurationUtil.configurationSelects(selectedConfiguration, version.getFeature())){
					DwConfiguratorEditorUtil.addFeatureToConfiguration(selectedConfiguration, version.getFeature(), editor.getCurrentSelectedDate());				
				}
				
			}
			
			editor.refreshView();
		}
	}
	
	
	/**
	 * Checks if another version of the feature is already selected.
	 * 
	 * If this is the case, the previously selected version is deselected.
	 * 
	 * @param selectedConfiguration currently selected configuration of the feature model
	 * @param version the new selected version of a feature
	 * @return
	 */
	private HyConfiguration checkIfConfigurationContainsOtherVersion(HyConfiguration selectedConfiguration, HyVersion version) {
		
		for(EObject object: selectedConfiguration.getElements()){
			if(object instanceof HyVersionSelected){
				HyVersionSelected otherVersion = (HyVersionSelected) object;
				if(otherVersion.getSelectedVersion().getFeature().equals(version.getFeature())){
					selectedConfiguration.getElements().remove(otherVersion);
					return selectedConfiguration;
				}
			}
		}
		return selectedConfiguration;
	}	
}
