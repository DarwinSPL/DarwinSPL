package de.darwinspl.feature.stage.editor.dialogs;

import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.feature.stage.Role;
import de.darwinspl.feature.stage.RoleAssignment;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;

public class RoleAssignmentDialog extends Dialog {

	protected StageModelWrapped stageModelWrapped;
	protected Date currentSelectedDate;
	
	protected org.eclipse.swt.widgets.List roleList;
	protected org.eclipse.swt.widgets.List assignedStagesList;
	protected org.eclipse.swt.widgets.List availableStagesList;
	
	protected Stage selectedAssignedStage;
	protected Stage selectedAvailableStage;
	protected Role selectedRole;
	
	protected Button assignButton;
	protected Button unassignButton;
	
	protected Label roleLabel;
	protected Label assignedStagesLabel;
	protected Label availableStagesLabel;	
	
	protected Composite roleGroup;
	protected Composite assignedStagesGroup;
	protected Composite availableStagesGroup;	
	protected Composite assignmentArrowGroup;
	
	
	/**
	 * Role Assignment Dialog Constructor
	 * @param parentShell
	 */
	protected RoleAssignmentDialog(Shell parentShell, StageModelWrapped stageModelWrapped, Date currentSelectedDate) {
		super(parentShell);
		this.stageModelWrapped = stageModelWrapped;
		this.currentSelectedDate = currentSelectedDate;
	}

