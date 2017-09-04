package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;

import eu.hyvar.feature.util.HyFeatureUtil;

public class DwMappingNewFileWizardPageCustom extends HymappingNewFileWizardPage {

	protected ISelection selection;
	protected String fileExtension;
	
	public DwMappingNewFileWizardPageCustom(ISelection selection, String fileExtension) {
		super(selection, fileExtension);
		this.selection =  selection;
		this.fileExtension = fileExtension;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setPageComplete(boolean isComplete) {

		IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
		String fileName = getFileName();
		
		if (getContainerName().length() == 0) {
			setErrorMessage("File container must be specified");
			super.setPageComplete(false);
			return;
		}
		if (container == null || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			setErrorMessage("File container must exist");
			super.setPageComplete(false);
			return;
		}
		if (!container.isAccessible()) {
			setErrorMessage("Project must be writable");
			super.setPageComplete(false);
			return;
		}
		if (fileName.length() == 0) {
			setErrorMessage("File name must be specified");
			super.setPageComplete(false);
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			setErrorMessage("File name must be valid");
			super.setPageComplete(false);
			return;
		}
		if (!fileName.endsWith("." + fileExtension)) {
			setErrorMessage("File extension must be \"" + fileExtension + "\"");
			super.setPageComplete(false);
			return;
		}
		
		IFile featureModelFile = null;
		String featureModelFileName = fileName.substring(0, fileName.length()-fileExtension.length()-1);
		featureModelFileName += "." + HyFeatureUtil.getFeatureModelFileExtensionForXmi();
		
		if(container instanceof IFolder) {			
			featureModelFile = ((IFolder) container).getFile(featureModelFileName);
		}
		else if(container instanceof IProject) {
			featureModelFile = ((IProject) container).getFile(featureModelFileName);
		}
		
		if(!featureModelFile.exists()) {
			setErrorMessage("Mapping file has to use the same base name as its referencing feature model file.");
			super.setPageComplete(false);
			return;
		}
		
		super.setPageComplete(isComplete);
	}

}
