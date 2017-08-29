package de.darwinspl.feature.graphical.configurator.editor.listeners;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.christophseidl.util.eclipse.ResourceUtil;
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
	    
	    IFile configurationFile = ResourceUtil.makeFileRelativeToWorkspace(configurationAbsoluteFilePath);
	    
	    EcoreIOUtil.saveModelAs(configuration, configurationFile, featureModel.eResource().getResourceSet());
	}
	
}
