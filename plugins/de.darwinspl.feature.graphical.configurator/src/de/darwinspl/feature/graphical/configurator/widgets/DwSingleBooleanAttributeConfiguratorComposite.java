package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.feature.HyBooleanAttribute;

public class DwSingleBooleanAttributeConfiguratorComposite extends DwAbstractConfiguratorWidget implements DwConfiguratorWidget {

	private Button booleanCheckbox;
	
	public DwSingleBooleanAttributeConfiguratorComposite(HyBooleanAttribute attribute, Composite parent, int style) {
		super(attribute, parent, style);
		booleanCheckbox = new Button(this, SWT.CHECK);
		booleanCheckbox.setText("True");
	}
	
	
	public boolean isTrue() {
		return booleanCheckbox.getSelection();
	}

}
