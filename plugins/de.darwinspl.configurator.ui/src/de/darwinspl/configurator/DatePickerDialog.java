package de.darwinspl.configurator;

import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * Simple Dialog that allows the user select a date by using a slider
 * 
 * @author Jeremias Wrensch
 *
 */
public class DatePickerDialog extends Dialog {

	private Scale scale;
	private List<Date> dates;
	private Date selectedDate;
	private Label label;
	
	protected DatePickerDialog(Shell parentShell, List<Date> dates) {
		super(parentShell);
		this.dates = dates;
	}

	
	
	@Override
	protected void okPressed() {
		Date date = dates.get(scale.getSelection());
		label.setText(date.toString());
		super.okPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
	
		label = new Label(composite, SWT.FILL);
		label.setText(dates.get(0).toString());
		
		scale = new Scale(composite, SWT.FILL);
		scale.setMinimum(0);
		scale.setMaximum(dates.size() -1);
		scale.setSelection(0);
		scale.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				selectedDate = dates.get(scale.getSelection());
				label.setText(selectedDate.toString());
				
			}
		});
		
		return composite;
	}
	
	public Date getSelectedDate() {
		return selectedDate;
	}
	
	

}
