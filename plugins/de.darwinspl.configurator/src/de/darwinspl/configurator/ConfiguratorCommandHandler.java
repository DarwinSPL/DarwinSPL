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
import org.eclipse.emf.codegen.ecore.templates.editor.ModelWizard;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.dialogs.DwConfiguratorDialog;
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
		
		DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(shell, "http://localhost:9001/process");
		int result = dialog.open();
		if (result != Dialog.OK) return null;
		
		IFile selectedFile = SelectionUtil.getFirstActiveIFileWithExtension("hyfeature");
		DwFeatureModelWrapped modelWrapped = new DwFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(selectedFile));
		
		HyConstraintModel constraintModel = null;
		if (modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax(), modelWrapped)) {
			constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(),
					HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
		}

		DwConfiguratorDialog conDialog = new DwConfiguratorDialog(shell, modelWrapped.getModel(), constraintModel, modelWrapped.getDates().get(0), dialog.getUri());
		HyConfiguration configuration = conDialog.openWithConfigurationResult();
		if(configuration != null) {
			saveConfigurationIntoFeatureModelFolder(configuration, modelWrapped);
		}
		return null;
	}
	
	public IFile getFile(DwFeatureModelWrapped modelWrapped) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		
		return workspaceRoot.getFile(new Path(modelWrapped.getModel().eResource().getURI().toPlatformString(true)));
	}
	
	private boolean modelFileExists(String extension, DwFeatureModelWrapped modelWrapped) {
		IPath path = ((IPath) getFile(modelWrapped).getFullPath().clone()).removeFileExtension().addFileExtension(extension);

		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IFile file = workspaceRoot.getFile(path);

		return file.exists();
	}
	
	private void saveConfigurationIntoFeatureModelFolder(HyConfiguration configuration, DwFeatureModelWrapped modelWrapped) {
		IPath path = ((IPath) getFile(modelWrapped).getFullPath().clone()).removeFileExtension()
				.addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		EcoreIOUtil.saveModelAs(configuration, workspaceRoot.getFile(path));
	}

}
