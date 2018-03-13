package de.darwinspl.importer.ui.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.SWT;

import de.darwinspl.importer.ui.wizards.evolution.darwinspl.DwEvolutionSnapshotImporterWizard;

public class DwMultiFileSelectionWizardPage extends FileSelectionWizardPage {

	@Override
	protected int getSelectionType() {
		return SWT.MULTI;
	}
	
	public DwMultiFileSelectionWizardPage(String pageName, String description, String[] fileExtensionFilter,
			String modelName, IFile selectedFile) {
		super(pageName, description, fileExtensionFilter, modelName, selectedFile);
	}
	
	@Override
	public String getSelectedFilePath() {
		return null;
	}
	
	@Override
	protected void setSelectedFileText() {
		StringBuilder selectedFileTextStringBuilder = new StringBuilder();
		if(fileDialog != null) {
			String[] fileNames = fileDialog.getFileNames();
			List<String> fileNameList = new ArrayList<String>();
			if(fileNames != null) {
				String basePath = fileDialog.getFilterPath();
				
				for(int i=0;i<fileNames.length;i++) {
					if(i!=0) {
						selectedFileTextStringBuilder.append(", ");
					}
					
					String fullPath = basePath + File.separator +fileNames[i];
					
					selectedFileTextStringBuilder.append(fullPath);
					
					fileNameList.add(fullPath);
				}
				
				
			}
			
			IWizard wizard = getWizard();
			if(wizard instanceof DwEvolutionSnapshotImporterWizard) {
				DwEvolutionSnapshotImporterWizard evolutionSnapshotImporterWizard = (DwEvolutionSnapshotImporterWizard) wizard;
				evolutionSnapshotImporterWizard.setSelectedFilePaths(fileNameList);
			}
		}
		selectedSourceFileLabel.setText(modelName+ "s selected: "+ selectedFileTextStringBuilder.toString());
	}
	
	/**
	 * 
	 * @return May be null
	 */
	public String[] getSelectedFilesPaths() {
		if(fileDialog != null) {
			return fileDialog.getFileNames();
		}
		
		return null;
	}

}
