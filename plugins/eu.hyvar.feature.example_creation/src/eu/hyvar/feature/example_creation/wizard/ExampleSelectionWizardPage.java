package eu.hyvar.feature.example_creation.wizard;

import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import eu.hyvar.feature.example_creation.examples.HyFMExample;

public class ExampleSelectionWizardPage extends WizardPage implements SelectionListener {

	private final static String TITLE = "HyFM Example Creation";
	private final static String DESCRIPTION = "Select an example to be created!";
	private final Map<String, Class<? extends HyFMExample>> availableExamples;

	private Composite container;

	private Combo combo;

	public ExampleSelectionWizardPage(Map<String, Class<? extends HyFMExample>> availableExamples) {
		super(TITLE);
		setTitle(TITLE);
		setDescription(DESCRIPTION);
		this.availableExamples = availableExamples;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		Label labelExampleSelection = new Label(container, SWT.NONE);
		labelExampleSelection.setText("Select example to be created:");
		combo = new Combo(container, SWT.READ_ONLY);
		if (availableExamples != null) {
			for (String exampleName : availableExamples.keySet()) {
				combo.add(exampleName);
			}
		}

		combo.addSelectionListener(this);

		setControl(container);
		setPageComplete(false);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == combo) {
			setPageComplete(true);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		if (e.getSource() == combo) {
			setPageComplete(true);
		}
	}

	public String getSelection() {
		return combo.getText();
	}
	
}
