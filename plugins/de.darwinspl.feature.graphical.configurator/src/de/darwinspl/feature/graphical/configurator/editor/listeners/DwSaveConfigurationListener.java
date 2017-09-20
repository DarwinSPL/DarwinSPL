package de.darwinspl.feature.graphical.configurator.editor.listeners;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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

public class DwSaveConfigurationListener extends SelectionAdapter {

	private DwFeatureModelConfiguratorEditor configurator;
	
	public DwSaveConfigurationListener(DwFeatureModelConfiguratorEditor configurator) {
		super();
		this.configurator = configurator;
	}
	
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		Shell shell = configurator.getShell();
		
		
		HyConfiguration configuration = configurator.getConfiguration();
		HyFeatureModel featureModel = configurator.getFeatureModel();
		IFile featureModelFile = EcoreIOUtil.getFile(featureModel);
		
		IContainer container = featureModelFile.getParent();
		String location = container.getLocation().toOSString();
		
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
	    dialog
	        .setFilterNames(new String[] { "DarwinSPL Configurations"});
	    dialog.setFilterExtensions(new String[] { "*."+HyConfigurationUtil.getConfigurationModelFileExtensionForXmi()}); 
	    dialog.setFilterPath(location); 
	    dialog.setFileName("configuration."+HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
	    
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
	    	
		    EcoreIOUtil.saveModelAs(configuration, configurationFile, featureModel.eResource().getResourceSet());
	    }
	    else {
	    	MessageDialog.openError(shell, "Could not save configuration", "Configurations need to be saved in the same project as the feature model");
	    }
	}
	
}
