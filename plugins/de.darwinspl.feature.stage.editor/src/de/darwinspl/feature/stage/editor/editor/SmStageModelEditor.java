package de.darwinspl.feature.stage.editor.editor;


import java.io.IOException;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.stage.StageModel;
import de.darwinspl.feature.stage.StagePackage;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;
import de.darwinspl.feature.stage.editor.dialogs.StageDialog;
import de.darwinspl.feature.stage.editor.wizard.StageModelWizard;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeaturePackage;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;
import eu.hyvar.feature.util.HyFeatureUtil;



public class SmStageModelEditor extends HyGraphicalFeatureModelEditor {
	
	protected Combo stageCombo;
	protected Button stageAssignButton;
	protected Button stageManagementButton;
	protected Composite comboGroup;
	
	protected StageModelWrapped stageModelWrapped;
	
	// Functions that have to be overwritten to allow Stage model loading	
	
	/**
	 * Load the feature model from a given file
	 * @param file
	 */
	protected void loadFeatureModelFromFile(IFile file){		
		modelWrapped = new HyFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(file));
		
		setCurrentSelectedDateToMostActualDate();
		
		setEditorTabText(file.getName());
		
		DwFeatureModelLayoutFileUtil.loadLayoutFile(modelWrapped);
	}
	
	/**
	 * Load the stage Model from a given URI
	 * @param file
	 */
	protected void loadStageModelFromURI (URI modelURI){		
		stageModelWrapped = new StageModelWrapped((StageModel)EcoreIOUtil.loadModel(modelURI));
		
	}
	
	
	/**
	 * 
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		Resource featureModelResource = this.modelWrapped.getModel().eResource();
		
		
		
		if(featureModelResource == null) return;

		try{
			DwFeatureModelLayoutFileUtil.saveLayout(modelWrapped);

			featureModelResource.save(null);
			getFile().touch(null);
			getCommandStack().markSaveLocation();


		}catch(IOException e){
			e.printStackTrace();
			featureModelResource = null;
		}catch(CoreException e){
			e.printStackTrace();
		}		
		
		if(stageModelWrapped == null) return;
		Resource stageModelResource = this.stageModelWrapped.getModel().eResource();
		try{			
			stageModelResource.save(null);
			getFile().touch(null);
			getCommandStack().markSaveLocation();
		}catch(IOException e){
			e.printStackTrace();
			featureModelResource = null;
		}catch(CoreException e){
			e.printStackTrace();
		}
	}
	
	
//	
//	/**
//	 * Extracts the file which correspond to the current editor instance and
//	 * loads the underlying feature model saved in that file. This method is called
//	 * during initialising the editor.
//	 */
//	protected void setInput(IEditorInput input) {
//		super.setInput(input);
//		loadModelFromFile(((IFileEditorInput) input).getFile());
//	}
//	
	
	/**
	 * New Init
	 */
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		StagePackage.eINSTANCE.eClass();
		if(input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			String fileExtension  = fileInput.getFile().getFileExtension() ;
			if(fileExtension.equals(HyFeatureUtil.getFeatureModelFileExtensionForXmi())){
				// URI to load the Model
				URI featureModelURI = modelWrapped.getModel().eResource().getURI();
				URI stageModelURI = featureModelURI.trimFileExtension().appendFileExtension("staged");				
				// File to check if Model exists
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot workspaceRoot = workspace.getRoot();				
				IFile file = workspaceRoot.getFile(getPathToEditorRelatedFileWithFileExtension("staged"));
				if(file.exists()){
					loadStageModelFromURI(stageModelURI);	
				}
				
			}

		}
	}	
	
	
	// GUI for the Editor folows here:
	/**
	 * Creation of the Buttons/Combobox for Stage control in the editor
	 */
	public void createStageControl(Composite parent){
		//Groups for positioning
		buttonGroup = new Composite(parent,SWT.NONE);
		RowLayout rowLayout = new RowLayout (SWT.HORIZONTAL);
		rowLayout.justify = true;
		buttonGroup.setLayout(rowLayout);		
		comboGroup = new Composite(buttonGroup, SWT.NONE);
		RowLayout columnLayout = new RowLayout(SWT.VERTICAL);	
		columnLayout.justify = true;
		comboGroup.setLayout(columnLayout);
		
		
		// Combo box for stage Selection
		stageCombo = new Combo(comboGroup, SWT.NONE);		
		//Example;
		String items[] = { "Stage One", "Stage Two"};
		stageCombo.setItems(items);
		
		//Button for Stage Management, Creation/Deletion
		stageManagementButton = new Button (comboGroup, SWT.NONE);
		stageManagementButton.setText("Manage Stages/Roles");
		
		
		//Button for Assignment
		stageAssignButton = new Button(buttonGroup, SWT.TOGGLE);
		stageAssignButton.setText("Assign Stage");
		
		
	}
	
	
	
	/**
	 * New Listener for Stage Buttons
	 */
	public void registerStageControlListeners(){
		// Left button to select an individual date
		stageManagementButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event){
				if(stageModelWrapped == null){
					// Show initialization wizard the first time the button is pressed
					IWorkbench workbench =  PlatformUI.getWorkbench();
					WizardDialog dialog = new WizardDialog(getEditorSite().getShell(), new StageModelWizard(modelWrapped,workbench));
					
					if(dialog.open() == Window.OK){
						URI featureModelURI = modelWrapped.getModel().eResource().getURI();
						URI stageModelURI = featureModelURI.trimFileExtension().appendFileExtension("staged");
						loadStageModelFromURI(stageModelURI);

					} else {
						System.out.print("canceled creation");
						return;
					}
					
				}
				StageDialog stageDialog = new StageDialog(getEditorSite().getShell());
				stageDialog.open();
				if(stageDialog.getReturnCode()==0){					
				
				}
			}
		});

	}
	
	
	/** Function to overwrite from DwGraphicalFeatureModelViewer
	 *  This function adds everything to the layout
	 */
	public void createPartControl(Composite parent){
		parent.setLayout(new GridLayout(2, false));
		createEditor(parent);
		createSliderControl(parent);
		// ##### New Create ######
		createStageControl(parent);
		
		registerControlListeners();
		registerStageControlListeners();
		((HyFeatureModelEditPart)getGraphicalViewer().getContents()).refresh();
	}	


}