	/**
	 * Creates Dialog area and places all SWT Widgets for Role Assignment
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);	
		
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout mainGridLayout = new GridLayout(4, false);	    
	    container.setLayout(mainGridLayout);  	    
	    
	    GridData gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
	    
	    
//		RowLayout rowLayout = new RowLayout (SWT.VERTICAL);
//		rowLayout.justify = true;

	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    
	    roleGroup = new Composite(container,SWT.NONE);
		roleGroup.setLayout(gridLayout);	
		roleGroup.setLayoutData(gridData);
		
		assignedStagesGroup = new Composite(container,SWT.NONE);
		assignedStagesGroup.setLayout(gridLayout);
		assignedStagesGroup.setLayoutData(gridData);
		
		
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		rowLayout.fill = true;
		rowLayout.spacing = 40;
		rowLayout.marginWidth = 10;
		assignmentArrowGroup  = new Composite(container,SWT.NONE);
		assignmentArrowGroup.setLayout(rowLayout);
		
		
		availableStagesGroup = new Composite(container,SWT.NONE);
		availableStagesGroup.setLayout(gridLayout);
		availableStagesGroup.setLayoutData(gridData);
				    
//		// Lists for Stages / Roles
		roleLabel = new Label(roleGroup, SWT.NONE);
		roleLabel.setText("Roles");
	    roleList = new org.eclipse.swt.widgets.List(roleGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    roleList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	     
	    assignedStagesLabel = new Label(assignedStagesGroup, SWT.NONE);
	    assignedStagesLabel.setText("Assigned Stages");
	    assignedStagesList = new org.eclipse.swt.widgets.List(assignedStagesGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    assignedStagesList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	    
	    
	    availableStagesLabel = new Label(availableStagesGroup, SWT.NONE);
	    availableStagesLabel.setText("Available Stages");
	    availableStagesList = new org.eclipse.swt.widgets.List(availableStagesGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    availableStagesList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	    
	    
	    RowData buttonData = new RowData(40,40);
	    assignButton = new Button(assignmentArrowGroup, SWT.ARROW|SWT.LEFT|SWT.FILL);
	    assignButton.setLayoutData(buttonData);
	    
	    unassignButton = new Button(assignmentArrowGroup, SWT.ARROW|SWT.RIGHT|SWT.FILL);
	    unassignButton.setLayoutData(buttonData);

	    
	    // Add Listeners 
		addArrowListeners();
		addListSelectionListeners();

	    updateRoleList();
	    updateAssignedStagesList();
	    updateAvailableStagesList();
	    

		return container;
	}
	
	
	
	/**
	 * Adding Listeners for Current Selection
	 *  Sets references to the currently selected Elements
	 */
	protected void addListSelectionListeners() {
		// Role Selection
		roleList.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectedItems = roleList.getSelectionIndices();
				if(selectedItems.length > 0){
					selectedRole = stageModelWrapped.getModel().getRoles().get(selectedItems[0]);	
				}
				updateAssignedStagesList();
				updateAvailableStagesList();				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				roleList.deselectAll();
			}			
		});
		
		
		// Assigned Stages Selection
		assignedStagesList.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectedItems = assignedStagesList.getSelectionIndices();
				
				if(selectedItems.length > 0){					
					String listString = assignedStagesList.getItem(selectedItems[0]);	
					
					// For Loops Checks for Existing Name (Have to be unqiue)
					for(Stage currentStage: stageModelWrapped.getModel().getStages()){
						HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
						if(currentName.getName().equals(listString)){
							selectedAssignedStage = currentStage;
						}
						
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				assignedStagesList.deselectAll();
			}			
		});
		
		// Available Stages Selection
		availableStagesList.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectedItems = availableStagesList.getSelectionIndices();
				
				if(selectedItems.length > 0){					
					String listString = availableStagesList.getItem(selectedItems[0]);	
					
					// For Loops Checks for Existing Name (Have to be unqiue)
					for(Stage currentStage: stageModelWrapped.getModel().getStages()){
						HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
						if(currentName.getName().equals(listString)){
							selectedAvailableStage = currentStage;
						}
						
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				availableStagesList.deselectAll();
			}			
		});
		
		
	}
	
	/**
	 * Adding Arrow Button Listeners
	 */
	protected void addArrowListeners() {		
		//	Assign Role to Stage Button Listener
		assignButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				stageModelWrapped.assignRoleToStage(selectedRole,selectedAvailableStage, currentSelectedDate);
				
				updateAssignedStagesList();
				updateAvailableStagesList();
				updateRoleList();
			}
			
		});	
		
		// Unassign Role from Stage Button Listener
		unassignButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				stageModelWrapped.unassignRoleFromStage(selectedRole,selectedAssignedStage, currentSelectedDate);
				
				updateAssignedStagesList();
				updateAvailableStagesList();
				updateRoleList();
			}
			
		});	
		
	}
	
	
	
	
	/**
	 * Update List of Assigned Stages depending on selected Role
	 */
	public void updateAssignedStagesList(){
		assignedStagesList.removeAll();;
		for (Stage currentStage : stageModelWrapped.getModel().getStages()) {

			if(HyEvolutionUtil.isValid(currentStage, currentSelectedDate) && selectedRole!= null){				
				List<RoleAssignment> roleAssignment = HyEvolutionUtil.getValidTemporalElements(selectedRole.getAssignments(), currentSelectedDate);
				
				for(RoleAssignment currentAssignment : roleAssignment){
					if(currentAssignment.getStage().equals(currentStage)){
						HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
						String currentStageName = currentName.getName();
						assignedStagesList.add(currentStageName);						
					}
				}					

			}
			assignedStagesList.redraw();	
			
      }	   
	}
	
	
	/**
	 *  Update List of Available Stages
	 */
	public void updateAvailableStagesList(){
		availableStagesList.removeAll();;
		for (Stage currentStage : stageModelWrapped.getModel().getStages()) {
			if(HyEvolutionUtil.isValid(currentStage, currentSelectedDate)){
				HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
				String currentStageName = currentName.getName();
				boolean exists = false;
				for(String str: assignedStagesList.getItems()){
					if(str.equals(currentStageName)){
						exists = true;
					}
				}
				if(!exists){
					availableStagesList.add(currentStageName);
				}

				availableStagesList.redraw();	
			}			
			
      }	   
	}
	
	
	/**
	 * Update Function for Role representation
	 */
	public void updateRoleList(){
		roleList.removeAll();;
		for (Role currentRole : stageModelWrapped.getModel().getRoles()) {
			if(HyEvolutionUtil.isValid(currentRole, currentSelectedDate)){
				HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentRole.getNames(), currentSelectedDate);
				String currentRoleName = currentName.getName(); 
				roleList.add(currentRoleName);
				
				roleList.redraw();
			}			
      }	  
		
	}
	
	/**
	 * Sets stage Creation Dialog Caption
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Role Assignment");
	}
	
	/**
	 * Sets Initial Size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(480, 300);
	}
	
	/**
	 *  Sets window resizable
	 */
	@Override
	protected boolean isResizable() {
	    return true;
	}


}
