package de.darwinspl.feature.stage.editor.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
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
	 * New Consturctor to allow reference to exisiting FeauterModel
	 */
	public StageModelWizard(HyFeatureModelWrapped featureModel, IWorkbench workbench){
		super();
		this.workbench = workbench;
		this.featureModel = featureModel;
	}
	
	
	
	/**
	 * Changed Init method
	 */
//	public void init(IWorkbench workbench, IStructuredSelection selection) {
//		this.workbench = workbench;
//		this.selection = selection;
//		System.out.println("init successfull");
//		setWindowTitle("New Staged Feature Model");
//		newStageModelCreationPage = new StageModelWizardCreationPage("NewStageModelCreationPage");
//	}
//	

	
	/**
	 * TODO Alex: Overwrite this function with Factory for Stage Model
	 */
	protected EObject createStageModel() {
		StageModel stageModel = StageFactory.eINSTANCE.createStageModel();
		
		
		// TODO Alex: Change stuff 
		//#################### Tryout Section ########################
		
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();
	    IEditorPart editor = page.getActiveEditor();
	   
		
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
//	protected EObject createInitialModel() {
//		HyFeatureModel featureModel = HyFeatureFactory.eINSTANCE.createHyFeatureModel();
//		
//		HyFeature rootFeatureFeature = HyFeatureFactory.eINSTANCE.createHyFeature();
//		HyName featureName = HyEvolutionFactory.eINSTANCE.createHyName();
//		featureName.setName("RootFeature");
//		rootFeatureFeature.getNames().add(featureName);
//		HyFeatureType featureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
//		featureType.setType(HyFeatureTypeEnum.MANDATORY);
//		rootFeatureFeature.getTypes().add(featureType);
//		
//		HyRootFeature rootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
//		rootFeature.setFeature(rootFeatureFeature);
//		
//		featureModel.getFeatures().add(rootFeatureFeature);
//		featureModel.getRootFeature().add(rootFeature);
//		
//		return featureModel;
//	}	

	// TODO: Alex replacement for perform finish method
	//currently I try to get the currently active model file from the editor and use that file for initialization
	@Override
	public boolean performFinish() {
			try {
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
		    IEditorPart editor = page.getActiveEditor();
			IEditorInput input = editor.getEditorInput();
			IPath path = ((FileEditorInput) input).getPath();
			String filePathString = path.toString();
			IFile file = ResourceUtil.getLocalFile(filePathString);
			
			saveModel(file);
			//selectFileInCurrentView(file, page);
			//openFileInEditor(file, workbenchWindow, page);
	
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}
	
	
//	@Override
//	public boolean performFinish() {
//		try {
//			IFile file = newStageModelCreationPage.getModelFile();
//			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
//			IWorkbenchPage page = workbenchWindow.getActivePage();
//
//			saveModel(file);
//			selectFileInCurrentView(file, page);
//			openFileInEditor(file, workbenchWindow, page);
//
//			return true;
//		} catch (Exception exception) {
//			exception.printStackTrace();
//			return false;
//		}
//	}
	
	protected void saveModel(final IFile file) throws InvocationTargetException, InterruptedException {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					EObject model = createStageModel();
					EcoreIOUtil.saveModelAs(model, file);
				} finally {
					progressMonitor.done();
				}
			}
		};

		IWizardContainer container = getContainer();
		container.run(false, false, operation);
	}


//	protected void selectFileInCurrentView(final IFile file, IWorkbenchPage page) {
//		final IWorkbenchPart activePart = page.getActivePart();
//		
//		if (activePart instanceof ISetSelectionTarget) {
//			final ISelection targetSelection = new StructuredSelection(file);
//			Shell shell = getShell();
//			Display display = shell.getDisplay();
//			
//			Runnable runnable = new Runnable() {
//				 public void run() {
//					 ISetSelectionTarget setSelectionTarget = (ISetSelectionTarget) activePart;
//					 setSelectionTarget.selectReveal(targetSelection);
//				 }
//			};
//			 
//			display.asyncExec(runnable);
//		}
//	}	


//	protected void openFileInEditor(IFile file, IWorkbenchWindow workbenchWindow, IWorkbenchPage page) throws PartInitException{
//		IEditorRegistry editorRegistry = workbench.getEditorRegistry();
//		FileEditorInput fileEditorInput = new FileEditorInput(file);
//		
//		IPath filePath = file.getFullPath();
//		String filePathString = filePath.toString();
//		
//		IEditorDescriptor defaultEditor = editorRegistry.getDefaultEditor(filePathString);
//		String defaultEditorId = defaultEditor.getId();
//		
//		page.openEditor(fileEditorInput, defaultEditorId);					 	 
//
////		Shell shell = workbenchWindow.getShell();
////		String title = "Error";
////		String message = exception.getMessage();
////		MessageDialog.openError(shell, title, message);
//	}
//	

	
	@Override
	public void addPages(){
		newStageModelCreationPage = new StageModelWizardCreationPage("NewStageModelCreationPage");
		addPage(newStageModelCreationPage);
	}
	





}
