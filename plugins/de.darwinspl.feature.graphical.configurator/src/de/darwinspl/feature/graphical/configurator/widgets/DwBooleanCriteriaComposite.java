package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.feature.HyBooleanAttribute;

public class DwBooleanCriteriaComposite extends DwAbstractCriteriaComposite implements DwCriteriaComposite {

	private Button checkbox;
	
	public DwBooleanCriteriaComposite(HyBooleanAttribute attribute, Composite parent, int style) {
		super(attribute, parent, style);
		checkbox = new Button(this, SWT.CHECK);
		checkbox.setText("True");
	}
	
	
	public boolean isTrue() {
		return checkbox.getSelection();
	}

}
