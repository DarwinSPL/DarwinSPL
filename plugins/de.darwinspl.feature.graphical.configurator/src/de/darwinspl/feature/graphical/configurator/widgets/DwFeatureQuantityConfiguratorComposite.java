package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

public class DwFeatureQuantityConfiguratorComposite extends DwAbstractConfiguratorWidget implements DwConfiguratorWidget {

	private CCombo dropdown;
	
	public final static int MIN = 0;
	public final static int MAX = 1;
	
	public DwFeatureQuantityConfiguratorComposite(Composite parent, int style) {
		super(parent, style);
		
		String items[] = new String[2];
		items[MIN] = "Min";
		items[MAX] = "Max";
		
		dropdown = new CCombo(this, SWT.DROP_DOWN);
		dropdown.setItems(items);
		dropdown.select(0);
		
		setLabelText("Feature Quantity");
		
	}
	
	public int getSelection() {
		return dropdown.getSelectionIndex();
	}

}
