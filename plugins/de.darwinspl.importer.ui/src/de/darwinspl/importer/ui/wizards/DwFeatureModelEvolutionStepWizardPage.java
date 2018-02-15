package de.darwinspl.importer.ui.wizards;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;

public class DwFeatureModelEvolutionStepWizardPage extends WizardPage implements SelectionListener {

	protected SimpleDateFormat sdf;

	protected Composite container;

	protected List<IFile> files;

	protected Map<IFile, Date> fileDateMap;

	protected Map<Button, IFile> buttonFileMap;

	protected Map<Button, IFile> checkboxFileMap;

	public void setFiles(List<IFile> files) {
		this.files = files;
		this.fileDateMap = new HashMap<IFile, Date>();
		this.buttonFileMap = new HashMap<Button, IFile>();
		this.checkboxFileMap = new HashMap<Button, IFile>();

		container = new Composite(container.getParent(), SWT.NONE);
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

				buttonFileMap.put(dateSelectionButton, file);
				checkboxFileMap.put(startModel, file);
			}
		}

		setPageComplete(false);

		setControl(container);
	}

	public DwFeatureModelEvolutionStepWizardPage(String pageName, List<IFile> files) {
		super(pageName);

		this.files = files;
		this.fileDateMap = new HashMap<IFile, Date>();
		this.buttonFileMap = new HashMap<Button, IFile>();
		this.checkboxFileMap = new HashMap<Button, IFile>();
		this.sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;

		setFiles(files);

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

				buttonFileMap.put(dateSelectionButton, file);
				checkboxFileMap.put(startModel, file);
			}
		}

		setPageComplete(false);

		setControl(container);
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

			} else if (checkboxFileMap.containsKey(button)) {
//				if (button.getSelection()) {
//					IFile file = checkboxFileMap.get(button);
//					fileDateMap.put(file, null);
//
//					for (Entry<Button, IFile> entry : buttonFileMap.entrySet()) {
//						if (entry.getValue().equals(file)) {
//							entry.getKey().setEnabled(false);
//						} else {
//							entry.getKey().setEnabled(true);
//						}
//					}
//				}

				if (fileDateMap.keySet().containsAll(files)) {
					setPageComplete(true);
				}
			}
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	public Map<IFile, Date> getFileDateMap() {
		return this.fileDateMap;
	}

}
