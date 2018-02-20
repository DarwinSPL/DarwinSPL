package de.darwinspl.importer.ui.wizards.evolution.darwinspl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.importer.evolution.DwTemporalFeatureModelEvolutionImporter;
import de.darwinspl.importer.ui.wizards.DwFeatureModelEvolutionStepWizardPage;
import de.darwinspl.importer.ui.wizards.DwFeatureModelWizardImportedFilePage;
import de.darwinspl.importer.ui.wizards.DwMultiFileSelectionWizardPage;
import de.darwinspl.importer.ui.wizards.FileSelectionWizardPage;
import eu.hyvar.feature.HyFeatureModel;

public class DwEvolutionSnapshotImporterWizard extends Wizard implements IImportWizard {
	protected FileSelectionWizardPage tfmFileSelectionWizardPage;
	protected DwFeatureModelWizardImportedFilePage dwFeatureModelWizardImportedFilePage;
	protected DwFeatureModelEvolutionStepWizardPage featureModelEvolutionStepWizardPage;
	
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
		
		tfmFileSelectionWizardPage = new DwMultiFileSelectionWizardPage("Evolution Snapshot Importer", "Please Select multiple Temporal Feature Models for Import" , new String[] {"*.hyfeature", "*.dwfeature"}, "Temporal Feature Model");
		
		featureModelEvolutionStepWizardPage = new DwFeatureModelEvolutionStepWizardPage("Feature Model Evolution Step Association", null);
		
		dwFeatureModelWizardImportedFilePage = new DwFeatureModelWizardImportedFilePage("Select new File to store the imported Feature Model", selection);
		
	}

	@Override
	public boolean performFinish() {	
		
		System.out.println("Finish!");
		
		
		Map<HyFeatureModel, Date> featureModelDateMap = new HashMap<HyFeatureModel, Date>();
		
		Map<IFile, Date> fileDateMap = featureModelEvolutionStepWizardPage.getFileDateMap();
		
		ResourceSet rs = null;
		
		for(Entry<IFile, Date> fileDate : fileDateMap.entrySet()) {
			if(fileDate.getKey() != null) {
				EObject loadedObject = null;
				if(rs == null) {
					loadedObject = EcoreIOUtil.loadModel(fileDate.getKey());
					rs = loadedObject.eResource().getResourceSet();
				}
				else {
					loadedObject = EcoreIOUtil.loadModel(fileDate.getKey(), rs);
				}
				
				if(loadedObject == null) {
					System.err.println("Could not load selected file as model");
					return false;
				}
				
				if(!(loadedObject instanceof HyFeatureModel)) {
					System.err.println("Loaded file "+fileDate.getKey()+" is no Temporal Feature Model");
					return false;
				}
				
				featureModelDateMap.put((HyFeatureModel) loadedObject, fileDate.getValue());
			}
		}

		
		DwTemporalFeatureModelEvolutionImporter featureModelEvolutionImporter = new DwTemporalFeatureModelEvolutionImporter();
		try {
			HyFeatureModel mergedModel = featureModelEvolutionImporter.importFeatureModels(featureModelDateMap);
			EcoreIOUtil.saveModelAs(mergedModel, dwFeatureModelWizardImportedFilePage.getModelFile());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
    public String getWindowTitle() {
            return "DarwinSPL: Import Evolution Snapshots";
    }

	@Override
	public void addPages() {
		addPage(tfmFileSelectionWizardPage);
		addPage(featureModelEvolutionStepWizardPage);
		addPage(dwFeatureModelWizardImportedFilePage);
	}
	
	public void setSelectedFilePaths(List<String> filePaths) {
		List<IFile> files = new ArrayList<IFile>();
		
		for(String rawFilePath: filePaths) {
			files.add(ResourceUtil.makeFileRelativeToWorkspace(rawFilePath));
		}
		
		featureModelEvolutionStepWizardPage.setFiles(files);
	}
	
	@Override
	public boolean canFinish() {
		return (tfmFileSelectionWizardPage.isPageComplete() && featureModelEvolutionStepWizardPage.isPageComplete() && dwFeatureModelWizardImportedFilePage.isPageComplete());
	}

}
