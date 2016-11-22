package eu.hyvar.feature.graphical.editor.wizard;

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

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.util.HyFeatureUtil;

public class FeatureModelWizard extends Wizard implements INewWizard {

	protected DwFeatureModelWizardNewFileCreationPage newFileCreationPage;
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	
//	public FeatureModelWizard() {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		setWindowTitle("New Feature Model");
		newFileCreationPage = new DwFeatureModelWizardNewFileCreationPage("NewFileCreationPage", selection);
	}

	@Override
	public boolean performFinish() {
		try {
			IFile file = newFileCreationPage.getModelFile();
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();

			saveModel(file);
			selectFileInCurrentView(file, page);
			openFileInEditor(file, workbenchWindow, page);

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	protected void saveModel(final IFile file) throws InvocationTargetException, InterruptedException {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					EObject model = createInitialModel();
					EcoreIOUtil.saveModelAs(model, file);
				} finally {
					progressMonitor.done();
				}
			}
		};

		IWizardContainer container = getContainer();
		container.run(false, false, operation);
	}

	
	protected EObject createInitialModel() {
		HyFeatureModel featureModel = HyFeatureFactory.eINSTANCE.createHyFeatureModel();
		
		HyFeature rootFeatureFeature = HyFeatureFactory.eINSTANCE.createHyFeature();
		HyName featureName = HyEvolutionFactory.eINSTANCE.createHyName();
		featureName.setName("RootFeature");
		rootFeatureFeature.getNames().add(featureName);
		HyFeatureType featureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		featureType.setType(HyFeatureTypeEnum.MANDATORY);
		rootFeatureFeature.getTypes().add(featureType);
		
		HyRootFeature rootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
		rootFeature.setFeature(rootFeatureFeature);
		
		featureModel.getFeatures().add(rootFeatureFeature);
		featureModel.getRootFeature().add(rootFeature);
		
		return featureModel;
	}



	protected void selectFileInCurrentView(final IFile file, IWorkbenchPage page) {
		final IWorkbenchPart activePart = page.getActivePart();
		
		if (activePart instanceof ISetSelectionTarget) {
			final ISelection targetSelection = new StructuredSelection(file);
			Shell shell = getShell();
			Display display = shell.getDisplay();
			
			Runnable runnable = new Runnable() {
				 public void run() {
					 ISetSelectionTarget setSelectionTarget = (ISetSelectionTarget) activePart;
					 setSelectionTarget.selectReveal(targetSelection);
				 }
			};
			 
			display.asyncExec(runnable);
		}
	}
	


	protected void openFileInEditor(IFile file, IWorkbenchWindow workbenchWindow, IWorkbenchPage page) throws PartInitException{
		IEditorRegistry editorRegistry = workbench.getEditorRegistry();
		FileEditorInput fileEditorInput = new FileEditorInput(file);
		
		IPath filePath = file.getFullPath();
		String filePathString = filePath.toString();
		
		IEditorDescriptor defaultEditor = editorRegistry.getDefaultEditor(filePathString);
		String defaultEditorId = defaultEditor.getId();
		
		page.openEditor(fileEditorInput, defaultEditorId);					 	 

//		Shell shell = workbenchWindow.getShell();
//		String title = "Error";
//		String message = exception.getMessage();
//		MessageDialog.openError(shell, title, message);
	}
	
	@Override
	public void addPages() {
		addPage(newFileCreationPage);
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = "FeatureModel";
					String defaultModelFilenameExtension = HyFeatureUtil.getFeatureModelFileExtensionForXmi();
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
	}

}
