package de.darwinspl.feature.stage.editor.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.stage.StageFactory;
import de.darwinspl.feature.stage.StageModel;

public class StageModelWizard extends Wizard {
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	protected StageModelWizardCreationPage newStageModelCreationPage;
	
	protected DwFeatureModelWrapped featureModel;

	
	
	/**
	 * Stage Model Wizard
	 * Not only a dialog, because furhter decisions may be added
	 * @param featureModel current FeatureModel
	 * @param workbench Eclipse Root
	 */
	public StageModelWizard(DwFeatureModelWrapped featureModel, IWorkbench workbench){
		super();
		
		this.workbench = workbench;
		this.featureModel = featureModel;

	}	

	
	/**
	 *  Stage Model Creation and linking with current Feature Model
	 */
	protected EObject createStageModel() {
		
		StageModel stageModel = StageFactory.eINSTANCE.createStageModel();
		stageModel.setFeatureModel(featureModel.getModel());
		
		return stageModel;
	}	


	/**
	 * Finish Function that creates the Wrapped Stage Model and saves it
	 */
	@Override
	public boolean performFinish() {
			try {

			URI featureModelURI = featureModel.getModel().eResource().getURI();
			URI stageModelURI = featureModelURI.trimFileExtension().appendFileExtension("staged");
			
			EObject stageModel = createStageModel();
			EcoreIOUtil.saveModelAs(stageModel, stageModelURI, EcoreIOUtil.getDefaultResourceSet(stageModel));
			
			//selectFileInCurrentView(file, page);
			//openFileInEditor(file, workbenchWindow, page);
	
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	
	@Override
	public void addPages(){
		newStageModelCreationPage = new StageModelWizardCreationPage("NewStageModelCreationPage");
		addPage(newStageModelCreationPage);
	}
	





}
