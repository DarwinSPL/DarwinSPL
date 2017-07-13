package de.darwinspl.util;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.util.RandomAttributeGenerator.Type;

public class RandomAttributeGeneratorDialog extends Dialog {

	private CCombo attributeTypeCCombo;
	
	RandomAttributeGenerator.Type type;
	
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

		attributeTypeCCombo = new CCombo(composite, SWT.DROP_DOWN);
		attributeTypeCCombo.setItems(new String[]{"Enum", "Boolean", "Numbered"});
		attributeTypeCCombo.setLayoutData(data);
		attributeTypeCCombo.select(0);
		
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
	
	public RandomAttributeGenerator.Type getType() {
		return type;
	}
}
