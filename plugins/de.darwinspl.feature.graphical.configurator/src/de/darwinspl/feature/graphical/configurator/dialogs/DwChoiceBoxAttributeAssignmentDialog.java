package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.christophseidl.util.java.CollectionsUtil;
import eu.hyvar.evolution.HyTemporalElement;


public class DwChoiceBoxAttributeAssignmentDialog extends Dialog {

	
	 /**
     * The title of the dialog.
     */
    private String title;

    /**
     * The message to display, or <code>null</code> if none.
     */
    private String message;

    /**
     * The input value; the empty string by default.
     */
    private String value;

    /**
     * The input validator, or <code>null</code> if none.
     */
    private IInputValidator validator;

    /**
     * Ok button widget.
     */
    private Button okButton;
    
    private Combo combo;

    /**
     * Input text widget.
     */
    private Text text;

    /**
     * Error message label widget.
     */
    private Text errorMessageText;

    /**
     * Error message string.
     */
    private String errorMessage;
    
    private String[] values;

	
	public DwChoiceBoxAttributeAssignmentDialog(Shell parentShell, String dialogTitle,
            String dialogMessage, String initialValue, String[] values) {
        super(parentShell);
        this.title = dialogTitle;
        message = dialogMessage;
        if (initialValue != null) {
        	value = initialValue;
        	
		} 
        this.values=values;
	}
	  @Override
		protected void buttonPressed(int buttonId) {
	        if (buttonId == IDialogConstants.OK_ID) {
	            value = combo.getItem(combo.getSelectionIndex());
	            		
	        } else {
	            value = null;
	        }
	        super.buttonPressed(buttonId);
	    }

	    @Override
		protected void configureShell(Shell shell) {
	        super.configureShell(shell);
	        if (title != null) {
				shell.setText(title);
			}
	    }

	    @Override
		protected void createButtonsForButtonBar(Composite parent) {
	        // create OK and Cancel buttons by default
	        okButton = createButton(parent, IDialogConstants.OK_ID,
	                IDialogConstants.OK_LABEL, true);
	        createButton(parent, IDialogConstants.CANCEL_ID,
	                IDialogConstants.CANCEL_LABEL, false);
	        //do this here because setting the text will set enablement on the ok
	        // button
	        combo.setFocus();
	        if (value != null) {
	        	combo.select(getIndexOfItem(value));
//	        	combo.setText(value);
	        	
	        }
	    }
	    
	    public int getIndexOfItem(String item){
	    	int i=0;
	    	for(i=0; i<combo.getItems().length; i++){
	    		if(combo.getItem(i).equals(item)){
	    			return i;
	    		}
	    		
	    		
	    		
	    	}
	    	return 0;
	    }

	    @Override
		protected Control createDialogArea(Composite parent) {
	        // create composite
	        Composite composite = (Composite) super.createDialogArea(parent);
	        // create message
	        if (message != null) {
	            Label label = new Label(composite, SWT.WRAP);
	            label.setText(message);
	            GridData data = new GridData(GridData.GRAB_HORIZONTAL
	                    | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL
	                    | GridData.VERTICAL_ALIGN_CENTER);
	            data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
	            label.setLayoutData(data);
	            label.setFont(parent.getFont());
	        }
	        
	        combo = new Combo(composite, SWT.DROP_DOWN);
	        combo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
	                | GridData.HORIZONTAL_ALIGN_FILL));
	        
	        combo.setItems(values);	       

	        applyDialogFont(composite);
	        return composite;
	    }

	    /**
	     * Returns the error message label.
	     *
	     * @return the error message label
	     * @deprecated use setErrorMessage(String) instead
	     */
	    @Deprecated
		protected Label getErrorMessageLabel() {
	        return null;
	    }

	    /**
	     * Returns the ok button.
	     *
	     * @return the ok button
	     */
	    protected Button getOkButton() {
	        return okButton;
	    }



	    /**
	     * Returns the string typed into this input dialog.
	     *
	     * @return the input string
	     */
	    public String getValue() {
	        return value;
	    }

	 


		/**
		 * Returns the style bits that should be used for the input text field.
		 * Defaults to a single line entry. Subclasses may override.
		 *
		 * @return the integer style bits that should be used when creating the
		 *         input text
		 *
		 * @since 3.4
		 */
		protected int getInputTextStyle() {
			return SWT.SINGLE | SWT.BORDER;
		}
	}

