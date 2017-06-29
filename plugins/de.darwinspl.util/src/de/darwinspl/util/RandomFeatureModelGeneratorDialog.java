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

public class RandomFeatureModelGeneratorDialog extends Dialog {

	private String name;
	private int numberOfFeatures;
	private int numberOfFeatureAttributes;
	private int numberOfFeatureModelAttributes;
	private int maxSizeOfGroups;

	private Text nameText;
	private Text numberOfFeaturesText;
	private Text numberOfFeatureAttributesText;
	private Text numberOfFeatureModelAttributesText;
	private Text maxSizeOfGroupsText;

	protected RandomFeatureModelGeneratorDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void okPressed() {
		name = nameText.getText();
		numberOfFeatures = Integer.parseInt(numberOfFeaturesText.getText());
		numberOfFeatureAttributes = Integer.parseInt(numberOfFeatureAttributesText.getText());
		numberOfFeatureModelAttributes = Integer.parseInt(numberOfFeatureModelAttributesText.getText());
		maxSizeOfGroups = Integer.parseInt(maxSizeOfGroupsText.getText());

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

		Label nameLabel = new Label(composite, SWT.None);
		nameLabel.setText("Name");
		nameLabel.setLayoutData(data);

		nameText = new Text(composite, SWT.None);
		nameText.setText("2");
		nameText.setLayoutData(data);

		Label numberOfFeaturesLabel = new Label(composite, SWT.TOP);
		numberOfFeaturesLabel.setText("Number of features");
		numberOfFeaturesLabel.setLayoutData(data);

		numberOfFeaturesText = new Text(composite, SWT.TOP);
		numberOfFeaturesText.setText("10");
		numberOfFeaturesText.setLayoutData(data);

		Label numberOfFeatureAttributesLabel = new Label(composite, SWT.None);
		numberOfFeatureAttributesLabel.setText("Number of Feature Attributes");
		numberOfFeatureAttributesLabel.setLayoutData(data);

		numberOfFeatureAttributesText = new Text(composite, SWT.None);
		numberOfFeatureAttributesText.setText("2");
		numberOfFeatureAttributesText.setLayoutData(data);

		Label numberOfFeatureModelAttributesLabel = new Label(composite, SWT.None);
		numberOfFeatureModelAttributesLabel.setText("Number of Feature Model Attributes");
		numberOfFeatureModelAttributesLabel.setLayoutData(data);

		numberOfFeatureModelAttributesText = new Text(composite, SWT.None);
		numberOfFeatureModelAttributesText.setText("2");
		numberOfFeatureModelAttributesText.setLayoutData(data);

		Label maxSizeOfGroupsLabel = new Label(composite, SWT.None);
		maxSizeOfGroupsLabel.setText("Max size of groups");
		maxSizeOfGroupsLabel.setLayoutData(data);

		maxSizeOfGroupsText = new Text(composite, SWT.None);
		maxSizeOfGroupsText.setText("2");
		maxSizeOfGroupsText.setLayoutData(data);

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

	public String getName() {
		return name;
	}

	public int getMaxSizeOfGroups() {
		return maxSizeOfGroups;
	}

	public int getNumberOfFeatures() {
		return numberOfFeatures;
	}

	public int getNumberOfFeatureAttributes() {
		return numberOfFeatureAttributes;
	}

	public int getNumberOfFeatureModelAttributes() {
		return numberOfFeatureModelAttributes;
	}

}
