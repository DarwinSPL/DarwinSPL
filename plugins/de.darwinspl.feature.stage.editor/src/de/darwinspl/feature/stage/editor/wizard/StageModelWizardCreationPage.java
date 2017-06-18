package de.darwinspl.feature.stage.editor.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.christophseidl.util.eclipse.ResourceUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

public class StageModelWizardCreationPage extends WizardPage {
	
	private Composite container;
	

	public StageModelWizardCreationPage(String pageName) {
		super(pageName);
		
		setTitle("Adding a Staged Model to the Feature Model");
		setDescription("description");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NONE);
		
		
		setControl(container);
		setPageComplete(true);
	}


	
//	public IFile getModelFile() {
//		IPath containerFullPath = getContainerFullPath();
//		String filename = getFileName();
//		IPath filePath = containerFullPath.append(filename);
//		String filePathString = filePath.toString();
//		IFile file = ResourceUtil.getLocalFile(filePathString);
//		String fileExtension = file.getFileExtension();
//		
//		//Ensure that the file has the right extension
//		if (fileExtension.equalsIgnoreCase(HyFeatureUtil.getFeatureModelFileExtensionForXmi())) {
//			return file;
//		}
//		
//		return ResourceUtil.getLocalFile(filePathString + "."+HyFeatureUtil.getFeatureModelFileExtensionForXmi());
//	}
	
}
