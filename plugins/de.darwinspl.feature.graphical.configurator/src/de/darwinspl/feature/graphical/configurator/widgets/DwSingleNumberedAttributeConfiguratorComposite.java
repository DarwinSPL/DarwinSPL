package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.configurator.NumberedAttributeMode;
import eu.hyvar.feature.HyNumberAttribute;

public class DwSingleNumberedAttributeConfiguratorComposite extends DwAbstractConfiguratorWidget implements DwConfiguratorWidget {

	private CCombo dropdown;
	
	private Button min;
	private Button max;
	private Button custom;

	private Text customInput;

	
	public DwSingleNumberedAttributeConfiguratorComposite(HyNumberAttribute attribute, Composite parent, int style) {
		super(attribute, parent, style);
		
		
		dropdown = new CCombo(this, SWT.DROP_DOWN);
		dropdown.setItems(new String[]{"Min", "Max", "Default"});
		dropdown.select(0);
		
		min = new Button(this, SWT.RADIO);
		min.setText("Minimize");
		
		max = new Button(this, SWT.RADIO);
		max.setText("Maximize");
		
		custom = new Button(this, SWT.RADIO);
		custom.setText("Custom");
		
		customInput = new Text(this, SWT.NONE);
		customInput.setText("0");
		customInput.setEditable(true);
	}

	public NumberedAttributeMode getSelectedValue(){
		switch (dropdown.getSelectionIndex() ) {
			case 0: return NumberedAttributeMode.MIN;
			case 1: return NumberedAttributeMode.MAX;
			case 2: return NumberedAttributeMode.DEFAULT;
			default: return NumberedAttributeMode.MIN;
		}
	}
	
	public ConfiguratorMode getSelectedMode() {
		if(min.getSelection()) {
			return ConfiguratorMode.MIN;
		} else if(max.getSelection()) {
			return ConfiguratorMode.MAX;
		} else if(custom.getSelection()) {
			return ConfiguratorMode.CUSTOM;
		}
		
		return ConfiguratorMode.MIN;
	}
	
	public int getCustomValue(){
		return Integer.parseInt(customInput.getText());
	}
}
