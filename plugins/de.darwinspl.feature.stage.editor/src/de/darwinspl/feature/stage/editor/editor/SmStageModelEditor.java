package de.darwinspl.feature.stage.editor.editor;


import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageModel;
import de.darwinspl.feature.stage.StagePackage;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;
import de.darwinspl.feature.stage.editor.dialogs.StageDialog;
import de.darwinspl.feature.stage.editor.wizard.StageModelWizard;
import eu.hyvar.feature.HyFeatureModel;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureModelEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import de.darwinspl.feature.graphical.editor.editparts.DwFeatureEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwGroupEditorEditPart;
import eu.hyvar.feature.util.HyFeatureUtil;



public class SmStageModelEditor extends DwGraphicalFeatureModelEditor {
	
	protected Group stageGroup;
	protected Combo stageCombo;
	protected Button stageAssignButton;
	protected Button stageManagementButton;
	protected Button stageClearButton;
	protected Composite comboGroup;
	
	protected StageModelWrapped stageModelWrapped;
	protected Stage selectedStage;
	
	// Functions that have to be overwritten to allow Stage model loading	
	
	/**
	 * Load the feature model from a given file
	 * @param file
	 */
	protected void loadFeatureModelFromFile(IFile file){		
		modelWrapped = new DwFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(file));
		
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
	 * Save Method for Stage Model and Feature Model
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		Resource featureModelResource = this.modelWrapped.getModel().eResource();		
		// Feature Model Part
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
		// Stage Model Part
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
	
	
	/**
	 * Init Method that loads the StageModel in the Editor Workspace
	 */
	@Override
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
		// Group Around the Components of the Stage Extension
		GridData gridData = new GridData();
		stageGroup = new Group(parent, SWT.NONE);
	    stageGroup.setLayout(new GridLayout( 1, false ));
	    stageGroup.setLayoutData(gridData);
	    stageGroup.setText("Stage Model");
	    
		//Groups for positioning inside the Group
		buttonGroup = new Composite(stageGroup,SWT.NONE);
		RowLayout rowLayout = new RowLayout (SWT.HORIZONTAL);
		rowLayout.justify = true;
		buttonGroup.setLayout(rowLayout);		
		comboGroup = new Composite(buttonGroup, SWT.NONE);
		RowLayout columnLayout = new RowLayout(SWT.VERTICAL);	
		columnLayout.justify = true;
		comboGroup.setLayout(columnLayout);
		
		
		// Combo box for stage Selection
		stageCombo = new Combo(comboGroup, SWT.NONE);
		
		//Button for Stage Management, Creation/Deletion
		stageManagementButton = new Button (comboGroup, SWT.NONE);
		stageManagementButton.setText("Manage Stages/Roles");
		
		
		//Button for Assignment
		stageAssignButton = new Button(buttonGroup, SWT.NONE);
		stageAssignButton.setText("Assign Stage");
		
