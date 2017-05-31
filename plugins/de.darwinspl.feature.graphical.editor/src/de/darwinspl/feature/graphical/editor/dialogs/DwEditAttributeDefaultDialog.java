package de.darwinspl.feature.graphical.editor.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.feature.HyNumberAttribute;

public class DwEditAttributeDefaultDialog extends DwSelectionDialog{

	private HyNumberAttribute attribute;
	private Text textDefault;
	private int defaultValue;
	
	public DwEditAttributeDefaultDialog(Shell parentShell) {
		super(parentShell);
	}

	public int getDefaultValue() {
		return defaultValue;
	}
	
	@Override
	public void setElement(Object element) {
		if(element != null && element instanceof HyNumberAttribute) {
			this.attribute = (HyNumberAttribute)element;
		}
		super.setElement(element);
	}

	@Override
	protected void createWidgets(Composite parent) {
		if(attribute != null) {
			
		}
		
	    Label labelForMimimum = new Label(parent, SWT.NULL);
	    labelForMimimum.setText("Default:");
	    
	    textDefault = new Text(parent, SWT.BORDER | SWT.V_SCROLL);
	    textDefault.setText(Integer.toString(attribute.getDefault()));
//	    textDefault.addVerifyListener(new DwNumberAttributeRangeDialog.NumberVerifyListener());	  
	    textDefault.addListener(SWT.CHANGED, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if(!textDefault.getText().isEmpty())
					defaultValue = Integer.parseInt(textDefault.getText());
			}			
		});	
	}
}
