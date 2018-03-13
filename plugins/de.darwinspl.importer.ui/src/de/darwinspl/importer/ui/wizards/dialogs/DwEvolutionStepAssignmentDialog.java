package de.darwinspl.importer.ui.wizards.dialogs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;

public class DwEvolutionStepAssignmentDialog extends Dialog implements SelectionListener {

	protected List<IFile> files;

	protected SimpleDateFormat sdf;

	protected Map<IFile, Date> fileDateMap;

	protected Map<Button, IFile> buttonFileMap;

	protected Map<Button, IFile> checkboxFileMap;
	
	public DwEvolutionStepAssignmentDialog(Shell parentShell, List<IFile> files, Map<IFile, Date> fileDateMap) {
		super(parentShell);
		
		this.files = files;
		
		if(fileDateMap == null) {
			this.fileDateMap = new HashMap<IFile, Date>();			
		}
		else {
			this.fileDateMap = fileDateMap;
		}
		
		this.buttonFileMap = new HashMap<Button, IFile>();
		this.checkboxFileMap = new HashMap<Button, IFile>();
		this.sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
	}
	
	@Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        
        GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		
		if (files != null) {
			for (IFile file : files) {
				Label filePath = new Label(container, SWT.LEFT);
				filePath.setText(file.getFullPath().toString());

				Button dateSelectionButton = new Button(container, SWT.PUSH);
				dateSelectionButton.setText("Select date of evolution step...");		
				
				dateSelectionButton.addSelectionListener(this);

				Button startModel = new Button(container, SWT.RADIO);
				startModel.setText("Base Model");
				startModel.addSelectionListener(this);
				startModel.setSelection(false);

				buttonFileMap.put(dateSelectionButton, file);
				checkboxFileMap.put(startModel, file);
				
			
				
				if(fileDateMap.containsKey(file)) {
					Date date = fileDateMap.get(file);
					if(date != null) {
						dateSelectionButton.setText(sdf.format(date));
					}
					else {
						startModel.setSelection(true);
						dateSelectionButton.setEnabled(false);
//						dateSelectionButton.setText("Start Model");
					}
				}
			}
		}
        
        return container;
	}

	// overriding this methods allows you to set the
    // title of the custom dialog
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Selection dialog");
    }

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() instanceof Button) {
			Button button = (Button) e.getSource();

			if (buttonFileMap.containsKey(button)) {
				IFile file = buttonFileMap.get(button);

				Date date = new Date();
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				date = cal.getTime();
				DwDateDialog dialog = new DwDateDialog(null, date);
				dialog.open();
				Date value = dialog.getValue();

				if (value != null) {
					fileDateMap.put(file, value);
					button.setText(sdf.format(value));
				}

			} 
			else if (checkboxFileMap.containsKey(button)) {
				IFile file = checkboxFileMap.get(button);

				
				IFile fileToBeRemovedFromFileDateMap = null;
				
				for(Entry<Button, IFile> entry : buttonFileMap.entrySet()) {
					if(entry.getValue() == file) {
						entry.getKey().setEnabled(false);
						entry.getKey().setText("Base Model");
					}
					else {
						entry.getKey().setEnabled(true);
						
						if(fileDateMap.containsKey(entry.getValue()) && fileDateMap.get(entry.getValue())==null) {
							entry.getKey().setText("Select date of evolution step...");
							fileToBeRemovedFromFileDateMap = entry.getValue();
						}
					}
				}
				
				fileDateMap.put(file, null);
				
				if(fileToBeRemovedFromFileDateMap != null) {
					fileDateMap.remove(fileToBeRemovedFromFileDateMap);
				}
			}
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<IFile, Date> getFileDateMap() {
		return fileDateMap;
	}
}
