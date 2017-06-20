package de.darwinspl.feature.stage.editor.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.util.HyFeatureUtil;
import de.darwinspl.feature.stage.StageFactory;
import de.darwinspl.feature.stage.StageModel;

public class StageModelWizard extends Wizard {
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
	protected StageModelWizardCreationPage newStageModelCreationPage;
	
	protected HyFeatureModelWrapped featureModel;
	
	
	/**
	 * Stage Model Wizard
	 * Not only a dialog, because furhter decisions may be added
	 * @param featureModel current FeatureModel
	 * @param workbench Eclipse Root
	 */
	public StageModelWizard(HyFeatureModelWrapped featureModel, IWorkbench workbench){
		super();
		
		this.workbench = workbench;
		this.featureModel = featureModel;
	}	

	
	/**
	 * TODO Alex: Overwrite this function with Factory for Stage Model
	 */
	protected EObject createStageModel() {
		StageModel stageModel = StageFactory.eINSTANCE.createStageModel();
		
		
		// TODO Alex: Add default Stage and Role
		//featureModel = editor ;
		//HyFeatureModel featureModel = HyFeatureFactory.eINSTANCE.createHyFeatureModel();
		
		
	//	HyFeature rootFeatureFeature = HyFeatureFactory.eINSTANCE.createHyFeature();
		//HyName featureName = HyEvolutionFactory.eINSTANCE.createHyName();
		//featureName.setName("RootFeature");
		//rootFeatureFeature.getNames().add(featureName);
		//HyFeatureType featureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		//featureType.setType(HyFeatureTypeEnum.MANDATORY);
		//rootFeatureFeature.getTypes().add(featureType);
		
		//HyRootFeature rootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
		//rootFeature.setFeature(rootFeatureFeature);
	
		stageModel.setFeatureModel(featureModel.getModel());
		//stageModel.getFeatureModel().getFeatures().add(rootFeatureFeature);
		//stageModel.getFeatureModel().getRootFeature().add(rootFeature);
		
		
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
