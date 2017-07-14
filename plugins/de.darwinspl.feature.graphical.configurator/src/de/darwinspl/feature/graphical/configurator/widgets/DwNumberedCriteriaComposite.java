package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.feature.HyNumberAttribute;

/**
 * 
 * UI implementation for numbered criteria
 * 
 * @author Jeremias Wrensch
 *
 */
public class DwNumberedCriteriaComposite extends DwAbstractCriteriaComposite implements DwCriteriaComposite {

	private Button useDefault;
	
	private Button min;
	private Button max;
	private Button custom;

	private Text customInput;

	/**
	 * 
	 * @param attribute numbered attribute
	 * @param parent
	 * @param style
	 */
	public DwNumberedCriteriaComposite(HyNumberAttribute attribute, Composite parent, int style) {
		super(attribute, parent, style);
		
		
		useDefault = new Button(this, SWT.CHECK);
		useDefault.setText("Use Default Value");
		
		min = new Button(this, SWT.RADIO);
		min.setText("Minimize");
		min.setSelection(true);
		
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
		customInput.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				// check that input is a number
				if(!Character.isDigit(e.character)
						&& e.keyCode != SWT.BS
						&& e.keyCode != SWT.DEL) {
					e.doit = false;
				}
				
			}
		});
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
