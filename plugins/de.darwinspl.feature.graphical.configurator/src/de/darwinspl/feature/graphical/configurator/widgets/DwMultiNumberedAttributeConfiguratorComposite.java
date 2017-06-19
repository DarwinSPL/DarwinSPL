package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.configurator.NumberedAttributeMode;
import eu.hyvar.feature.HyFeatureModel;

public class DwMultiNumberedAttributeConfiguratorComposite extends DwAbstractMultiConfiguratorWidget implements DwConfiguratorWidget {

	private Button useDefault;
	
	private Button min;
	private Button max;
	private Button custom;
	
	private Text customInput;
	
	public DwMultiNumberedAttributeConfiguratorComposite(String attributename, Composite parent, int style, HyFeatureModel featureModel, Date date) {
		super(attributename, parent, style, featureModel, date);
		
		
		useDefault = new Button(this, SWT.CHECK);
		useDefault.setText("Use Default Value");
		
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
	
	public boolean useDefaultValue(){
		return useDefault.getSelection();
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


