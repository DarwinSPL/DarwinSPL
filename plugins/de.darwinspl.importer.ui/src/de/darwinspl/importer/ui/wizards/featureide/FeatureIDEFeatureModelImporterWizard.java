package de.darwinspl.importer.ui.wizards.featureide;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.darwinspl.importer.featureide.FeatureIDEFeatureModelAndConstraintsImporter;
import de.darwinspl.importer.ui.wizards.DwFeatureModelWizardImportedFilePage;
import de.darwinspl.importer.ui.wizards.FileSelectionWizardPage;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class FeatureIDEFeatureModelImporterWizard extends Wizard implements IImportWizard {

	protected FileSelectionWizardPage featureIdeModelFileSelectionWizardPage;
	protected DwFeatureModelWizardImportedFilePage dwFeatureModelWizardImportedFilePage;
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	public FeatureIDEFeatureModelImporterWizard() {
		super();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		setWindowTitle("New Feature Model");
		
		featureIdeModelFileSelectionWizardPage = new FileSelectionWizardPage("FeatureIDE Feature Model Selection", "Please Select a FeatureIDE Feature Model for Import" , new String[] {"*.xml"}, "FeatureIDE Feature Model");
		dwFeatureModelWizardImportedFilePage = new DwFeatureModelWizardImportedFilePage("Select new File to store the imported Feature Model", selection);
	}

	@Override
	public boolean performFinish() {
		FeatureIDEFeatureModelAndConstraintsImporter importer = new FeatureIDEFeatureModelAndConstraintsImporter();
		
		FeatureModelConstraintsTuple tuple = importer.importFeatureModel(featureIdeModelFileSelectionWizardPage.getSelectedFilePath());
		HyFeatureModel featureModel = tuple.getFeatureModel();
		HyConstraintModel constraintModel = tuple.getConstraintModel();
		
		IFile featureModelFile = dwFeatureModelWizardImportedFilePage.getModelFile();
		IFile constraintModelFile = ResourceUtil.deriveFile(featureModelFile, HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
		IFile constraintModelFileXmi = ResourceUtil.deriveFile(featureModelFile, HyConstraintUtil.getConstraintModelFileExtensionForXmi());
		
		EcoreIOUtil.saveModelAs(featureModel, featureModelFile);
		EcoreIOUtil.saveModelAs(constraintModel, constraintModelFile);
		EcoreIOUtil.saveModelAs(constraintModel, constraintModelFileXmi);
		
		
		System.out.println("FeatureIDE File:"+featureIdeModelFileSelectionWizardPage.getSelectedFilePath());
		System.out.println("DarwinSPL File:"+dwFeatureModelWizardImportedFilePage.getModelFile().getFullPath());
		return true;
	}

	@Override
    public String getWindowTitle() {
            return "DarwinSPL: Import FeatureIDE Feature Model";
    }

	@Override
	public void addPages() {
		addPage(featureIdeModelFileSelectionWizardPage);
		addPage(dwFeatureModelWizardImportedFilePage);
	}
}
