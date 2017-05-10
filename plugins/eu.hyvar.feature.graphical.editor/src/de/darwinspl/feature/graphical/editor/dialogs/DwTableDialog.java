package de.darwinspl.feature.graphical.editor.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class DwTableDialog extends DwSelectionDialog {
	protected Button addTimestamp;
	protected Button removeTimestamp;
	protected Table table;
	

	protected EList<EObject> items;
	protected DwTableDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected TableEditor editor; 
	
	@Override
	protected void createWidgets(Composite parent){

		Composite buttonContainer = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		buttonContainer.setLayout(layout);

		addTimestamp = new Button(buttonContainer, SWT.PUSH);
		addTimestamp.setText("Add");
		addTimestamp.addSelectionListener(this);

		removeTimestamp = new Button(buttonContainer, SWT.PUSH); 
		removeTimestamp.setText("Remove");	    
		removeTimestamp.addSelectionListener(this);

		table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible (true);
		table.setHeaderVisible (true);
		
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;
		
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = getColumnLabels(); 
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}	
		
		
		for(EObject object : items){
			addItem(object);
		}		
		
		table.addListener(SWT.Resize, new Listener(){

			@Override
			public void handleEvent(Event event) {
	            Table table = (Table)event.widget;
	            
	            Rectangle area = table.getClientArea();	            
	            table.getColumns()[0].setWidth(area.width / 3);
	            table.getColumns()[1].setWidth(area.width / 3);
	            table.getColumns()[2].setWidth(area.width / 3);
			}
		});
	}
	

	@Override
	public void widgetDefaultSelected(SelectionEvent e){}

	@Override
	public void widgetSelected(SelectionEvent e) {		
		if(e.widget == addTimestamp){
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(getDefaultItemTexts());			
		}else{			
			TableItem[] selection = table.getSelection();
			for(int i=0; i<selection.length; i++){
				table.remove(table.indexOf(selection[i]));
			}
		}
	}	
	
	protected String[] getColumnLabels(){
		return new String[]{"Column 1", "Column 2", "Column 3"};
	}
	
	protected String[] getDefaultItemTexts(){
		return new String[]{"IText 1", "IText 2", "IText 3"};
	}
	
	public EList<EObject> getItems() {
		return items;
	}


	public void setItems(EList<EObject> items) {
		this.items = items;
	}

	protected void addItem(EObject object){}
	
	
	protected void createEditorComponent(TableItem item, int index){}
}
