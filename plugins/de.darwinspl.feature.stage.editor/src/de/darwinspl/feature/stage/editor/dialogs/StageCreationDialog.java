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
import de.darwinspl.feature.stage.StageOrder;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;

public class StageCreationDialog extends Dialog {
	
	protected StageModelWrapped stageModelWrapped;
	protected Date currentSelectedDate;
	
	protected Composite stageButtonGroup;
	
	protected Button createStageButton;
	protected Button cancelButton;
	
	protected Text editField;
	
	protected Label infoText;
	
	protected Composite buttonGroup;
	
	public StageCreationDialog(Shell parentShell, StageModelWrapped stageModelWrapped, Date currentSelectedDate) {
		super(parentShell);
		this.stageModelWrapped = stageModelWrapped;
		this.currentSelectedDate = currentSelectedDate;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;	
	    container.setLayout(layout);
	    
	    
	    infoText = new Label(container, SWT.NONE);
	    infoText.setText("Please enter a Name for new Stage");	    
	    
	    editField = new Text(container, SWT.BORDER);
	    
	    buttonGroup = new Composite(container,SWT.NONE);
	    buttonGroup.setLayout(new RowLayout());
	    
	    createStageButton = new Button(buttonGroup, SWT.PUSH);
	    createStageButton.setText("Create");
	    
	    cancelButton = new Button(buttonGroup, SWT.PUSH);
	    cancelButton.setText("Cancel");
	    
	    
	    // Register Listeners
	    createStageButton.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event) {
				
				StageOrder currentStageOrder = HyEvolutionUtil.getValidTemporalElement(stageModelWrapped.getModel().getStageOrder(), currentSelectedDate);
				if(currentStageOrder != null){
					for (Stage currentStage : currentStageOrder.getStages()) {
						if(HyEvolutionUtil.isValid(currentStage, currentSelectedDate)){
							HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(),currentSelectedDate);
							if(currentName.getName().equals(editField.getText())){
								System.out.println("stage already exists");
								return;
							}
						}
					}
				}
				stageModelWrapped.addNewStageToModel(editField.getText(), currentSelectedDate);
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
		newShell.setText("Create Stage");
	}
	
	
	
}
