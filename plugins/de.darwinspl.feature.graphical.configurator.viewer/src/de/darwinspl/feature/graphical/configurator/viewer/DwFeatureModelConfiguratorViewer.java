package de.darwinspl.feature.graphical.configurator.viewer;

import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import de.darwinspl.feature.graphical.configurator.factory.DwConfiguratorEditPartFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;

public class DwFeatureModelConfiguratorViewer extends DwGraphicalFeatureModelViewer {
	protected HyConfiguration selectedConfiguration;

	public HyConfiguration getSelectedConfiguration() {
		return selectedConfiguration; 
	}

	public HyConfiguration getConfiguration() {
		return getSelectedConfiguration();
	}

	public HyFeatureModel getFeatureModel() {
		if(getModelWrapped() == null) {
			return null;
		}
		return getModelWrapped().getModel();			
	}

	public Date getDate() {
		return getCurrentSelectedDate();
	}

	public DwFeatureModelConfiguratorViewer() {
		super();

		selectedConfiguration = HyConfigurationFactory.eINSTANCE.createHyConfiguration();		
	}

	/**
	 * Hook the evolution factory into the editor logic and override the standard edit part factory
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new DwConfiguratorEditPartFactory(viewer, this));
	}

	/**
	 * Tries to load a feature model from a given file
	 * @param file
	 */
	protected void loadModelFromFile(IFile file){		
		EObject object = EcoreIOUtil.loadModel(file);
		if(object instanceof HyConfiguration){
			selectedConfiguration = (HyConfiguration)object;
			modelWrapped = new DwFeatureModelWrapped(selectedConfiguration.getFeatureModel());
		}else if(object instanceof HyFeatureModel){
			modelWrapped = new DwFeatureModelWrapped((HyFeatureModel)object);
		}
		
		setCurrentSelectedDateToMostActualDate();
		
		if(selectedConfiguration != null && selectedConfiguration.getCreationDate()!=null) {
			currentSelectedDate = selectedConfiguration.getCreationDate();
		}
		
		setEditorTabText(file.getName());
		DwFeatureModelLayoutFileUtil.loadLayoutFile(modelWrapped);
	}


	@Override
	public void setCurrentSelectedDate(Date date){
		//selectedConfiguration.getElements().clear();
		
		super.setCurrentSelectedDate(date);
	}

	
	public Shell getShell() {
		return this.getSite().getWorkbenchWindow().getShell();
	}
	
	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		selectedConfiguration.setFeatureModel(getFeatureModel());
	}
}
