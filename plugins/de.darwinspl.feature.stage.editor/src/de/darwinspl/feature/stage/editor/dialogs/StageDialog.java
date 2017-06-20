package de.darwinspl.feature.stage.editor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;

/**
 * Dialog to manage Stages and Roles
 * @author Informatik
 *
 */
public class StageDialog extends Dialog implements Listener{
	// The current Model
	protected StageModelWrapped stageModelWrapped;
	// Selected Stage Reference
	protected Stage selectedStage; 
	
	// TODO Alex: Replace List with colored Table to improve readability
	protected Composite stageButtonGroup;
	protected Composite roleButtonGroup;
	
	protected Group stageGroup;
	protected Group roleGroup;
	
	protected Button addStageButton;
	protected Button deleteStageButton;
	protected Button assignRoleButton;
	protected Button addRoleButton;
	protected Button deleteRoleButton;

	protected List stageList;
	protected List roleList;
	
	
	
	/**
	 * Stage Dialog
	 * @param parentShell
	 * @param stageModel current Stage Model
	 */
	public StageDialog(Shell parentShell, StageModelWrapped stageModel) {
		super(parentShell);
		this.stageModelWrapped = stageModel;		
	}

	@Override
	protected boolean isResizable() {
	    return true;
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		//Grid Layout for area
		Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout layout = new GridLayout(4, true);
	    GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
	    container.setLayout(layout);
	    
	    //Groups
	    stageGroup = new Group(container, SWT.NONE);
	    stageGroup.setLayout(new GridLayout( 1, false ));
	    stageGroup.setLayoutData(gridData);
	    stageGroup.setText("Stages");
	    
	    roleGroup = new Group(container,SWT.NONE);
	    roleGroup.setLayoutData(gridData);
	    roleGroup.setText("Roles");
	    roleGroup.setLayout(new GridLayout( 1, false ));
	    
	    // Lists for Stages / Roles	    
	    stageList = new List(stageGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    stageList.setLayoutData(new GridData());
	    roleList = new List(roleGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    roleList.setLayoutData(new GridData());
	    
	     // TODO Alex: Replace with a function that gets the names of the existing stages
//	    for (int loopIndex = 0; loopIndex < 10; loopIndex++) {
//	        stageList.add("Stage " + loopIndex);
//	        roleList.add("Role " + loopIndex);
//	      }	   
	    
	    // Stage Button Group
	    stageButtonGroup = new Composite(stageGroup,SWT.NONE);
		RowLayout rowLayout = new RowLayout (SWT.HORIZONTAL);
		rowLayout.justify = true;
		stageButtonGroup.setLayout(rowLayout);			
		
		//Role Button Group
	    roleButtonGroup = new Composite(roleGroup, SWT.NONE);
	    roleButtonGroup.setLayout(rowLayout);	    
   
	    // Buttons for stage management
	    addStageButton = new Button (stageButtonGroup, SWT.NONE);
		addStageButton.setText("Add");
		deleteStageButton = new Button (stageButtonGroup, SWT.NONE);
		deleteStageButton.setText("Delete");
		
		// Buttons for role management
		addRoleButton = new Button (roleButtonGroup, SWT.NONE);
		addRoleButton.setText("Add");
		deleteRoleButton = new Button (roleButtonGroup, SWT.NONE);
		deleteRoleButton.setText("Delete");
		assignRoleButton = new Button (roleButtonGroup, SWT.NONE);
		assignRoleButton.setText("Assign");   
		

		// Add Listeners 
		addButtonListeners();
		addListListeners();
		
	    container.pack();
	    updateStageList();
		return container;
	}
	
	/**
	 * Adding Listeners for Current Selection
	 *  Sets references tp the currently selected Elements
	 */
	protected void addListListeners() {
		
		stageList.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectedItems = stageList.getSelectionIndices();
				// Setting the Reference to the currently selected Stage
				selectedStage = stageModelWrapped.getModel().getStages().get(selectedItems[0]);				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {			
			}			
		});
		
	}
	
	/**
	 * Adding Listeners for Creation/Deletion of ObjectEntities
	 */
	protected void addButtonListeners() {
		//Add Button Listeners
		addStageButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				StageCreationDialog stageCreationDialog = new StageCreationDialog(getShell(), stageModelWrapped);
				stageCreationDialog.open();
				updateStageList();
			}
			
		});
		
		deleteStageButton.addListener(SWT.Selection,new Listener(){
			public void handleEvent(Event event){
				String stageName = selectedStage.getNames().get(0).getName();
				MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
			    messageBox.setMessage("Do you really want to delete the Stage: " + stageName );
			    int response = messageBox.open();
			    if(response == SWT.YES){
			    	System.out.println("trying to delete the stage: " +stageName);
			    	stageModelWrapped.deleteStage(selectedStage);
			    	updateStageList();
			    }
			    
			}
		});
	}

	@Override
	  protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, "Finish", true);
//	    createButton(parent, IDialogConstants.CANCEL_ID,
//	        IDialogConstants.CANCEL_LABEL, false);
	  }	
	
	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Stage/Role Management");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(400, 340);
	}

	@Override
	public void handleEvent(Event event) {
		updateStageList();
	}	
	
	/**
	 * Update Function for the Stage representation
	 */
	public void updateStageList(){
		stageList.removeAll();;
		for (Stage currentStage : stageModelWrapped.getModel().getStages()) {			
			String currentStageName = currentStage.getNames().get(0).getName();
			stageList.add(currentStageName);
			stageList.redraw();
			
      }	   
	}
	
	/**
	 * Update Function for Role representation
	 */
	public void updateRoleList(){
		
	}

}
