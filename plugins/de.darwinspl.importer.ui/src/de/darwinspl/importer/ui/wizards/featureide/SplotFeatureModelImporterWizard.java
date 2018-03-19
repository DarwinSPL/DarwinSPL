package de.darwinspl.importer.ui.wizards.featureide;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.darwinspl.importer.splot.SplotFeatureModelAndConstraintsImporter;
import de.darwinspl.importer.ui.wizards.DwFeatureModelWizardImportedFilePage;
import de.darwinspl.importer.ui.wizards.FileSelectionWizardPage;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class SplotFeatureModelImporterWizard extends Wizard implements IImportWizard {

	protected FileSelectionWizardPage splotModelFileSelectionWizardPage;
	protected DwFeatureModelWizardImportedFilePage dwFeatureModelWizardImportedFilePage;
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	public SplotFeatureModelImporterWizard() {
		super();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		Object firstSelection = selection.getFirstElement();
		IFile selectedFile = null;
		if(firstSelection != null && firstSelection instanceof IFile) {
			selectedFile = (IFile) firstSelection;
		}
		
		setWindowTitle("New Feature Model");
		
		splotModelFileSelectionWizardPage = new FileSelectionWizardPage("SPLOT Feature Model Selection", "Please Select a SPLOT Feature Model for Import" , new String[] {"*.xml"}, "SPLOT Feature Model", selectedFile);
		dwFeatureModelWizardImportedFilePage = new DwFeatureModelWizardImportedFilePage("Select new File to store the imported Feature Model", selection);
	}

	@Override
	public boolean performFinish() {
		SplotFeatureModelAndConstraintsImporter importer = new SplotFeatureModelAndConstraintsImporter();
		
		FeatureModelConstraintsTuple tuple = importer.importFeatureModel(splotModelFileSelectionWizardPage.getSelectedFilePath());
		
		EcoreIOUtil.saveModelAs(tuple.getFeatureModel(), dwFeatureModelWizardImportedFilePage.getModelFile());
		
		String baseFileName = ResourceUtil.getBaseFilename(dwFeatureModelWizardImportedFilePage.getModelFile());
		IFile constraintModelFile = ResourceUtil.getFileInSameContainer(dwFeatureModelWizardImportedFilePage.getModelFile(), baseFileName+"."+HyConstraintUtil.getConstraintModelFileExtensionForXmi());
		EcoreIOUtil.saveModelAs(tuple.getConstraintModel(), constraintModelFile);
		
		System.out.println("SPLOT File:"+splotModelFileSelectionWizardPage.getSelectedFilePath());
		System.out.println("DarwinSPL File:"+dwFeatureModelWizardImportedFilePage.getModelFile().getFullPath());
		return true;
	}

	@Override
    public String getWindowTitle() {
            return "DarwinSPL: Import SPLOT Feature Model";
    }

	@Override
	public void addPages() {
		addPage(splotModelFileSelectionWizardPage);
		addPage(dwFeatureModelWizardImportedFilePage);
	}
	
}
