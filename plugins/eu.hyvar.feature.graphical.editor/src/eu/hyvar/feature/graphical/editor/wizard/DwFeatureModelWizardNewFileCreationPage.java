package eu.hyvar.feature.graphical.editor.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.christophseidl.util.eclipse.ResourceUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

public class DwFeatureModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

	public DwFeatureModelWizardNewFileCreationPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		
		setTitle("TODO: Title");
		setDescription("TODO: Description");
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
