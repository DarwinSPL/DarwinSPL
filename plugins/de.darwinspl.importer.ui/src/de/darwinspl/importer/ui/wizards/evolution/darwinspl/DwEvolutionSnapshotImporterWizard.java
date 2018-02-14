package de.darwinspl.importer.ui.wizards.evolution.darwinspl;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import de.darwinspl.importer.ui.wizards.DwFeatureModelWizardImportedFilePage;
import de.darwinspl.importer.ui.wizards.FileSelectionWizardPage;
import de.darwinspl.importer.ui.wizards.MultiFileSelectionWizardPage;

public class DwEvolutionSnapshotImporterWizard extends Wizard implements IImportWizard {
	protected FileSelectionWizardPage tfmFileSelectionWizardPage;
	protected DwFeatureModelWizardImportedFilePage dwFeatureModelWizardImportedFilePage;
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	public DwEvolutionSnapshotImporterWizard() {
		super();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		setWindowTitle("New Feature Model");
		
		tfmFileSelectionWizardPage = new MultiFileSelectionWizardPage("Evolution Snapshot Importer", "Please Select multiple Temporal Feature Models for Import" , new String[] {"*.hyfeature", "*.dwfeature"}, "Temporal Feature Model");
		dwFeatureModelWizardImportedFilePage = new DwFeatureModelWizardImportedFilePage("Select new File to store the imported Feature Model", selection);
	}

	@Override
	public boolean performFinish() {	
		System.out.println("Finish!");
		return true;
	}

	@Override
    public String getWindowTitle() {
            return "DarwinSPL: Import Evolution Snapshots";
    }

	@Override
	public void addPages() {
		addPage(tfmFileSelectionWizardPage);
		addPage(dwFeatureModelWizardImportedFilePage);
	}

}
