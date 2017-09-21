package de.darwinspl.feature.graphical.configurator.editor.listeners;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;

public class DwLoadConfigurationListener extends SelectionAdapter {

	private DwFeatureModelConfiguratorEditor configurator;

	public DwLoadConfigurationListener(DwFeatureModelConfiguratorEditor configurator) {
		super();
		this.configurator = configurator;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Shell shell = configurator.getShell();

		HyFeatureModel featureModel = configurator.getFeatureModel();
		IFile featureModelFile = EcoreIOUtil.getFile(featureModel);
		
		IContainer container = featureModelFile.getParent();
		String location = container.getLocation().toOSString();
		
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);

		dialog.setFilterNames(new String[] { "DarwinSPL Configurations" });
		dialog.setFilterExtensions(
				new String[] { "*." + HyConfigurationUtil.getConfigurationModelFileExtensionForXmi() });
		dialog.setFilterPath(location);
		
		String configurationAbsoluteFilePath = dialog.open();
		
		if(configurationAbsoluteFilePath == null) {
	    	return;
	    }
	    
	    IProject project = featureModelFile.getProject();
	    try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e2) {
			e2.printStackTrace();
		}
	    String projectFilePath = project.getLocation().toOSString();
	    
	    if(configurationAbsoluteFilePath.startsWith(projectFilePath)) {
	    	configurationAbsoluteFilePath = configurationAbsoluteFilePath.substring(projectFilePath.length()+1);
	    	
	    	String[] splits = configurationAbsoluteFilePath.split("\\\\");
	    	IFolder lastFolder = null;
	    	
	    	String fileName = null;
	    	
	    	for(int i = 0; i<splits.length;i++) {
	    		if(i == splits.length-1) {
	    			fileName = splits[i];
	    		}
	    		else {
	    			if(lastFolder != null) {
	    				lastFolder = lastFolder.getFolder(splits[i]);
	    			}
	    			else {
	    				lastFolder = project.getFolder(splits[i]);
	    			}
	    			
	    			if(!lastFolder.exists()) {
	    				try {
							lastFolder.create(true, true, null);
						} catch (CoreException e1) {
							e1.printStackTrace();
						}
	    			}
	    		}
	    	}
	    	
	    	IFile configurationFile = null;
	    	
	    	if(lastFolder == null) {
	    		configurationFile = project.getFile(fileName);
	    	}
	    	else {
	    		 configurationFile = lastFolder.getFile(fileName);
	    	}
	    	
		    EObject eObject = EcoreIOUtil.loadModel(configurationFile, featureModel.eResource().getResourceSet());
		    if(eObject != null && eObject instanceof HyConfiguration) {
		    	HyConfiguration configuration = (HyConfiguration) eObject;
		    	
		    	if(configuration.getFeatureModel() != featureModel) {
		    		MessageDialog.openError(shell, "Could not load configuration", "Only configurations for this feature model can be loaded.");
		    		return;
		    	}
		    	
		    	// needs to be done in order to load this configuration multiple times
		    	HyConfiguration copiedConfiguration = EcoreUtil.copy(configuration);
		    	
		    	configurator.setConfiguration(copiedConfiguration);
		    }
		    else {
		    	MessageDialog.openError(shell, "Could not load configuration", "Loaded file was no valid configuration file.");
		    	return;
		    }
		    
	    }
	    else {
	    	MessageDialog.openError(shell, "Could not load configuration", "Configurations need to be located in the same project as the feature model.");
	    	return;
	    }
	}
}
