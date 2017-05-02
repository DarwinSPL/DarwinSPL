package dw.darwinspl.feature.graphical.editor.dialogs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;


public abstract class DwSelectionDialog extends Dialog implements SelectionListener{
	protected final String DATE_FORMATTING = "MM/dd/yyyy kk:mm:ss";
	
	protected Object element;
	protected Object tempObject;
	
	public Object getElement() {
		return element;
	}

	public static String getDateFormatted(Date date, String formatting){
		if(date == null) return "";
		
		SimpleDateFormat format = new SimpleDateFormat(formatting);
		return format.format(date);
	}
	protected Date convertStringToDate(String text) {
		if(text == null || text.isEmpty() || text.equals("Read Only")) return null;
		
	    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTING, Locale.ENGLISH);
	    try{
	    	return dateFormat.parse(text);
	    }catch(ParseException ex){
	    	ex.printStackTrace();
	    }
	    
	    return null;
	}

	public void setElement(Object element){
		this.element = element;
	}





	protected DwSelectionDialog(Shell parentShell) {
		super(parentShell);
	}
	

	protected abstract void createWidgets(Composite parent);
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		createWidgets(container);
		return container;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(650, 500);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	protected void okPressed(){
		
		super.okPressed();
	}
	
	@Override
	protected void cancelPressed(){

		super.cancelPressed();
	}
	*/
}
