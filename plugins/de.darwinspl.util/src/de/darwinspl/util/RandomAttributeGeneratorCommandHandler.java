package de.darwinspl.util;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.feature.HyFeatureModel;

public class RandomAttributeGeneratorCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IFile file = SelectionUtil.getFirstActiveIFileWithExtension("hyfeature");
		DwFeatureModelWrapped modelWrapped = new DwFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(file));
		HyFeatureModel featureModel = modelWrapped.getModel();
		
		RandomAttributeGeneratorDialog dialog = new RandomAttributeGeneratorDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell());
		if(dialog.open() != Dialog.OK) {
			return null;
		}
		
		RandomAttributeGenerator generator = new RandomAttributeGenerator(featureModel, dialog.getNumberOfFeatureAttributes(), dialog.getNumberOfFeatureModelAttributes(), null, null);
		featureModel = generator.generateAttributes();
		
		EcoreIOUtil.saveModelAs(featureModel, file);
		return null;
	}
	
	public IFile getFile(DwFeatureModelWrapped modelWrapped) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		
		return workspaceRoot.getFile(new Path(modelWrapped.getModel().eResource().getURI().toPlatformString(true)));
	}
}
