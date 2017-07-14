package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.feature.HyFeatureModel;

/**
 * 
 * ui implementation for numbered feature model attribute criterias
 * 
 * @author Jeremias Wrensch
 *
 */
public class DwMultiNumberedCriteriaComposite extends DwAbstractMultiCriteriaComposite implements DwCriteriaComposite {

	private Button useDefault;
	
	private Button min;
	private Button max;
	private Button custom;
	
	private Text customInput;
	
	public DwMultiNumberedCriteriaComposite(String attributename, Composite parent, int style, HyFeatureModel featureModel, Date date) {
		super(attributename, parent, style, featureModel, date);
		
		
		useDefault = new Button(this, SWT.CHECK);
		useDefault.setText("Use Default Value");
		
		min = new Button(this, SWT.RADIO);
		min.setText("Minimize");
		
		max = new Button(this, SWT.RADIO);
		max.setText("Maximize");
		
		custom = new Button(this, SWT.RADIO);
		custom.setText("Custom");
		
		RowData rowData = new RowData();
		rowData.width = 30;
		
		customInput = new Text(this, SWT.BORDER);
		customInput.setText("0");
		customInput.setEditable(true);
		customInput.setLayoutData(rowData);
		
		
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


