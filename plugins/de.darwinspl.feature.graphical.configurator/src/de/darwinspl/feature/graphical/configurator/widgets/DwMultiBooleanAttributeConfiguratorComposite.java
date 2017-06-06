package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class DwMultiBooleanAttributeConfiguratorComposite extends DwAbstractConfiguratorWidget implements DwConfiguratorWidget {

	Button booleanCheckbox;
	
	public DwMultiBooleanAttributeConfiguratorComposite(String attributename, Composite parent, int style) {
		super(attributename, parent, style);
		
		booleanCheckbox = new Button(this, SWT.CHECK);
		booleanCheckbox.setText("True");
	}
	
	public boolean isTrue() {
		return booleanCheckbox.getSelection();
	}

}
