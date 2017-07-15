package de.darwinspl.util;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.util.RandomAttributeGenerator.Type;

/**
 * Simple dialog that allows the user to the select the desired type of attribute he wants to generate
 * 
 * @author Jeremias Wrensch
 *
 */
public class RandomAttributeGeneratorDialog extends Dialog {

	private CCombo attributeTypeCCombo;
	private Text nameText;
	private String name;
	private RandomAttributeGenerator.Type type;
	
	protected RandomAttributeGeneratorDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected void okPressed() {
		if(attributeTypeCCombo.getSelectionIndex() == 0) {
			type = Type.ENUM;
		} else if(attributeTypeCCombo.getSelectionIndex() == 1) {
			type = Type.BOOLEAN;
		} else if(attributeTypeCCombo.getSelectionIndex() == 2) {
			type = Type.NUMBERED;
		}
		name = nameText.getText();
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

		Label numberOfFeatureAttributesLabel = new Label(composite, SWT.NONE);
		numberOfFeatureAttributesLabel.setText("Number of feature attributes");
		numberOfFeatureAttributesLabel.setLayoutData(data);

		attributeTypeCCombo = new CCombo(composite, SWT.BORDER);
		attributeTypeCCombo.setItems(new String[]{"Enum", "Boolean", "Numbered"});
		attributeTypeCCombo.setLayoutData(data);
		attributeTypeCCombo.select(0);
		
		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setText("Attribute Name:");
		nameLabel.setLayoutData(data);
		
		nameText = new Text(composite, SWT.NONE);
		nameText.setLayoutData(data);
		
		
		return composite;
	}
	

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	public RandomAttributeGenerator.Type getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
}
