package de.darwinspl.feature.stage.editor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.feature.stage.StageFactory;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;

public class RoleCreationDialog extends Dialog {
	
	protected StageModelWrapped stageModelWrapped;
	
	protected Composite roleButtonGroup;
	
	protected Button createRoleButton;
	protected Button cancelButton;
	
	protected Text editField;
	
	protected Label infoText;
	
	protected Composite buttonGroup;
	
	

	public RoleCreationDialog(Shell parentShell, StageModelWrapped stageModelWrapped) {
		super(parentShell);
		this.stageModelWrapped = stageModelWrapped;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;	
	    container.setLayout(layout);
	    
	    
	    infoText = new Label(container, SWT.NONE);
	    infoText.setText("Please enter a Name for new Role");	    
	    
	    editField = new Text(container, SWT.BORDER);
	    
	    buttonGroup = new Composite(container,SWT.NONE);
	    buttonGroup.setLayout(new RowLayout());
	    
	    createRoleButton = new Button(buttonGroup, SWT.PUSH);
	    createRoleButton.setText("create");
	    
	    cancelButton = new Button(buttonGroup, SWT.PUSH);
	    cancelButton.setText("cancel");
	    
	    
	    // Register Listeners
	    createRoleButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				stageModelWrapped.addNewRoleToModel(editField.getText());
				close();
			}	    	
	    });
	    
	    cancelButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				close();
			}
	    	
	    });
	    
	    return container;
	}

	/**
	 * Removing auto generated Buttons from dialog
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent)
	{ 
	  GridLayout layout = (GridLayout)parent.getLayout();
	  layout.marginHeight = 0;
	}
	
	/**
	 * Sets Dialog Caption
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Create Role");
	}
	
	
	
}
