package de.darwinspl.feature.stage.editor.editor;


import java.util.Date;

import org.eclipse.core.resources.IFile;
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
import de.darwinspl.feature.stage.editor.dialogs.StageDialog;
import de.darwinspl.feature.stage.editor.wizard.StageModelWizard;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeaturePackage;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;



public class SmStageModelEditor extends HyGraphicalFeatureModelEditor {
	
	protected Combo stageCombo;
	protected Button stageAssignButton;
	protected Button stageManagementButton;
	protected Composite comboGroup;
	
	protected boolean isInitialized = false;
	
	// Functions that have to be overwritten to allow Stage model loading	
	
	/**
	 * Tries to load a staged feature model from a given file
	 * @param file
	 */
	protected void loadModelFromFile(IFile file){		
		modelWrapped = new HyFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(file));
		
		setCurrentSelectedDateToMostActualDate();
		
		setEditorTabText(file.getName());
		
		DwFeatureModelLayoutFileUtil.loadLayoutFile(modelWrapped);
	}
	
	/**
	 * Extracts the file which correspond to the current editor instance and
	 * loads the underlying feature model saved in that file. This method is called
	 * during initialising the editor.
	 */
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		loadModelFromFile(((IFileEditorInput) input).getFile());
	}
	
	/**
	 * New Init
	 */
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		StagePackage.eINSTANCE.eClass();
		if(input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			//loadModelFromFile(fileInput.getFile());
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
				if(isInitialized == false){
					// Show initialization wizard the first time the button is pressed
					IWorkbench workbench =  PlatformUI.getWorkbench();
					WizardDialog dialog = new WizardDialog(getEditorSite().getShell(), new StageModelWizard(modelWrapped,workbench));
					
					if(dialog.open() == Window.OK){
						isInitialized =true;
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
