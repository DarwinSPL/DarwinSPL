package de.darwinspl.feature.stage.editor.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.christophseidl.util.eclipse.ResourceUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

public class StageModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

	public StageModelWizardNewFileCreationPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		
		setTitle("New Staged DarwinSPL Feature Model Wizard");
		setDescription("Select a File where to store the new Staged DarwinSPL Feature Model");
		setFileName("FeatureModel.hyfeature");
	}

	@Override
	protected boolean validatePage() {
		return true;
	}
	

	public IFile getModelFile() {
		IPath containerFullPath = getContainerFullPath();
		String filename = getFileName();
		IPath filePath = containerFullPath.append(filename);
		String filePathString = filePath.toString();
		IFile file = ResourceUtil.getLocalFile(filePathString);
		String fileExtension = file.getFileExtension();
		
		//Ensure that the file has the right extension
		if (fileExtension.equalsIgnoreCase(HyFeatureUtil.getFeatureModelFileExtensionForXmi())) {
			return file;
		}
		
		return ResourceUtil.getLocalFile(filePathString + "."+HyFeatureUtil.getFeatureModelFileExtensionForXmi());
	}
	
}
