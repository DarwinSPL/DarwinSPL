package eu.hyvar.feature.graphical.configurator.viewer;

import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.configurator.factory.HyConfiguratorEditPartFactory;

public class HyFeatureModelConfiguratorViewer extends HyGraphicalFeatureModelViewer {
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

	public HyFeatureModelConfiguratorViewer() {
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
		viewer.setEditPartFactory(new HyConfiguratorEditPartFactory(viewer, this));
	}

	/**
	 * Tries to load a feature model from a given file
	 * @param file
	 */
	protected void loadModelFromFile(IFile file){		
		// save location to the file
		this.file = file;
		
		EObject object = EcoreIOUtil.loadModel(file);
		if(object instanceof HyConfiguration){
			selectedConfiguration = (HyConfiguration)object;
			modelWrapped = new HyFeatureModelWrapped(selectedConfiguration.getFeatureModel());
			
			this.resource = modelWrapped.getModel().eResource();
		}else if(object instanceof HyFeatureModel){
			modelWrapped = new HyFeatureModelWrapped((HyFeatureModel)object);
		}
		
		setCurrentSelectedDateToMostActualDate();	
		setEditorTabText(file.getName());
		loadLayout(file);
	}


	@Override
	public void dateChanged(Date date){
		selectedConfiguration.getElements().clear();
		setCurrentSelectedDate(date);
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
