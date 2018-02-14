package de.darwinspl.importer.ui.wizards;

import org.eclipse.swt.SWT;

public class MultiFileSelectionWizardPage extends FileSelectionWizardPage {

	@Override
	protected int getSelectionType() {
		return SWT.MULTI;
	}
	
	public MultiFileSelectionWizardPage(String pageName, String description, String[] fileExtensionFilter,
			String modelName) {
		super(pageName, description, fileExtensionFilter, modelName);
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
			if(fileNames != null) {
				for(int i=0;i<fileNames.length;i++) {
					if(i!=0) {
						selectedFileTextStringBuilder.append(", ");
					}
					
					selectedFileTextStringBuilder.append(fileNames[i]);
				}
			}
		}
		sourceFilePathText.setText(selectedFileTextStringBuilder.toString());
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
