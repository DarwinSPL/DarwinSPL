package de.darwinspl.feature.graphical.base.dialogs;


import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class DwDateDialog extends Dialog implements Listener{

	private DateTime calendarWidget;
	private DateTime timeWidget;

	public DwDateDialog(Shell parentShell, Date date) {
		super(parentShell);
		
		value = (date == null) ? new Date() : date;
	}

	private Date value;

	public Date getValue(){
		return value;
	}
	
	@Override
	protected boolean isResizable() {
	    return true;
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout layout = new GridLayout(1, true);
	    GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
	    container.setLayout(layout);
	    
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(value);
	    
	    calendarWidget = new DateTime (container, SWT.CALENDAR);
	    calendarWidget.setLayoutData(gridData);
	    calendarWidget.addListener(SWT.Selection, this);
	    calendarWidget.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
	    
	    gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = false;

	    
		timeWidget = new DateTime(container, SWT.TIME);
		timeWidget.setLayoutData(gridData);
		timeWidget.addListener(SWT.Selection, this);
		timeWidget.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// dateChanged();
			}
		});
		timeWidget.setTime(calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

		container.pack();
		return container;
	}

	  @Override
	  protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, "Change", true);
	    createButton(parent, IDialogConstants.CANCEL_ID,
	        IDialogConstants.CANCEL_LABEL, false);
	  }	
	
	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Date");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(220, 340);
	}
	
	public void dateChanged(){
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, calendarWidget.getDay());
		instance.set(Calendar.MONTH, calendarWidget.getMonth());
		instance.set(Calendar.YEAR, calendarWidget.getYear());
		instance.set(Calendar.SECOND, timeWidget.getSeconds());
		instance.set(Calendar.MILLISECOND, 0);
		instance.set(Calendar.MINUTE, timeWidget.getMinutes());
		instance.set(Calendar.HOUR, timeWidget.getHours());
		instance.set(Calendar.AM_PM, timeWidget.getHours() <= 12 ? Calendar.AM : Calendar.PM);
//		instance.set(Calendar.HOUR, 0);
//		instance.set(Calendar.MINUTE, 0);
//		instance.set(Calendar.SECOND, 0);
//		instance.set(Calendar.MILLISECOND, 0);
		
		value = instance.getTime(); 	
	}

	@Override
	public void handleEvent(Event event) {
		dateChanged();
	}	
	
	@Override
	protected void cancelPressed(){
		value = null;
		
		super.cancelPressed();
	}
}
