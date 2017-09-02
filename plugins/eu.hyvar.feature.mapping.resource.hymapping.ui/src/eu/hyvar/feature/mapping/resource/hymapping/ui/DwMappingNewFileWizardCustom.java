package eu.hyvar.feature.mapping.resource.hymapping.ui;

public class DwMappingNewFileWizardCustom extends HymappingNewFileWizard {

	
	@Override
	public void addPages() {
		page = new DwMappingNewFileWizardPageCustom(selection, getFileExtension());
		addPage(page);
	}
}
