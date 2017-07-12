package de.darwinspl.feature.stage.editor.dialogs;

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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.feature.stage.Role;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;

public class RoleInclusionDialog extends Dialog {

	protected StageModelWrapped stageModelWrapped;	
	
	protected List roleList;
	protected List includedRolesList;
	protected List availableRolesList;
	
	protected Role selectedIncludedRole;
	protected Role selectedAvailableRole;
	protected Role selectedRole;
	
	protected Button includeButton;
	protected Button unincludeButton;
	
	protected Label roleLabel;
	protected Label includedRolesLabel;
	protected Label availableRolesLabel;	
	
	protected Composite roleGroup;
	protected Composite includedRolesGroup;
	protected Composite availableRolesGroup;	
	protected Composite assignmentArrowGroup;
	
	
	/**
	 * Role Assignment Dialog Constructor
	 * @param parentShell
	 */
	protected RoleInclusionDialog(Shell parentShell, StageModelWrapped stageModelWrapped) {
		super(parentShell);
		this.stageModelWrapped = stageModelWrapped; 
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
		
		includedRolesGroup = new Composite(container,SWT.NONE);
		includedRolesGroup.setLayout(gridLayout);
		includedRolesGroup.setLayoutData(gridData);
		
		
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		rowLayout.fill = true;
		rowLayout.spacing = 40;
		rowLayout.marginWidth = 10;
		assignmentArrowGroup  = new Composite(container,SWT.NONE);
		assignmentArrowGroup.setLayout(rowLayout);
		
		
		availableRolesGroup = new Composite(container,SWT.NONE);
		availableRolesGroup.setLayout(gridLayout);
		availableRolesGroup.setLayoutData(gridData);
				    
//		// Lists for Stages / Roles
		roleLabel = new Label(roleGroup, SWT.NONE);
		roleLabel.setText("Roles");
	    roleList = new List(roleGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    roleList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	     
	    includedRolesLabel = new Label(includedRolesGroup, SWT.NONE);
	    includedRolesLabel.setText("Included Roles");
	    includedRolesList = new List(includedRolesGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    includedRolesList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	    
	    
	    availableRolesLabel = new Label(availableRolesGroup, SWT.NONE);
	    availableRolesLabel.setText("Available Roles");
	    availableRolesList = new List(availableRolesGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    availableRolesList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	    
	    
	    RowData buttonData = new RowData(40,40);
	    includeButton = new Button(assignmentArrowGroup, SWT.ARROW|SWT.LEFT|SWT.FILL);
	    includeButton.setLayoutData(buttonData);
	    
	    unincludeButton = new Button(assignmentArrowGroup, SWT.ARROW|SWT.RIGHT|SWT.FILL);
	    unincludeButton.setLayoutData(buttonData);

	    
	    // Add Listeners 
		addArrowListeners();
		addListSelectionListeners();

	    updateRoleList();
	    updateIncludedRolesList();
	    updateAvailableRolesList();
	    

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
				updateIncludedRolesList();
				updateAvailableRolesList();				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				roleList.deselectAll();
			}			
		});
		
		
		// Assigned Stages Selection
		includedRolesList.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectedItems = includedRolesList.getSelectionIndices();
				
				if(selectedItems.length > 0){					
					String listString = includedRolesList.getItem(selectedItems[0]);	
					
					// For Loops Checks for Existing Name (Have to be unqiue)
					for(Role currentRole: stageModelWrapped.getModel().getRoles()){
						if(currentRole.getNames().get(0).getName().equals(listString)){
							selectedIncludedRole = currentRole;
						}
						
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				includedRolesList.deselectAll();
			}			
		});
		
		// Available Stages Selection
		availableRolesList.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectedItems = availableRolesList.getSelectionIndices();
				
				if(selectedItems.length > 0){					
					String listString = availableRolesList.getItem(selectedItems[0]);	
					
					// For Loops Checks for Existing Name (Have to be unqiue)
					for(Role currentRole: stageModelWrapped.getModel().getRoles()){
						if(currentRole.getNames().get(0).getName().equals(listString)){
							selectedAvailableRole = currentRole;
						}
						
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				availableRolesList.deselectAll();
			}			
		});
		
		
	}
	
	/**
	 * Adding Arrow Button Listeners
	 */
	protected void addArrowListeners() {		
		//	Include Role
		includeButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				stageModelWrapped.includeRole(selectedRole,selectedAvailableRole);
				
				updateIncludedRolesList();
				updateAvailableRolesList();
				updateRoleList();
			}
			
		});	
		
		// Uninclude Role
		unincludeButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				stageModelWrapped.unincludeRole(selectedRole,selectedIncludedRole);
				
				updateIncludedRolesList();
				updateAvailableRolesList();
				updateRoleList();
			}
			
		});	
		
	}
	
	
	
	
	/**
	 * Update List of Assigned Stages depending on selected Role
	 */
	public void updateIncludedRolesList(){
		includedRolesList.removeAll();;
		for (Role currentRole : stageModelWrapped.getModel().getRoles()) {
			
			if(selectedRole != null && selectedRole.getInclusions().get(0).getIncludes().contains(currentRole)){
				String currentRoleName = currentRole.getNames().get(0).getName();
				includedRolesList.add(currentRoleName);
			}

			includedRolesList.redraw();	
			
      }	   
	}
	
	
	/**
	 *  Update List of Available Stages
	 */
	public void updateAvailableRolesList(){
		availableRolesList.removeAll();;
		for (Role currentRole : stageModelWrapped.getModel().getRoles()) {	
			String currentRoleName = currentRole.getNames().get(0).getName();
			boolean exists = false;
			for(String str: includedRolesList.getItems()){
				if(str.equals(currentRoleName)){
					exists = true;
				}
			}
			if(!exists && currentRole != selectedRole){
				availableRolesList.add(currentRoleName);
			}

			availableRolesList.redraw();	
			
      }	   
	}
	
	
	/**
	 * Update Function for Role representation
	 */
	public void updateRoleList(){
		roleList.removeAll();;
		for (Role currentRole : stageModelWrapped.getModel().getRoles()) {			
			String currentRoleName = currentRole.getNames().get(0).getName(); 
			roleList.add(currentRoleName);
			
			roleList.redraw();
			
      }	  
		
	}
	
	/**
	 * Sets role inclusion dialog caption
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Role Inclusion");
	}
	
	/**
	 * Sets Initial Size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(480, 300);
	}
	
	@Override
	protected boolean isResizable() {
	    return true;
	}


}
