package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import eu.hyvar.context.information.util.ContextEvolutionUtil;
import eu.hyvar.dataValues.HyEnumLiteral;

public class DwContextInformationDialog extends Dialog implements Listener, ModifyListener{
	private HyContextModel model;
	private Date date;
	
	private Map<HyContextualInformationBoolean, CCombo> booleanValueMap;
    private Map<HyContextualInformationEnum, CCombo> enumValueMap;
    private Map<HyContextualInformationNumber, Text> numberValueMap;
    
    private List<Text> onlyNumberText;
	
	public DwContextInformationDialog(Shell parentShell, HyContextModel model, Date date) {
		super(parentShell);
	
		this.date = date;
		this.model = model;
		
		booleanValueMap = new HashMap<HyContextualInformationBoolean, CCombo>();
		enumValueMap = new HashMap<HyContextualInformationEnum, CCombo>();
		numberValueMap = new HashMap<HyContextualInformationNumber, Text>();
		onlyNumberText = new ArrayList<Text>();
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
	      	      
	    
	    
	    for(HyContextualInformation information : ContextEvolutionUtil.getContextualInformation(model, date)){
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
	    	    
	    	    booleanValueMap.put((HyContextualInformationBoolean) information, combo);
	    	    
	    	    editor.grabHorizontal = true;
	    	    editor.setEditor(combo, item, 1);
	    	}else if(information instanceof HyContextualInformationEnum){
	    		
	    		HyContextualInformationEnum enumContex = (HyContextualInformationEnum) information;
	    		
	    		editor = new TableEditor(table);
	    	    CCombo combo = new CCombo(table, SWT.NONE);
	    	    combo.setText(enumContex.getEnumType().getLiterals().get(0).getName());
	    		for(HyEnumLiteral literal : enumContex.getEnumType().getLiterals()){
	    			combo.add(literal.getName());
	    		}
	    		
	    		enumValueMap.put(enumContex, combo);
	    		
	    		editor.grabHorizontal = true;
	    	    editor.setEditor(combo, item, 1);
	    	}else if(information instanceof HyContextualInformationNumber){
	    		
	    		HyContextualInformationNumber numberContext = (HyContextualInformationNumber) information; 
	    		
	    		editor = new TableEditor(table);
	    	    Text value = new Text(table, SWT.NONE);
	    	    value.addModifyListener(new ModifyListener() {
					
					@Override
					public void modifyText(ModifyEvent e) {
						
					}
				});
	    	    value.setEditable(true);
	    	    value.setText(String.valueOf(numberContext.getMin()));

	    	    onlyNumberText.add(value);
	    	    numberValueMap.put(numberContext, value);
	    	    
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
	
	@Override
	protected void okPressed() {
		
		boolean valuesOk = true;
		
		for(Text text: onlyNumberText) {
			if(!isNumeric(text.getText())) {
				valuesOk = false;
			}
		}
		
		if(!valuesOk) {
			// TODO how to inform user?
		} else {
			super.okPressed();
		}
		
	}


	@Override
	public void modifyText(ModifyEvent e) {
		if(onlyNumberText.contains(e.getSource())) {
			Text text = (Text) e.getSource();
			String tooltip = "";
			if(!isNumeric(text.getText())) {
				tooltip = "Only integer numbers allowed";
			} else {
				tooltip = "";
			}
			text.setToolTipText(tooltip);
		}
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}


	public Map<HyContextualInformationBoolean, CCombo> getBooleanValueMap() {
		return booleanValueMap;
	}


	public Map<HyContextualInformationEnum, CCombo> getEnumValueMap() {
		return enumValueMap;
	}


	public Map<HyContextualInformationNumber, Text> getNumberValueMap() {
		return numberValueMap;
	}
	
	
}
