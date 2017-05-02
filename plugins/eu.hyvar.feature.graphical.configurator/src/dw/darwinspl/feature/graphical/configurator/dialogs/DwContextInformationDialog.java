package dw.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
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
	
	private Map<HyContextualInformationBoolean, Boolean> booleanValueMap;
	private Map<HyContextualInformationEnum, String> enumValueMap;
	private Map<HyContextualInformationNumber, Integer> numberValueMap;
	
	private Map<HyContextualInformationBoolean, CCombo> booleanComboMap;
	private Map<HyContextualInformationEnum, CCombo> enumComboMap;
	private Map<HyContextualInformationNumber, Text> numberTextMap;
	
	private List<Text> onlyNumericTexts;
	
	public DwContextInformationDialog(Shell parentShell, HyContextModel model, Date date) {
		super(parentShell);
	
		this.model = model;
		this.date = date;
		booleanComboMap = new HashMap<HyContextualInformationBoolean, CCombo>();
		enumComboMap = new HashMap<HyContextualInformationEnum, CCombo>();
		numberTextMap = new HashMap<HyContextualInformationNumber, Text>();
		
		booleanValueMap = new HashMap<HyContextualInformationBoolean, Boolean>();
		enumValueMap = new HashMap<HyContextualInformationEnum, String>();
		numberValueMap = new HashMap<HyContextualInformationNumber, Integer>();
		
		onlyNumericTexts = new ArrayList<Text>();
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
	    	    
	    	    booleanComboMap.put((HyContextualInformationBoolean) information, combo);
	    	    
	    	    editor.grabHorizontal = true;
	    	    editor.setEditor(combo, item, 1);
	    	}else if(information instanceof HyContextualInformationEnum){
	    		HyContextualInformationEnum enumContext = (HyContextualInformationEnum) information;
	    		
	    		editor = new TableEditor(table);
	    	    CCombo combo = new CCombo(table, SWT.NONE);
	    	    combo.setText(enumContext.getEnumType().getLiterals().get(0).getName());
	    		for(HyEnumLiteral literal : enumContext.getEnumType().getLiterals()){
	    			combo.add(literal.getName());
	    		}
	    		
	    		enumComboMap.put(enumContext, combo);
	    		
	    		editor.grabHorizontal = true;
	    	    editor.setEditor(combo, item, 1);
	    	}else if(information instanceof HyContextualInformationNumber){
	    		
	    		HyContextualInformationNumber numberContext = (HyContextualInformationNumber) information;
	    		
	    		editor = new TableEditor(table);
	    	    Text value = new Text(table, SWT.NONE);
	    	    value.setEditable(true);
	    	    value.setText(String.valueOf(numberContext.getMin()));
	    	    value.addModifyListener(this);
	    	    
	    	    onlyNumericTexts.add(value);
	    	    numberTextMap.put(numberContext, value);
	    	    
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
		boolean isOk = true;
		for(Text text: onlyNumericTexts) {
			if(!isNumberic(text.getText())) {
				isOk = false;
			}
		}
		
		if(isOk) {
			for(Entry<HyContextualInformationBoolean, CCombo> entry: booleanComboMap.entrySet()) {
				Boolean bool;
				if(entry.getValue().getText().equals(Boolean.toString(true))) {
					bool = new Boolean(true);
				}
				else {
					bool = new Boolean(false);
				}
				
				booleanValueMap.put(entry.getKey(), bool);
			}
			
			for(Entry<HyContextualInformationEnum, CCombo> entry: enumComboMap.entrySet()) {
				enumValueMap.put(entry.getKey(), entry.getValue().getText());
			}
			
			for(Entry<HyContextualInformationNumber, Text> entry: numberTextMap.entrySet()) {
				Integer i = Integer.parseInt(entry.getValue().getText());
				numberValueMap.put(entry.getKey(), i);
			}
			
			super.okPressed();
		}
	}


	public Map<HyContextualInformationBoolean, Boolean> getBooleanValueMap() {
		return booleanValueMap;
	}


	public Map<HyContextualInformationEnum, String> getEnumValueMap() {
		return enumValueMap;
	}


	public Map<HyContextualInformationNumber, Integer> getNumberValueMap() {
		return numberValueMap;
	}
	
	private boolean isNumberic(String string) {
		try {
			Integer.parseInt(string);
		}
		catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}


	@Override
	public void modifyText(ModifyEvent e) {
		if(onlyNumericTexts.contains(e.getSource())) {
			Text text = (Text) e.getSource();
			String tooltip = "";
			Color background = null;
			if(isNumberic(text.getText())) {
				tooltip = "Only integer values allowed";
				Device device = Display.getCurrent();
				background = new Color(device, 255,0,0);
			}
			else {
				tooltip = "";
			}
			text.setBackground(background);
			text.setToolTipText(tooltip);
		}
	}
}
