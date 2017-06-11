package de.darwinspl.feature.stage.editor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
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
import org.eclipse.swt.widgets.Shell;

public class StageDialog extends Dialog implements Listener{
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

	
	public StageDialog(Shell parentShell) {
		super(parentShell);
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
	    List stageList = new List(stageGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    stageList.setLayoutData(new GridData());
	    List roleList = new List(roleGroup, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
	    roleList.setLayoutData(new GridData());
	    
	     // TODO Alex: Replace with a function that gets the names of the existing stages
	    for (int loopIndex = 0; loopIndex < 10; loopIndex++) {
	        stageList.add("Stage " + loopIndex);
	        roleList.add("Role " + loopIndex);
	      }	   
	    
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


	    container.pack();
		return container;
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
	}		

}
