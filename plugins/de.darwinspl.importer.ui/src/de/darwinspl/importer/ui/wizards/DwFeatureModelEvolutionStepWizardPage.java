package de.darwinspl.importer.ui.wizards;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import de.darwinspl.importer.ui.wizards.dialogs.DwEvolutionStepAssignmentDialog;

public class DwFeatureModelEvolutionStepWizardPage extends WizardPage implements SelectionListener {
	protected Composite container;

	protected List<IFile> files;

	protected Map<IFile, Date> fileDateMap;
	
	protected Button setDatesButton;
	
	protected Label warningLabel;

	public void setFiles(List<IFile> files) {
		this.files = files;
		this.fileDateMap = new HashMap<IFile, Date>();
	}

	public DwFeatureModelEvolutionStepWizardPage(String pageName, List<IFile> files) {
		super(pageName);

		this.files = files;
		this.fileDateMap = new HashMap<IFile, Date>();
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;

		setFiles(files);

		warningLabel = new Label(container, SWT.CENTER);
		Device device = Display.getCurrent ();
		Color red = new Color (device, 255, 0, 0);
		warningLabel.setBackground(red);
		warningLabel.setText("Currently only works for feature models with maximum 1 child group per features (e.g., as in FeatureIDE)");
		
		setDatesButton = new Button(container, SWT.PUSH);
		setDatesButton.setText("Select dates for evolution steps...");
		setDatesButton.addSelectionListener(this);

		setPageComplete(false);

		setControl(container);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == setDatesButton) {
			DwEvolutionStepAssignmentDialog evolutionStepAssignmentDialog = new DwEvolutionStepAssignmentDialog(getShell(), files, fileDateMap);
			
			if(Dialog.OK == evolutionStepAssignmentDialog.open()) {
				this.fileDateMap = evolutionStepAssignmentDialog.getFileDateMap();
			}
			
			if(this.fileDateMap.keySet().containsAll(files)) {
				setPageComplete(true);
			}
			else {
				setPageComplete(false);
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
