package de.darwinspl.configurator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.configurator.dialogs.DwCriteriaOverviewDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwRESTServerSelectDialog;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class ConfiguratorCommandHandler extends AbstractHandler  {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = 	HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		
		// show dialog to enter hyvar uri
		DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(shell, "http://localhost:9001/process");
		int result = dialog.open();
		if (result != Dialog.OK) return null;
		
		// get the fm from the selected hyfeature file
		IFile selectedFile = SelectionUtil.getFirstActiveIFileWithExtension("hyfeature");
		HyFeatureModel featureModel = (HyFeatureModel)EcoreIOUtil.loadModel(selectedFile);
		
		// load the constraint model
		HyConstraintModel constraintModel = null;
		if (modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax(), featureModel)) {
			constraintModel = EcoreIOUtil.loadAccompanyingModel(featureModel,
					HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
		}

		// show the criteria dialog
		DwCriteriaOverviewDialog conDialog = new DwCriteriaOverviewDialog(shell, featureModel, constraintModel, null, dialog.getUri());
		HyConfiguration configuration = null;
		if(conDialog.open() == Dialog.OK) {
			configuration = conDialog.getConfiguration();
		}
		
		// save the generated configuration
		if(configuration != null) {
			saveConfigurationIntoFeatureModelFolder(configuration, featureModel);
		}
		return null;
	}
	
	private IFile getFile(HyFeatureModel featureModel) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		
		return workspaceRoot.getFile(new Path(featureModel.eResource().getURI().toPlatformString(true)));
	}
	
	private boolean modelFileExists(String extension, HyFeatureModel featureModel) {
		IPath path = ((IPath) getFile(featureModel).getFullPath().clone()).removeFileExtension().addFileExtension(extension);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFile(path);

		return file.exists();
	}
	
	private void saveConfigurationIntoFeatureModelFolder(HyConfiguration configuration, HyFeatureModel featureModel) {
		IPath path = ((IPath) getFile(featureModel).getFullPath().clone()).removeFileExtension()
				.addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		EcoreIOUtil.saveModelAs(configuration, workspaceRoot.getFile(path));
	}

}
