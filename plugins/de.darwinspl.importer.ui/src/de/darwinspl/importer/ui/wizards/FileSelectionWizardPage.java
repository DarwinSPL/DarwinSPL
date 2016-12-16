package de.darwinspl.importer.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class FileSelectionWizardPage extends WizardPage implements SelectionListener {

	protected Composite container;
	
	/**
	 * 
	 * @param pageName
	 * @param description
	 * @param fileExtensionFilter
	 *            Set the file extensions which the dialog will use to filter
	 *            the files it shows to the argument, which may be null. The
	 *            strings are platform specific. For example, on some platforms,
	 *            an extension filter string is typically of the form
	 *            "*.extension", where "*.*" matches all files. For filters with
	 *            multiple extensions, use semicolon as a separator, e.g.
	 *            "*.jpg;*.png". Note: On Mac, setting the file extension filter
	 *            affects how app bundles are treated by the dialog. When a
	 *            filter extension having the app extension (.app) is selected,
	 *            bundles are treated as files. For all other extension filters,
	 *            bundles are treated as directories. When no filter extension
	 *            is set, bundles are treated as files.
	 */
	public FileSelectionWizardPage(String pageName, String description, String[] fileExtensionFilter) {
		super(pageName);
		setDescription(description);
		this.fileExtensionFilter = fileExtensionFilter;
		
		// TODO Auto-generated constructor stub
	}

	protected Label selectedSourceFileLabel;
	protected Text sourceFilePathText;
	protected Button selectFileButton;
	protected String[] fileExtensionFilter;
	private String selectedSourceFile;

	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
		
		
		selectedSourceFileLabel = new Label(container, SWT.LEFT);
		selectedSourceFileLabel.setText("FeatureIDE Feature Model Selected:");

		sourceFilePathText = new Text(container, SWT.BORDER | SWT.SINGLE);

		selectFileButton = new Button(container, SWT.PUSH);
		selectFileButton.setText("Select File...");
		selectFileButton.addSelectionListener(this);
		
		setControl(container);
		// required to avoid an error in the system
		setPageComplete(false);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == selectFileButton) {
			FileDialog sourceFileChooser = new FileDialog(getShell());
			if(fileExtensionFilter != null && fileExtensionFilter.length > 0) {
				sourceFileChooser.setFilterExtensions(fileExtensionFilter);				
			}
			selectedSourceFile = sourceFileChooser.open();
			sourceFilePathText.setText(selectedSourceFile);
			setPageComplete(true);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	public String getSelectedFilePath() {
		return selectedSourceFile;
	}

}
