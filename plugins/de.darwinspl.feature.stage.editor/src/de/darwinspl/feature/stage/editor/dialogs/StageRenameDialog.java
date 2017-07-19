package de.darwinspl.feature.stage.editor.dialogs;

import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.feature.stage.Role;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;

public class StageRenameDialog extends Dialog {
	
	protected StageModelWrapped stageModelWrapped;
	protected Date currentSelectedDate;
	protected Stage currentSelectedStage;
	
	protected Composite stageButtonGroup;
	
	protected Button renameButton;
	protected Button cancelButton;
	
	protected Text editField;
	
	protected Label infoText;
	
	protected Composite buttonGroup;
	
	
	public StageRenameDialog(Shell parentShell, StageModelWrapped stageModelWrapped, Date currentSelectedDate, Stage currentSelectedStage) {
		super(parentShell);
		this.stageModelWrapped = stageModelWrapped;
		this.currentSelectedDate = currentSelectedDate;
		this.currentSelectedStage = currentSelectedStage;
		
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;	
	    container.setLayout(layout);
	    
	    
	    infoText = new Label(container, SWT.NONE);
	    infoText.setText("Please enter a new name for the selected stage");	    
	    
	    editField = new Text(container, SWT.BORDER);
	    
	    buttonGroup = new Composite(container,SWT.NONE);
	    buttonGroup.setLayout(new RowLayout());
	    
	    renameButton = new Button(buttonGroup, SWT.PUSH);
	    renameButton.setText("Rename");
	    
	    cancelButton = new Button(buttonGroup, SWT.PUSH);
	    cancelButton.setText("Cancel");
	    
	    
	    // Register Listeners
	    renameButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
								
				for (Stage currentStage : stageModelWrapped.getModel().getStages()) {
					HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(),currentSelectedDate);
					if(currentName.getName().equals(editField.getText())){
						System.out.println("Name already exists at this date");
						return;
					}
				}			
				stageModelWrapped.addNewNameToStage(editField.getText(), currentSelectedDate, currentSelectedStage);
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
	 * Sets stage Creation Dialog Caption
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Rename stage");
	}
	
	
	
}
