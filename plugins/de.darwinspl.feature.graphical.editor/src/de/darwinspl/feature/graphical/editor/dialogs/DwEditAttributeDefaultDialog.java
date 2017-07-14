package de.darwinspl.feature.graphical.editor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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
	    textDefault.addListener(SWT.CHANGED, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if(!textDefault.getText().isEmpty())
					defaultValue = Integer.parseInt(textDefault.getText());
			}			
		});	
	    
	    label.pack();
	    textDefault.pack();
	    composite.pack();
		
		return composite;
	}
}

