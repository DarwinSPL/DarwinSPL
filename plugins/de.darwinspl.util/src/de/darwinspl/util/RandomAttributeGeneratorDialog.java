package de.darwinspl.util;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RandomAttributeGeneratorDialog extends Dialog {

	private Text numberOfFeatureAttributesText;
	private Text numberOfFeatureModelAttributesText;
	
	private int numberOfFeatureAttributes;
	private int numberOfFeatureModelAttributes;
	
	protected RandomAttributeGeneratorDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected void okPressed() {
		numberOfFeatureAttributes = Integer.parseInt(numberOfFeatureAttributesText.getText());
		numberOfFeatureModelAttributes = Integer.parseInt(numberOfFeatureModelAttributesText.getText());

		super.okPressed();
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;
		composite.setLayout(layout);

		GridData data = new GridData(GridData.FILL_BOTH);

		Label numberOfFeatureAttributesLabel = new Label(composite, SWT.None);
		numberOfFeatureAttributesLabel.setText("Number of feature attributes");
		numberOfFeatureAttributesLabel.setLayoutData(data);

		numberOfFeatureAttributesText = new Text(composite, SWT.None);
		numberOfFeatureAttributesText.setText("2");
		numberOfFeatureAttributesText.setLayoutData(data);

		Label numberOfFeatureModelAttributesLabel = new Label(composite, SWT.TOP);
		numberOfFeatureModelAttributesLabel.setText("Number of feature model attributes");
		numberOfFeatureModelAttributesLabel.setLayoutData(data);

		numberOfFeatureModelAttributesText = new Text(composite, SWT.TOP);
		numberOfFeatureModelAttributesText.setText("10");
		numberOfFeatureModelAttributesText.setLayoutData(data);
		
		return composite;
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(480, 320);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	public int getNumberOfFeatureAttributes() {
		return numberOfFeatureAttributes;
	}

	public int getNumberOfFeatureModelAttributes() {
		return numberOfFeatureModelAttributes;
	}
}
