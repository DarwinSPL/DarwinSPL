package de.darwinspl.feature.graphical.editor.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DwObsoleteTimeframeDialog extends DwSelectionDialog {

	private String obsoleteElement;

	public DwObsoleteTimeframeDialog(Shell parentShell, EObject obsoleteElement) {
		super(parentShell);
		this.obsoleteElement = obsoleteElement.toString();
	}

	@Override
	protected void createWidgets(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout containerGrid = new GridLayout(2, false);
		GridData gridData =new GridData(SWT.FILL, SWT.FILL, true, true);
		container.setLayoutData(gridData);
		container.setLayout(containerGrid);
		
		Image image = parent.getDisplay().getSystemImage(SWT.ICON_WARNING);
		Label imageLabel = new Label(container, SWT.NONE);
		imageLabel.setImage(image);
		Composite textGroup = new Composite(container, SWT.NONE);
		GridLayout textGrid = new GridLayout(1, true);
		textGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));
		textGroup.setLayout(textGrid);

		
		

		Label text1 = new Label(textGroup, SWT.WRAP);
		text1.setText("The new feature validity does not overlap with the following name or type validities: ");
		Text text2 = new Text(textGroup, SWT.READ_ONLY | SWT.WRAP | SWT.BORDER);
		text2.setText(obsoleteElement);
		Label text3 = new Label(textGroup, SWT.WRAP);
		text3.setText("Do you want to permanently delete this entry?");
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected Point getInitialSize() {
		final Point size = super.getInitialSize();
		size.x = convertWidthInCharsToPixels(150);

	    size.y = convertHeightInCharsToPixels(15);

	    return size;
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