		//Button to remove Features from stage
		stageClearButton = new Button(buttonGroup, SWT.NONE);
		stageClearButton.setText("Clear Stages");
		
		
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
					dialog.setPageSize(25,10);
					if(dialog.open() == Window.OK){
						URI featureModelURI = modelWrapped.getModel().eResource().getURI();
						URI stageModelURI = featureModelURI.trimFileExtension().appendFileExtension("staged");
						loadStageModelFromURI(stageModelURI);

					} else {
						System.out.print("canceled creation");
						return;
					}
					
				}
				StageDialog stageDialog = new StageDialog(getEditorSite().getShell(), stageModelWrapped);
				stageDialog.open();
				if(stageDialog.getReturnCode()==0){					
				
				}
				updateComboBox();
			}
		});

	}
	
	/**
	 * Listener for the combo Box to get the currently selected stage
	 */
	public void registerStageComboListener(){
		stageCombo.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedItem = stageCombo.getSelectionIndex();
				selectedStage = stageModelWrapped.getModel().getStages().get(selectedItem);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});
	}
	
	/**
	 * Listener for the Assignment Button to assign selected Features to Stage
	 */
	//TODO Alex: Replace 0 Index with appropriate index depending on date
	public void registerAssignmentListener(){
		stageAssignButton.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {				
				
				StructuredSelection currentSelection=  (StructuredSelection) getEditorSite().getSelectionProvider().getSelection();
				// current Selection as List
				@SuppressWarnings("unchecked")
				List<Object> selectionList = currentSelection.toList();
				
				DwFeatureEditPart currentFeatureEditPart;
				DwFeatureWrapped currentWrappedFeature;
				
				DwGroupEditPart currentGroupEditPart;
				DwGroupWrapped currentWrappedGroup;
				
				// Iterating over all selected Elements and Adding them to the Stage when they are features
				for(int i = 0; i< currentSelection.size(); i++){
					// Features
					if(selectionList.get(i) instanceof DwFeatureEditorEditPart ){
						currentFeatureEditPart = (DwFeatureEditPart)selectionList.get(i);
						currentWrappedFeature = (DwFeatureWrapped) currentFeatureEditPart.getModel();					
						selectedStage.getComposition().get(0).getFeatures().add(currentWrappedFeature.getWrappedModelElement());
					}
					// Groups
					else if (selectionList.get(i) instanceof DwGroupEditorEditPart){
						currentGroupEditPart = (DwGroupEditPart)selectionList.get(i);
						currentWrappedGroup = (DwGroupWrapped) currentGroupEditPart.getModel();
						selectedStage.getComposition().get(0).getGroups().add(currentWrappedGroup.getWrappedModelElement());
					}
				}				
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});
	}
	
	/**
	 * Listener for Removal of Features from Stage
	 */
	//TODO Alex: Replace 0 Index with appropriate index depending on date
		public void registerFeatureRemovalListener(){
			stageAssignButton.addSelectionListener(new SelectionListener(){
				@Override
				public void widgetSelected(SelectionEvent e) {				
					
					StructuredSelection currentSelection=  (StructuredSelection) getEditorSite().getSelectionProvider().getSelection();
					// current Selection as List
					@SuppressWarnings("unchecked")
					List<Object> selectionList = currentSelection.toList();
					
					DwFeatureEditPart currentFeatureEditPart;
					DwFeatureWrapped currentWrappedFeature;
					
					DwGroupEditPart currentGroupEditPart;
					DwGroupWrapped currentWrappedGroup;
					
					// Iterating over all selected Elements and Adding them to the Stage when they are features
					for(int i = 0; i< currentSelection.size(); i++){
						// Features
						if(selectionList.get(i) instanceof DwFeatureEditorEditPart ){
							currentFeatureEditPart = (DwFeatureEditPart)selectionList.get(i);
							currentWrappedFeature = (DwFeatureWrapped) currentFeatureEditPart.getModel();					
							selectedStage.getComposition().get(0).getFeatures().remove(currentWrappedFeature.getWrappedModelElement());
						}
						// Groups
						else if (selectionList.get(i) instanceof DwGroupEditorEditPart){
							currentGroupEditPart = (DwGroupEditPart)selectionList.get(i);
							currentWrappedGroup = (DwGroupWrapped) currentGroupEditPart.getModel();
							selectedStage.getComposition().get(0).getGroups().remove(currentWrappedGroup.getWrappedModelElement());
						}
					}				
					
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
				
			});
		}
	
	
	/**
	 * Update Function for the Stage Combo Box
	 */
	public void updateComboBox(){
		if(stageModelWrapped != null){
			
			stageCombo.removeAll();
			
			for (Stage currentStage : stageModelWrapped.getModel().getStages()) {			
				String currentStageName = currentStage.getNames().get(0).getName();
				stageCombo.add(currentStageName);
				stageCombo.pack();
				stageGroup.pack();
				stageCombo.redraw();
				
				
	      }	   
		}
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
		registerStageComboListener();
		registerAssignmentListener();
		registerFeatureRemovalListener();
		//refresh
		updateComboBox();
		((DwFeatureModelEditPart)getGraphicalViewer().getContents()).refresh();
	}	


}
