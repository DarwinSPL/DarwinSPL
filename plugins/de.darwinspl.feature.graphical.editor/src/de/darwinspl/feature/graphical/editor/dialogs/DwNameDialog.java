package de.darwinspl.feature.graphical.editor.dialogs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;

public class DwNameDialog extends DwTableDialog{

	public DwNameDialog(Shell parentShell) {
		super(parentShell);

		setShellStyle(getShellStyle() | SWT.RESIZE); 
	}

	@Override
	protected String[] getColumnLabels(){
		return new String[]{"Name", "Since", "Until"};
	}	
	
	@Override
	public void setItems(EList<EObject> items) {
		this.items = items;
	}
	
	@Override
	protected String[] getDefaultItemTexts(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String text = dateFormat.format(cal.getTime());

		return new String[]{"New Name", text, text};
	}	

	@Override
	protected void addItem(EObject object){	
		HyName hyName = (HyName)object;
		Date sinceDate = hyName.getValidSince();
		Date untilDate = hyName.getValidUntil();

		String name = hyName.getName();
		String since = (sinceDate == null) ? "" : getDateFormatted(sinceDate, DATE_FORMATTING);
		String until = (untilDate == null) ? "" : getDateFormatted(untilDate, DATE_FORMATTING);

		TableItem item = new TableItem(table, SWT.NONE);
		String[] text = { name, since, until };
		item.setText(text);	
	}

	@Override
	protected void createEditorComponent(TableItem item, final int index){
		
		// Clean up any previous editor control
		Control oldEditor = editor.getEditor();
		if (oldEditor != null) oldEditor.dispose();

		// The control that will be the editor must be a child of the Table
		Text newEditor = new Text(table, SWT.NONE);
		newEditor.setText(item.getText(0));
		newEditor.addModifyListener(new ModifyListener() {


			@Override
			public void modifyText(ModifyEvent e) {
				Text text = (Text)editor.getEditor();
				editor.getItem().setText(0, text.getText());
				
				((HyNamedElement)element).getNames().get(index).setName(text.getText());
			}
		});
		
		newEditor.selectAll();
		newEditor.setFocus();
		editor.setEditor(newEditor, item, 0);				
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		table.addListener(SWT.MouseDoubleClick, new Listener(){
				@Override
				public void handleEvent(Event event) {
					Point pt = new Point(event.x, event.y);
					TableItem item = table.getItem(pt);
					if (item == null)
						return;
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {

							if(i == 1 || i == 2){
								DwDateDialog dialog = new DwDateDialog(getShell(), convertStringToDate(item.getText(i)));
								dialog.open();
								Date value = dialog.getValue();

								if(value != null){							
									int index = table.indexOf(item);
									HyNamedElement e = (HyNamedElement)element;
									if(i == 1){
										e.getNames().get(index).setValidSince(dialog.getValue());
									}else{
										e.getNames().get(index).setValidUntil(dialog.getValue());
									}

									item.setText(i, getDateFormatted(value, DATE_FORMATTING));
								}

							}else{
								createEditorComponent(item, table.indexOf(item));
							}
						}
					}			
				}
		});

		return container;
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Name History");
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent e) {		
		if(e.widget == addTimestamp){
			String newName = "New Name";
			HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
			name.setName(newName);

			((HyNamedElement)element).getNames().add(name);

			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[]{ newName, "", ""});			
		}else{			
			TableItem[] selection = table.getSelection();
			for(int i=0; i<selection.length; i++){
				int index = table.indexOf(selection[i]);
				((HyNamedElement)element).getNames().remove(index);
				table.remove(table.indexOf(selection[i]));
			}
		}
	}		
}



