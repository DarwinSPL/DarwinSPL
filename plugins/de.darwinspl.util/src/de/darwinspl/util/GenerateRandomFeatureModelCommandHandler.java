package de.darwinspl.util;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;

public class GenerateRandomFeatureModelCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		RandomFeatureModelGeneratorDialog dialog = new RandomFeatureModelGeneratorDialog(
				HandlerUtil.getActiveWorkbenchWindow(event).getShell());
		if (dialog.open() != Dialog.OK) {
			return null;
		}

		String name = dialog.getName();
		int numberOfFeatures = dialog.getNumberOfFeatures();
		int maxGroupSize = dialog.getMaxSizeOfGroups();
		int numberOfFeatureAttributes = dialog.getNumberOfFeatureAttributes();
		int numberOfFeatureModelAttributes = dialog.getNumberOfFeatureModelAttributes();

		RandomFeatureModelGenerator generator = new RandomFeatureModelGenerator(numberOfFeatures, maxGroupSize,
				numberOfFeatureAttributes, numberOfFeatureModelAttributes);

		HyFeatureModel fm = generator.generate();

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof IAdaptable) {
				IProject project = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
				IPath path = project.getFullPath();
				IFile file = ResourceUtil.getLocalFile(path.append(name + ".hyfeature").toString());
				EcoreIOUtil.saveModelAs(fm, file);

			}
		}

		return null;
	}

}
