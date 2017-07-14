package de.darwinspl.feature.graphical.editor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.feature.HyNumberAttribute;

public class DwEditAttributeDefaultDialog extends Dialog {

	private HyNumberAttribute attribute;
	private Text textDefault;
	private int defaultValue;
	
	public DwEditAttributeDefaultDialog(Shell parentShell, HyNumberAttribute attribute) {
		super(parentShell);
		this.attribute = attribute;
	}

	public int getDefaultValue() {
		return defaultValue;
	}

	

	@Override
	protected void okPressed() {
		defaultValue = Integer.parseInt(textDefault.getText());
		super.okPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		composite.setLayout(layout);
		
	    Label label = new Label(composite, SWT.NONE);
	    label.setText("Default:");

	    textDefault = new Text(composite, SWT.BORDER);
	    textDefault.setText(Integer.toString(attribute.getDefault()));
	    textDefault.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				// check that input is a number
				if(!Character.isDigit(e.character)
						&& e.keyCode != SWT.BS
						&& e.keyCode != SWT.DEL) {
					e.doit = false;
				}
				
			}
		});
	    
	    label.pack();
	    textDefault.pack();
	    composite.pack();
		
		return composite;
	}
}

