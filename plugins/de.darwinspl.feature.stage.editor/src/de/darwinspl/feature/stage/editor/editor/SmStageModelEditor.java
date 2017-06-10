package de.darwinspl.feature.stage.editor.editor;


import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.darwinspl.feature.stage.editor.dialogs.StageDialog;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;



public class SmStageModelEditor extends HyGraphicalFeatureModelEditor {
	
	protected Combo stageCombo;
	protected Button stageAssignButton;
	protected Button stageManagementButton;
	protected Composite comboGroup;
	
	
	
	
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
				StageDialog dialog = new StageDialog(getEditorSite().getShell());
				dialog.open();
				if(dialog.getReturnCode()==0){					
				
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
