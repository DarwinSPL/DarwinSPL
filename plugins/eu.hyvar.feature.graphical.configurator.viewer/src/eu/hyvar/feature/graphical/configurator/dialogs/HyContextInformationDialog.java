package eu.hyvar.feature.graphical.configurator.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.dataValues.HyEnumLiteral;

public class HyContextInformationDialog extends Dialog implements Listener{
	private HyContextModel model;
	
	public HyContextInformationDialog(Shell parentShell, HyContextModel model) {
		super(parentShell);
	
		this.model = model;
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
	    
	    
	    gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;

	    Table table = new Table(container, SWT.SINGLE | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
	    table.setLayoutData(gridData);
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    TableColumn column = new TableColumn(table, SWT.LEFT);	  	
	    column.setText("Contextual Information");
	    column.setWidth(100);
	    column.pack();
	    
	    column = new TableColumn(table, SWT.LEFT);	  	
	    column.setText("Value");
	    column.setWidth(100);
	    column.pack();
	      	      
	    for(HyContextualInformation information : model.getContextualInformations()){
	    	TableItem item = new TableItem(table, SWT.NONE);
	    	TableEditor editor = new TableEditor(table);

    	    Text text = new Text(table,  SWT.NONE);
    	    text.setText(information.getName());
    	    text.setEditable(false);
    	    
    	    editor.grabHorizontal = true;
    	    editor.setEditor(text,item, 0);	    	
	    	
	    	if(information instanceof HyContextualInformationBoolean){
	    		editor = new TableEditor(table);
	    	    CCombo combo = new CCombo(table, SWT.NONE);
	    	    combo.setText("CCombo");
	    	    combo.add(Boolean.toString(true));
	    	    combo.add(Boolean.toString(false));	
	    	    editor.grabHorizontal = true;
	    	    editor.setEditor(combo, item, 1);
	    	}else if(information instanceof HyContextualInformationEnum){
	    		editor = new TableEditor(table);
	    	    CCombo combo = new CCombo(table, SWT.NONE);
	    	    combo.setText(((HyContextualInformationEnum)information).getEnumType().getLiterals().get(0).getName());
	    		for(HyEnumLiteral literal : ((HyContextualInformationEnum)information).getEnumType().getLiterals()){
	    			combo.add(literal.getName());
	    		}
	    		
	    		editor.grabHorizontal = true;
	    	    editor.setEditor(combo, item, 1);
	    	}else if(information instanceof HyContextualInformationNumber){
	    		editor = new TableEditor(table);
	    	    Text value = new Text(table, SWT.NONE);
	    	    value.setEditable(true);
	    	    value.setText(String.valueOf(((HyContextualInformationNumber)information).getMin()));
	    	    
	    	    editor.grabHorizontal = true;
	    	    editor.setEditor(value,item, 1);	
	    	}
	    }

		
	    container.pack();
		return container;
	}

	  @Override
	  protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, "Set Context Information Values", true);
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
		return new Point(480, 340);
	}


	@Override
	public void handleEvent(Event event) {
	}	
	
	@Override
	protected void cancelPressed(){

		super.cancelPressed();
	}
}
