package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.feature.HyNumberAttribute;

public class DwSingleNumberedAttributeConfiguratorComposite extends DwAbstractConfiguratorWidget implements DwConfiguratorWidget {

	private Button min;
	private Button max;
	
	public DwSingleNumberedAttributeConfiguratorComposite(HyNumberAttribute attribute, Composite parent, int style) {
		super(attribute, parent, style);
		
		min = new Button(this, SWT.RADIO);
		min.setText("Min");
		max = new Button(this, SWT.RADIO);
		max.setText("Max");
	}

	public ConfiguratorMode getConfiguratorMode() {
		if(min.getSelection()) {
			return ConfiguratorMode.MIN;
		} else {
			return ConfiguratorMode.MAX;
		}
	}
}
