package de.darwinspl.eclipse.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.util.HyFeatureUtil;

public class DwModelSelection {

	
	public static HyFeatureModel retrieveFirstFeatureModelFromSelection() {
		List<IResource> resources = SelectionUtil.getSelectedResources();
		
		HyFeatureModel selectedFeatureModel = null;
		
		for(IResource resource: resources) {
			if(resource instanceof IFile) {
				IFile file = (IFile) resource;
				
				if(file.getFileExtension().equals(HyFeatureUtil.getFeatureModelFileExtensionForXmi())) {
					EObject eObject = EcoreIOUtil.loadModel(file);
					if(eObject instanceof HyFeatureModel) {
						selectedFeatureModel = (HyFeatureModel) eObject;
						break;
					}
				}
			}
		}
		
		
		return selectedFeatureModel;
	}
	
}
