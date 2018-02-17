package de.darwinspl.feature.graphical.editor.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DwObsoleteTimeframeDialog extends DwSelectionDialog {

	private String obsoleteElement;

	public DwObsoleteTimeframeDialog(Shell parentShell, String obsoleteElement) {
		super(parentShell);
		this.obsoleteElement = obsoleteElement;
	}

	@Override
	protected void createWidgets(Composite parent) {
		Composite superContainer = new Composite(parent, SWT.NONE);
		GridLayout containerGrid = new GridLayout(1, false);
		superContainer.setLayout(containerGrid);
		Text text1 = new Text(superContainer, SWT.READ_ONLY);
		text1.setText("The new feature validity does not overlap with the following name or type validities: ");
		Text text2 = new Text(superContainer, SWT.READ_ONLY);
		text2.setText(obsoleteElement);
		Text text3 = new Text(superContainer, SWT.READ_ONLY);
		text3.setText("Do you want to permanently delete this entry?");
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}

}
